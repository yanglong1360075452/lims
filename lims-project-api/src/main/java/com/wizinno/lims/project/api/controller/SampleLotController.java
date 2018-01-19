package com.wizinno.lims.project.api.controller;

import com.wizinno.lims.common.constant.Config;
import com.wizinno.lims.common.controller.BaseController;
import com.wizinno.lims.common.data.LogOperateEnum;
import com.wizinno.lims.common.data.LogOperateTypeEnum;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.common.security.UserContext;
import com.wizinno.lims.log.service.aspect.SystemControllerLog;
import com.wizinno.lims.project.api.vo.SampleLotBarListVO;
import com.wizinno.lims.project.api.vo.SampleLotBarVO;
import com.wizinno.lims.project.service.ProjectService;
import com.wizinno.lims.project.service.SampleLotService;
import com.wizinno.lims.project.service.condition.ProjectCondition;
import com.wizinno.lims.project.service.dto.JobDto;
import com.wizinno.lims.project.service.dto.ProjectDto;
import com.wizinno.lims.project.service.dto.SampleLotDto;
import com.wizinno.lims.user.service.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author LiuMei on 2017-07-05.
 */
@RestController
@RequestMapping("/api/sampleLot")
public class SampleLotController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SampleLotService sampleLotService;

    @Autowired
    private UserService userService;

    /**
     * 查询样本批次列表
     *
     * @param projectNo
     * @param sampleLotNo
     * @param sampleLotDesc
     * @param page
     * @param length
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseVO getSampleLots(
            @RequestParam(value = "projectNo", required = false) String projectNo,
            @RequestParam(value = "projectStatus", required = false) List<Integer> projectStatus,
            @RequestParam(value = "sampleLotNo", required = false) String sampleLotNo,
            @RequestParam(value = "sampleLotDesc", required = false) String sampleLotDesc,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "length", defaultValue = "10") int length) {
        ProjectCondition condition = new ProjectCondition();
        condition.setProjectNo(projectNo);
        condition.setSampleLotNo(sampleLotNo);
        condition.setSampleLotDesc(sampleLotDesc);
        condition.setProjectStatus(projectStatus);
        PageRequest request = new PageRequest(page - 1, length);
        return new ResponseVO(sampleLotService.getProjectSampleLotByCondition(condition, request));
    }

    /**
     * 添加样本批次信息
     *
     * @param sampleLotDto
     * @return
     * @throws CustomException
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.SAMPLE_LOT, operate = LogOperateEnum.SAMPLE_LOT_ADD)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseVO addSampleLot(@RequestBody SampleLotDto sampleLotDto) throws CustomException {
        Long sampleCategory = sampleLotDto.getSampleCategory();
        Long species = sampleLotDto.getSpecies();
        Long sampleType = sampleLotDto.getSampleType();
        if (sampleCategory == null || species == null || sampleType == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        Long projectId = sampleLotDto.getProjectId();
        ProjectDto projectDto = projectService.getProjectById(projectId);
        if (projectDto == null) {
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        SampleLotDto sampleLot = projectDto.getSampleLot();
        if (sampleLot != null) {
            throw new CustomException(CustomExceptionCode.RECORD_EXIST);
        }
        long userId = UserContext.getLoginUserID();
        sampleLotDto.setOperator(userService.findSimpleById(userId));
        sampleLotDto.setCreateBy(userId);
        sampleLotDto.setCreateTime(new Date());
        sampleLotDto.setUpdateBy(userId);
        sampleLotDto.setUpdateTime(new Date());
        sampleLotDto.setNo(projectDto.getNo());
        //0--原始样本
        sampleLotDto.setSampleSource(0L);
        Long id = sampleLotService.addOrUpdateSampleLot(sampleLotDto);
        return new ResponseVO(id);
    }

    /**
     * 修改样本批次信息
     *
     * @param sampleLotDto
     * @return
     * @throws CustomException
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.SAMPLE_LOT, operate = LogOperateEnum.SAMPLE_LOT_UPDATE)
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseVO updateSampleLot(@RequestBody SampleLotDto sampleLotDto) throws CustomException {
        Long id = sampleLotDto.getId();
        Long sampleCategory = sampleLotDto.getSampleCategory();
        Long species = sampleLotDto.getSpecies();
        Long sampleType = sampleLotDto.getSampleType();
        if (id == null || sampleCategory == null || species == null || sampleType == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        sampleLotService.getById(id);
        if (sampleLotService.getById(id) == null) {
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        ProjectDto projectDto = projectService.getProjectBySampleLotId(id);
        if (projectDto != null) {
            if (projectService.hadDelivered(projectDto.getId())) {
                throw new CustomException(CustomExceptionCode.STATUS_NOT_MATCH);
            }
        }
        long userId = UserContext.getLoginUserID();
        sampleLotDto.setOperator(userService.findSimpleById(userId));
        sampleLotDto.setCreateBy(userId);
        sampleLotDto.setCreateTime(new Date());
        sampleLotDto.setUpdateBy(userId);
        sampleLotDto.setUpdateTime(new Date());
        sampleLotService.addOrUpdateSampleLot(sampleLotDto);
        return new ResponseVO();
    }

    /**
     * 获取项目样本批次信息
     *
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/{projectId}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseVO getProjectSample(@PathVariable("projectId") long projectId,@RequestParam(value = "sampleLotId", required = false) Long sampleLotId) {
        ProjectDto projectDto = projectService.getProjectById(projectId);
        if (projectDto == null) {
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        SampleLotDto sampleLot;
        if(sampleLotId == null){
            sampleLot = projectDto.getSampleLot();
            if (sampleLot == null) {
                sampleLot = new SampleLotDto();
            } else {
                Long id = sampleLot.getId();
                sampleLot = sampleLotService.getById(id);
            }
        }else {
            sampleLot =  sampleLotService.getById(sampleLotId);
        }
        sampleLot.setProject(projectDto);
        return new ResponseVO(sampleLot);
    }

    /**
     * 获取样本批次信息列表
     *
     * @param projectId
     * @return
     */
    @RequestMapping(value = "/bar/{projectId}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseVO getSampleLotList(@PathVariable("projectId") long projectId) {
        ProjectDto projectDto = projectService.getProjectById(projectId);
        if (projectDto == null) {
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        SampleLotDto sampleLot = projectDto.getSampleLot();
        SampleLotBarListVO sampleLotBarListVO = new SampleLotBarListVO();
        if (sampleLot != null) {
            SampleLotBarVO sampleLotBarVO = new SampleLotBarVO();
            BeanUtils.copyProperties(sampleLot, sampleLotBarVO);
            sampleLotBarListVO.setOriginalSampleLot(sampleLotBarVO);
            //设置工作样本批次
            Set<JobDto> jobs = projectDto.getJobs();
            if (CollectionUtils.isNotEmpty(jobs)) {
                List<SampleLotBarVO> sampleLotBarVOS = new ArrayList<>();
                SampleLotBarVO workSampleLot;
                for (JobDto jobDto : jobs) {
                    SampleLotDto sampleLotDto = sampleLotService.getBySampleSource(jobDto.getId());
                    if (sampleLotDto != null) {
                        workSampleLot = new SampleLotBarVO();
                        BeanUtils.copyProperties(sampleLotDto,workSampleLot);
                        sampleLotBarVOS.add(workSampleLot);
                    }
                }
                sampleLotBarListVO.setWorkSampleLots(sampleLotBarVOS);
            }
        }
        return new ResponseVO(sampleLotBarListVO);
    }

    /**
     * 上传附件
     *
     * @param id
     * @param file
     * @return
     * @throws CustomException
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseVO upload(@RequestParam("id") long id, MultipartFile file) throws CustomException {
        String fileName = file.getOriginalFilename();
        String path = Config.AFFIX_PATH + id;
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String absolutePath = targetFile.getAbsolutePath();
        sampleLotService.updateSampleLotAffix(id, absolutePath);
        return new ResponseVO();
    }

    /**
     * 下载附件
     *
     * @param id
     * @return
     * @throws CustomException
     */
    @RequestMapping(value = "/download/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody
    ResponseEntity download(@PathVariable long id) throws CustomException {
        SampleLotDto sampleLotDto = sampleLotService.getById(id);
        if (sampleLotDto == null) {
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        String affix = sampleLotDto.getAffix();
        if (StringUtils.isNotBlank(affix)) {
            File file = new File(affix);
            HttpHeaders headers = new HttpHeaders();
            //为了解决中文名称乱码问题
            String fileName = null;
            try {
                fileName = new String(file.getName().getBytes("UTF-8"), "iso-8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            headers.setContentDispositionFormData("attachment", fileName);
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            try {
                return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }
}

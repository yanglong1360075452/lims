package com.wizinno.lims.project.api.controller;

import com.wizinno.lims.common.controller.BaseController;
import com.wizinno.lims.common.data.*;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.common.security.UserContext;
import com.wizinno.lims.log.service.aspect.SystemControllerLog;
import com.wizinno.lims.project.service.ProjectService;
import com.wizinno.lims.project.service.SampleService;
import com.wizinno.lims.project.service.condition.ProjectCondition;
import com.wizinno.lims.project.service.dto.JobDto;
import com.wizinno.lims.project.service.dto.ProjectDto;
import com.wizinno.lims.project.service.dto.SampleDto;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author LiuMei on 2017-06-14.
 */
@RestController
@RequestMapping("/api/project")
public class ProjectController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SampleService sampleService;

    /**
     * 新建项目
     *
     * @param projectDto
     * @return
     * @throws CustomException
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.PROJECT, operate = LogOperateEnum.PROJECT_CREATE)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseVO createProject(@RequestBody ProjectDto projectDto) throws CustomException {
        String contractName = projectDto.getContractName();
        String name = projectDto.getName();
        String contractNo = projectDto.getContractNo();
        String customerRepresentative = projectDto.getCustomerRepresentative();
        String customerNo = projectDto.getCustomerNo();
        String customerUnit = projectDto.getCustomerUnit();
        String customerName = projectDto.getCustomerName();
        String customerPhone = projectDto.getCustomerPhone();
        String customerEmail = projectDto.getCustomerEmail();
        Long projectType = projectDto.getProjectType();
        Long priority = projectDto.getPriority();
        Long sampleCategory = projectDto.getSampleCategory();
        Long species = projectDto.getSpecies();
        if (StringUtils.isBlank(contractName) || StringUtils.isBlank(name) || StringUtils.isBlank(contractNo) || StringUtils.isBlank(customerRepresentative) ||
                StringUtils.isBlank(customerNo) || StringUtils.isBlank(customerUnit) || StringUtils.isBlank(customerName) || StringUtils.isBlank(customerPhone) ||
                StringUtils.isBlank(customerEmail) || projectType == null || priority == null || sampleCategory == null || species == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        Set<JobDto> jobs = projectDto.getJobs();
        if (CollectionUtils.isEmpty(jobs)) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        for (JobDto jobDto : jobs) {
            Integer type = jobDto.getType();
            if (type == null) {
                throw new CustomException(CustomExceptionCode.PARAM_ERROR);
            }
            Object params = jobDto.getParams();
            if (!ObjectUtils.allNotNull(params)) {
                throw new CustomException(CustomExceptionCode.PARAM_ERROR);
            }
        }
        long userId = UserContext.getLoginUserID();
        projectDto.setUpdateBy(userId);
        projectDto.setUpdateTime(new Date());
        projectDto = projectService.addOrUpdate(projectDto);
        return new ResponseVO(projectDto);
    }

    /**
     * 更新项目信息
     *
     * @param projectDto
     * @return
     * @throws CustomException
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.PROJECT, operate = LogOperateEnum.PROJECT_UPDATE)
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseVO updateProject(@RequestBody ProjectDto projectDto) throws CustomException {
        Long id = projectDto.getId();
        if (id == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        String contractName = projectDto.getContractName();
        String name = projectDto.getName();
        String contractNo = projectDto.getContractNo();
        String customerRepresentative = projectDto.getCustomerRepresentative();
        String customerNo = projectDto.getCustomerNo();
        String customerUnit = projectDto.getCustomerUnit();
        String customerName = projectDto.getCustomerName();
        String customerPhone = projectDto.getCustomerPhone();
        String customerEmail = projectDto.getCustomerEmail();
        Long projectType = projectDto.getProjectType();
        Long priority = projectDto.getPriority();
        Long sampleCategory = projectDto.getSampleCategory();
        Long species = projectDto.getSpecies();
        if (StringUtils.isBlank(contractName) || StringUtils.isBlank(name) || StringUtils.isBlank(contractNo) || StringUtils.isBlank(customerRepresentative) ||
                StringUtils.isBlank(customerNo) || StringUtils.isBlank(customerUnit) || StringUtils.isBlank(customerName) || StringUtils.isBlank(customerPhone) ||
                StringUtils.isBlank(customerEmail) || projectType == null || priority == null || sampleCategory == null || species == null
                ) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        Set<JobDto> jobs = projectDto.getJobs();
        if (CollectionUtils.isEmpty(jobs)) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        ProjectDto projectById = projectService.getProjectById(id);
        if (projectById == null) {
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        if (projectService.hadDelivered(id)) {
            throw new CustomException(CustomExceptionCode.STATUS_NOT_MATCH);
        }
        long userId = UserContext.getLoginUserID();
        projectDto.setUpdateBy(userId);
        projectDto.setUpdateTime(new Date());
        projectService.addOrUpdate(projectDto);
        return new ResponseVO();
    }

    /**
     * 获取项目列表
     *
     * @param projectStatus
     * @param page
     * @param length
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseVO getProjects(@RequestParam(value = "projectStatus", required = false) List<Integer> projectStatus,
                           @RequestParam(value = "projectNo", required = false) String projectNo,
                           @RequestParam(value = "projectName", required = false) String projectName,
                           @RequestParam(value = "createTime", required = false) Long createTime,
                           @RequestParam(value = "productStatus", required = false) Integer productStatus,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "length", defaultValue = "10") int length) {
        ProjectCondition condition = new ProjectCondition();
        condition.setProjectStatus(projectStatus);
        if (createTime != null) {
            condition.setCreateTime(new Date(createTime));
        }
        condition.setProductStatus(productStatus);
        condition.setProjectName(projectName);
        condition.setProjectNo(projectNo);
        PageRequest request = new PageRequest(page - 1, length, Sort.Direction.DESC, "createTime");
        return new ResponseVO(projectService.getProjectByCondition(condition, request));
    }

    /**
     * 获取项目详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseVO getProject(@PathVariable("id") long id) {
        ProjectDto projectDto = projectService.getProjectById(id);
        return new ResponseVO(projectDto);
    }

    /**
     * 交付生产以前
     * 取消项目
     *
     * @param id
     * @return
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.PROJECT, operate = LogOperateEnum.PROJECT_CANCEL)
    @RequestMapping(value = "/cancel/{id}", method = RequestMethod.POST)
    public ResponseVO cancelProject(@PathVariable("id") long id) {
        ProjectDto projectDto = projectService.getProjectById(id);
        if (projectDto == null) {
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        if (!projectService.hadDelivered(id)) {
            projectService.cancel(id);
        } else {
            throw new CustomException(CustomExceptionCode.STATUS_NOT_MATCH);
        }
        return new ResponseVO();
    }

    /**
     * 项目取消-恢复项目
     *
     * @param id
     * @return
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.PROJECT, operate = LogOperateEnum.PROJECT_RECOVER)
    @RequestMapping(value = "/recover/{id}", method = RequestMethod.POST)
    public ResponseVO recoverProject(@PathVariable("id") long id) {
        Integer status;
        ProjectDto projectDto = projectService.getProjectById(id);
        if (projectDto == null) {
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        Integer projectStatus = projectDto.getProjectStatus();
        if (projectStatus.equals(ProjectStatusEnum.CANCEL.toCode())) {
            //根据样本状态判断恢复之后项目的状态
            List<SampleDto> sampleReceiveList = sampleService.getBySampleLotIdAndSampleStatus(projectDto.getSampleLot().getId(), SampleStatusEnum.RECEIVED.toCode());
            List<SampleDto> sampleList = sampleService.getBySampleLotIdAndSampleStatus(projectDto.getSampleLot().getId(), SampleStatusEnum.BOOK_BUILDING.toCode());
            if (CollectionUtils.isEmpty(sampleList) && CollectionUtils.isNotEmpty(sampleReceiveList)) {
                status = ProjectStatusEnum.SAMPLE_DELIVERY.toCode();
            } else {
                status = ProjectStatusEnum.NEW_PROJECT.toCode();
            }
            projectService.recover(id, status);
        } else {
            throw new CustomException(CustomExceptionCode.STATUS_NOT_MATCH);
        }
        return new ResponseVO(status.toString());
    }

    /**
     * 交付生产
     *
     * @param projectIds
     * @return
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.PROJECT, operate = LogOperateEnum.PROJECT_DELIVERY)
    @RequestMapping(value = "/delivery", method = RequestMethod.POST)
    public ResponseVO deliveryProduct(@RequestBody List<Long> projectIds) {
        if (CollectionUtils.isEmpty(projectIds)) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        projectService.deliveryProduct(projectIds);
        return new ResponseVO();
    }

    /**
     * 取消生产
     *
     * @param id
     * @return
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.PROJECT, operate = LogOperateEnum.CANCEL_PRODUCE)
    @RequestMapping(value = "/cancelProduce/{id}", method = RequestMethod.POST)
    public ResponseVO cancelProduce(@PathVariable("id") long id) {
        ProjectDto projectDto = projectService.getProjectById(id);
        if (projectDto == null) {
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        Integer projectStatus = projectDto.getProjectStatus();
        if (!ProjectStatusEnum.DELIVERED.toCode().equals(projectStatus) && !ProjectStatusEnum.SCHEDULED.toCode().equals(projectStatus)) {
            throw new CustomException(CustomExceptionCode.STATUS_NOT_MATCH);
        }
        projectService.cancelProduce(id);
        return new ResponseVO();
    }

    /**
     * 根据项目编号获取样本数
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/sampleCount", method = RequestMethod.GET)
    public @ResponseBody
    ResponseVO getProjectSampleCount(@PathVariable("id") long id) {
        return new ResponseVO(projectService.countSampleByProjectId(id));
    }

    /**
     * 根据项目编号获取项目信息
     *
     * @param no
     * @return
     */
    @RequestMapping(value = "/get/{no}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseVO getProjectByNo(@PathVariable("no") String no) {
        return new ResponseVO(projectService.getProjectByNo(no));
    }
}

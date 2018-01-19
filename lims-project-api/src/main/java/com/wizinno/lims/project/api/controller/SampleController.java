package com.wizinno.lims.project.api.controller;

import com.wizinno.lims.common.controller.BaseController;
import com.wizinno.lims.common.data.LogOperateEnum;
import com.wizinno.lims.common.data.LogOperateTypeEnum;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.common.security.UserContext;
import com.wizinno.lims.log.service.aspect.SystemControllerLog;
import com.wizinno.lims.project.service.ProjectService;
import com.wizinno.lims.project.service.SampleLotService;
import com.wizinno.lims.project.service.SampleService;
import com.wizinno.lims.project.service.condition.SampleCondition;
import com.wizinno.lims.project.service.dto.ProjectDto;
import com.wizinno.lims.project.service.dto.SampleDto;
import com.wizinno.lims.project.service.dto.SampleLotDto;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author LiuMei on 2017-07-05.
 */
@RestController
@RequestMapping("/api/sample")
public class SampleController extends BaseController {

    @Autowired
    private SampleLotService sampleLotService;

    @Autowired
    private SampleService sampleService;

    @Autowired
    private ProjectService projectService;

    /**
     * 批量操作样本
     * 批量添加或批量编辑
     *
     * @param sampleLotDto
     * @return
     * @throws CustomException
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.SAMPLE, operate = LogOperateEnum.SAMPLE_UPDATE)
    @RequestMapping(value = "/operate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseVO operateSample(@RequestBody SampleLotDto sampleLotDto) throws CustomException {
        Long id = sampleLotDto.getId();
        if (id == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        if (sampleLotService.getById(id) == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        ProjectDto projectDto = projectService.getProjectBySampleLotId(id);
        if (projectDto != null) {
            if (projectService.hadDelivered(projectDto.getId())) {
                throw new CustomException(CustomExceptionCode.STATUS_NOT_MATCH);
            }
        }
        Set<SampleDto> samples = sampleLotDto.getSamples();
        for (SampleDto sampleDto : samples) {
            if (StringUtils.isBlank(sampleDto.getName())) {
                throw new CustomException(CustomExceptionCode.PARAM_ERROR);
            }
        }
        long userId = UserContext.getLoginUserID();
        sampleLotDto.setUpdateTime(new Date());
        sampleLotDto.setUpdateBy(userId);
        sampleService.operateSample(sampleLotDto);
        return new ResponseVO();
    }

    /**
     * 删除样本
     *
     * @param ids
     * @return
     * @throws CustomException
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.SAMPLE, operate = LogOperateEnum.SAMPLE_DELETE)
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    public ResponseVO deleteSamples(@RequestBody @PathVariable("ids") List<Long> ids) throws CustomException {
        if (CollectionUtils.isEmpty(ids)) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        for (long id : ids) {
            SampleDto sampleDto = sampleService.getSampleById(id);
            if (sampleDto != null) {
                ProjectDto projectDto = projectService.getProjectBySampleLotId(sampleDto.getSampleLot().getId());
                if (projectDto != null) {
                    if (projectService.hadDelivered(projectDto.getId())) {
                        throw new CustomException(CustomExceptionCode.STATUS_NOT_MATCH);
                    }
                }
            }
        }
        sampleService.receiveDeleteSample(ids);
        return new ResponseVO();
    }

    /**
     * 根据条件查询样本信息
     *
     * @param filter
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseVO getSampleList(@RequestParam(value = "filter", required = false) String filter,
                             @RequestParam(value = "sampleLotId", required = false) Long sampleLotId,
                             @RequestParam(value = "sampleLotNo", required = false) String sampleLotNo,
                             @RequestParam(value = "sampleNo", required = false) String sampleNo,
                             @RequestParam(value = "projectId", required = false) Long projectId,
                             @RequestParam(value = "sampleCategory", required = false) List<Long> sampleCategory,
                             @RequestParam(value = "sampleStatus", required = false) Integer sampleStatus,
                             @RequestParam(value = "productStatus", required = false) Integer productStatus,
                             @RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "length", defaultValue = "10") int length) {
        SampleCondition condition = new SampleCondition();
        condition.setFilter(filter);
        condition.setSampleLotId(sampleLotId);
        condition.setProjectId(projectId);
        condition.setSampleCategory(sampleCategory);
        condition.setSampleNo(sampleNo);
        condition.setSampleLotNo(sampleLotNo);
        condition.setProductStatus(productStatus);
        condition.setSampleStatus(sampleStatus);
        PageRequest pageRequest = new PageRequest(page - 1, length);
        return new ResponseVO(sampleService.getSamplesByCondition(condition, pageRequest));
    }

    /**
     * 样本接收
     *
     * @param sampleLotId
     * @param sampleIds
     * @return
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.SAMPLE, operate = LogOperateEnum.SAMPLE_RECEIVE)
    @RequestMapping(value = "/receive/{sampleLotId}", method = RequestMethod.POST)
    public ResponseVO receiveSamples(@PathVariable("sampleLotId") long sampleLotId, @RequestBody List<Long> sampleIds) {
        if (sampleIds == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        ProjectDto projectDto = projectService.getProjectBySampleLotId(sampleLotId);
        if (projectDto != null) {
            if (projectService.hadDelivered(projectDto.getId())) {
                throw new CustomException(CustomExceptionCode.STATUS_NOT_MATCH);
            }
        }
        if (CollectionUtils.isEmpty(sampleIds)) {
            SampleCondition sampleCondition = new SampleCondition();
            sampleCondition.setSampleLotId(sampleLotId);
            List<SampleDto> sampleDTOs = sampleService.getSamplesByCondition(sampleCondition);
            if (CollectionUtils.isNotEmpty(sampleDTOs)) {
                for (SampleDto sampleDto : sampleDTOs) {
                    sampleIds.add(sampleDto.getId());
                }
            }
        }
        sampleService.receiveSamples(sampleLotId, sampleIds);
        return new ResponseVO();
    }

    /**
     * 样本退回
     *
     * @param sampleLotId
     * @param sampleIds
     * @return
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.SAMPLE, operate = LogOperateEnum.SAMPLE_REJECT)
    @RequestMapping(value = "/reject/{sampleLotId}", method = RequestMethod.POST)
    public ResponseVO rejectSamples(@PathVariable("sampleLotId") long sampleLotId, @RequestBody List<Long> sampleIds) {
        if (CollectionUtils.isEmpty(sampleIds)) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        ProjectDto projectDto = projectService.getProjectBySampleLotId(sampleLotId);
        if (projectDto != null) {
            if (projectService.hadDelivered(projectDto.getId())) {
                throw new CustomException(CustomExceptionCode.STATUS_NOT_MATCH);
            }
        }
        sampleService.rejectSamples(sampleLotId, sampleIds);
        return new ResponseVO();
    }
}

package com.wizinno.lims.project.api.controller;

import com.wizinno.lims.activ.service.ActivService;
import com.wizinno.lims.activ.service.dto.EndInputDto;
import com.wizinno.lims.activ.service.dto.StartInputDto;
import com.wizinno.lims.activ.service.util.SpringContextUtils;
import com.wizinno.lims.common.controller.BaseController;
import com.wizinno.lims.common.data.LogOperateEnum;
import com.wizinno.lims.common.data.LogOperateTypeEnum;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.log.service.aspect.SystemControllerLog;
import com.wizinno.lims.project.api.vo.ExecutionVO;
import com.wizinno.lims.project.service.SubTaskService;
import com.wizinno.lims.project.service.dto.ExecutionDto;
import com.wizinno.lims.project.service.dto.SubTaskDto;
import com.wizinno.lims.workflow.cfg.service.ActivCfgService;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfActivDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LiuMei
 * @date 2017-12-01.
 */
@RestController
@RequestMapping("/api/task/sub/execution")
public class SubTaskExecutionController extends BaseController{

    @Autowired
    private ActivCfgService activCfgService;

    @Autowired
    private SubTaskService subTaskService;

    /**
     * 开始subTask执行
     *
     * @param executionVO
     * @return
     * @throws CustomException
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.SUB_TASK, operate = LogOperateEnum.SUB_TASK_START)
    @RequestMapping(value = "/start", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseVO executionStart(@RequestBody ExecutionVO executionVO) throws CustomException {
        Long subTaskId = executionVO.getSubTaskId();
        List<Long> sampleIds = executionVO.getSampleIds();
        if (subTaskId == null || CollectionUtils.isEmpty(sampleIds)) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        SubTaskDto subTaskDto = subTaskService.getById(subTaskId);
        if(subTaskDto == null){
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        CfgWfActivDto cfgWfActivDto = activCfgService.findById(subTaskDto.getCfgWfActiv().getId());
        String javaClass = cfgWfActivDto.getJavaClass();
        ActivService activService = (ActivService) SpringContextUtils.getBeanByName(javaClass);
        StartInputDto startInputDto = new StartInputDto();
        startInputDto.setSampleIds(sampleIds);
        startInputDto.setWfCfgWf(subTaskDto.getCfgWf());
        startInputDto.setSubTask(subTaskDto);
        startInputDto.setWfCfgActiv(cfgWfActivDto);
        startInputDto.setExtractMethod(executionVO.getExtractMethod());
        ExecutionDto executionDto = activService.start(startInputDto);
        return new ResponseVO(executionDto);
    }

    /**
     * 结束activ执行
     *
     * @param executionVO
     * @return
     * @throws CustomException
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.SUB_TASK, operate = LogOperateEnum.SUB_TASK_END)
    @RequestMapping(value = "/end", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional(rollbackFor = Exception.class)
    public @ResponseBody
    ResponseVO executionEnd(@RequestBody ExecutionVO executionVO) throws CustomException {
        Long subTaskId = executionVO.getSubTaskId();
        Long executionId = executionVO.getExecutionId();
        Integer executionStatus = executionVO.getExecutionStatus();
        String note = executionVO.getNote();
        if (subTaskId == null || executionId == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        SubTaskDto subTaskDto = subTaskService.getById(subTaskId);
        CfgWfActivDto cfgWfActivDto = activCfgService.findById(subTaskDto.getCfgWfActiv().getId());
        String javaClass = cfgWfActivDto.getJavaClass();
        ActivService activService = (ActivService) SpringContextUtils.getBeanByName(javaClass);
        EndInputDto endInputDto = new EndInputDto();
        endInputDto.setNote(note);
        endInputDto.setExecutionId(executionId);
        endInputDto.setExecutionStatus(executionStatus);
        activService.end(endInputDto);
        return new ResponseVO();
    }

}

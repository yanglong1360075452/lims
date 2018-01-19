package com.wizinno.lims.project.api.controller;

import com.wizinno.lims.common.controller.BaseController;
import com.wizinno.lims.common.data.LogOperateEnum;
import com.wizinno.lims.common.data.LogOperateTypeEnum;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.data.TaskStatusEnum;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.common.security.UserContext;
import com.wizinno.lims.log.service.aspect.SystemControllerLog;
import com.wizinno.lims.project.service.ProjectService;
import com.wizinno.lims.project.service.TaskService;
import com.wizinno.lims.project.service.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author LiuMei
 * @date 2017-11-15.
 */
@RestController
@RequestMapping("/api/task/execution")
public class TaskExecutionController extends BaseController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    /**
     * 任务开始
     * @param id
     * @return
     * @throws CustomException
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.TASK, operate = LogOperateEnum.TASK_START)
    @RequestMapping(value = "/start/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseVO taskStart(@PathVariable("id") long id) throws CustomException {
        TaskDto taskDto = taskService.getById(id);
        if(taskDto == null){
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        Integer taskStatus = taskDto.getStatus();
        if (!taskStatus.equals(TaskStatusEnum.ALLOTTED.toCode())) {
            throw new CustomException(CustomExceptionCode.STATUS_NOT_MATCH);
        }
        taskService.startTask(taskDto);
        return new ResponseVO();
    }

    /**
     * 任务完成
     * @param id
     * @return
     * @throws CustomException
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.TASK, operate = LogOperateEnum.TASK_FINISH)
    @RequestMapping(value = "/finish/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseVO taskFinish(@PathVariable("id") long id) throws CustomException {
        TaskDto taskDto = taskService.getById(id);
        if(taskDto == null){
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        Integer taskStatus = taskDto.getStatus();
        if (!taskStatus.equals(TaskStatusEnum.UNDERWAY.toCode())) {
            throw new CustomException(CustomExceptionCode.STATUS_NOT_MATCH);
        }
        if(!taskService.taskCanFinish(taskDto)){
            throw new CustomException(CustomExceptionCode.CANNOT_OPERATE);
        }
        taskService.completeTask(taskDto);
        return new ResponseVO();
    }

    /**
     * 任务暂停
     * @param id
     * @return
     * @throws CustomException
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.TASK, operate = LogOperateEnum.TASK_PAUSE)
    @RequestMapping(value = "/pause/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseVO taskPause(@PathVariable("id") long id) throws CustomException {
        TaskDto taskDto = taskService.getById(id);
        if(taskDto == null){
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        Integer taskStatus = taskDto.getStatus();
        if (!taskStatus.equals(TaskStatusEnum.UNDERWAY.toCode())) {
            throw new CustomException(CustomExceptionCode.STATUS_NOT_MATCH);
        }
        taskDto.setStatus(TaskStatusEnum.PAUSE.toCode());
        taskDto.setUpdateBy(UserContext.getLoginUserID());
        taskDto.setUpdateTime(new Date());
        taskService.save(taskDto);
        return new ResponseVO();
    }

    /**
     * 任务恢复
     * @param id
     * @return
     * @throws CustomException
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.TASK, operate = LogOperateEnum.TASK_GOON)
    @RequestMapping(value = "/goon/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseVO taskGoon(@PathVariable("id") long id) throws CustomException {
        TaskDto taskDto = taskService.getById(id);
        if(taskDto == null){
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        Integer taskStatus = taskDto.getStatus();
        if (!taskStatus.equals(TaskStatusEnum.PAUSE.toCode())) {
            throw new CustomException(CustomExceptionCode.STATUS_NOT_MATCH);
        }
        taskDto.setStatus(TaskStatusEnum.UNDERWAY.toCode());
        taskDto.setUpdateBy(UserContext.getLoginUserID());
        taskDto.setUpdateTime(new Date());
        taskService.save(taskDto);
        return new ResponseVO();
    }

    /**
     * 任务终止
     * @param id
     * @return
     * @throws CustomException
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.TASK, operate = LogOperateEnum.TASK_TERMINATION)
    @RequestMapping(value = "/termination/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseVO taskTermination(@PathVariable("id") long id) throws CustomException {
        TaskDto taskDto = taskService.getById(id);
        if(taskDto == null){
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        taskDto.setStatus(TaskStatusEnum.TERMINATION.toCode());
        taskDto.setUpdateBy(UserContext.getLoginUserID());
        taskDto.setUpdateTime(new Date());
        taskService.save(taskDto);
        return new ResponseVO();
    }
}

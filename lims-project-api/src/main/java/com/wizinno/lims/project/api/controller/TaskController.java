package com.wizinno.lims.project.api.controller;

import com.wizinno.lims.common.controller.BaseController;
import com.wizinno.lims.common.data.LogOperateEnum;
import com.wizinno.lims.common.data.LogOperateTypeEnum;
import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.log.service.aspect.SystemControllerLog;
import com.wizinno.lims.project.api.vo.DispatchVO;
import com.wizinno.lims.project.service.ProjectService;
import com.wizinno.lims.project.service.TaskService;
import com.wizinno.lims.project.service.condition.TaskCondition;
import com.wizinno.lims.project.service.dto.ProjectDto;
import com.wizinno.lims.project.service.dto.TaskDto;
import com.wizinno.lims.user.service.dto.UserSimpleDto;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LiuMei on 2017-07-18.
 */
@RestController
@RequestMapping("/api/task")
public class TaskController extends BaseController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    /**
     * 根据任务列表
     *
     * @param projectNo
     * @param page
     * @param length
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ResponseVO getTasks(@RequestParam(value = "projectNo", required = false) String projectNo,
                        @RequestParam(value = "projectId", required = false) Long projectId,
                        @RequestParam(value = "operator", required = false) Long operator,
                        @RequestParam(value = "taskId", required = false) Long taskId,
                        @RequestParam(value = "projectName", required = false) String projectName,
                        @RequestParam(value = "projectStatus", required = false) Integer projectStatus,
                        @RequestParam(value = "taskStatus", required = false) Integer taskStatus,
                        @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "length", defaultValue = "10") int length) {
        TaskCondition condition = new TaskCondition();
        condition.setProjectNo(projectNo);
        condition.setOperator(operator);
        condition.setTaskId(taskId);
        condition.setProjectName(projectName);
        condition.setProjectStatus(projectStatus);
        condition.setTaskStatus(taskStatus);
        condition.setProjectId(projectId);
        PageRequest request = new PageRequest(page - 1, length);
        PageData<TaskDto> task = taskService.getByCondition(condition, request);
        return new ResponseVO(task);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public @ResponseBody
    ResponseVO getTaskById(@PathVariable("id") long id) {
        return new ResponseVO(taskService.getById(id));
    }

    /**
     * 任务调度
     * @param projectId
     * @param dispatchVO
     * @return
     */
    @SystemControllerLog(operateType = LogOperateTypeEnum.TASK, operate = LogOperateEnum.TASK_DISPATCH)
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseVO dispatchTask(@PathVariable(value = "id") long projectId, @RequestBody DispatchVO dispatchVO) {
        if(dispatchVO == null){
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        List<TaskDto> taskDTOs = dispatchVO.getTaskList();
        if (CollectionUtils.isEmpty(taskDTOs)) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        ProjectDto projectDto = projectService.getProjectById(projectId);
        if (projectDto == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        for(TaskDto taskDto : taskDTOs){
            Integer sampleAmount = taskDto.getSampleAmount();
            UserSimpleDto operator = taskDto.getOperator();
            Integer planLaborHour = taskDto.getPlanLaborHour();
            CfgWfDto workflow = taskDto.getWorkflow();
            if(sampleAmount == null || sampleAmount < 0 || operator == null || operator.getId() == null || planLaborHour == null || planLaborHour < 0
                    || workflow == null || workflow.getId() == null){
                throw new CustomException(CustomExceptionCode.PARAM_ERROR);
            }
        }
        taskService.dispatchTask(projectDto.getId(), taskDTOs,dispatchVO.getDeleteList());
        return new ResponseVO();
    }

}

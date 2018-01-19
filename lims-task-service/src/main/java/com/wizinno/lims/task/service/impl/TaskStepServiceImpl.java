package com.wizinno.lims.task.service.impl;

import com.wizinno.lims.task.domain.Task;
import com.wizinno.lims.task.domain.TaskStep;
import com.wizinno.lims.task.repository.TaskStepRepository;
import com.wizinno.lims.task.service.TaskService;
import com.wizinno.lims.task.service.TaskStepService;
import com.wizinno.lims.task.service.dto.TaskStepDto;
import com.wizinno.lims.workflow.cfg.domain.WfCfgActiv;
import com.wizinno.lims.workflow.cfg.domain.WfCfgWf;
import com.wizinno.lims.workflow.cfg.service.ActivCfgService;
import com.wizinno.lims.workflow.cfg.service.WorkflowCfgService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author LiuMei
 * @date 2017-11-14.
 */
public class TaskStepServiceImpl<T> implements TaskStepService<T> {

    @Autowired
    private TaskStepRepository taskStepRepository;

    @Autowired
    private TaskService taskService;

    @Autowired
    private WorkflowCfgService workflowCfgService;

    @Autowired
    private ActivCfgService activCfgService;

    @Override
    public TaskStepDto save(TaskStepDto taskStepDto) {
        if(taskStepDto != null){
            TaskStep result = taskStepRepository.save((TaskStep) taskStepDtoToPo(taskStepDto));
            taskStepDto.setId(result.getId());
        }
        return taskStepDto;
    }

    @Override
    public TaskStepDto getById(long stepId) {
        TaskStep taskStep = taskStepRepository.findOne(stepId);
        return taskStepToDto(taskStep);
    }

    @Override
    public TaskStepDto taskStepToDto(Object taskStep) {
        TaskStepDto taskStepDto = null;
        if(taskStep != null){
            taskStepDto = new TaskStepDto();
            TaskStep data = (TaskStep) taskStep;
            BeanUtils.copyProperties(data,taskStepDto);
            taskStepDto.setTask(taskService.taskToDto(data.getTask()));
            taskStepDto.setWfCfgWf(workflowCfgService.wfCfgWfPoToDto(data.getWfCfgWf()));
            taskStepDto.setWfCfgActiv(activCfgService.wfCfgActivToDto(data.getWfCfgActiv()));
        }
        return taskStepDto;
    }

    @Override
    public T taskStepDtoToPo(TaskStepDto taskStepDto) {
        TaskStep taskStep = null;
        if(taskStepDto != null){
            taskStep = new TaskStep();
            BeanUtils.copyProperties(taskStepDto,taskStep);
            taskStep.setTask((Task) taskService.taskDtoToPO(taskStepDto.getTask()));
            taskStep.setWfCfgWf((WfCfgWf) workflowCfgService.wfCfgWfDtoToPo(taskStepDto.getWfCfgWf()));
            taskStep.setWfCfgActiv((WfCfgActiv) activCfgService.wfCfgActivDtoToPo(taskStepDto.getWfCfgActiv()));
        }
        return (T) taskStep;
    }
}

package com.wizinno.lims.project.service.impl;

import com.wizinno.lims.project.domain.SubTask;
import com.wizinno.lims.project.domain.Task;
import com.wizinno.lims.project.repository.SubTaskRepository;
import com.wizinno.lims.project.service.SubTaskService;
import com.wizinno.lims.project.service.TaskService;
import com.wizinno.lims.project.service.dto.SubTaskDto;
import com.wizinno.lims.workflow.cfg.domain.CfgWf;
import com.wizinno.lims.workflow.cfg.domain.CfgWfActiv;
import com.wizinno.lims.workflow.cfg.service.ActivCfgService;
import com.wizinno.lims.workflow.cfg.service.WorkflowCfgService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiuMei
 * @date 2017-11-14.
 */
@Service
public class SubTaskServiceImpl<T> implements SubTaskService<T> {

    @Autowired
    private SubTaskRepository subTaskRepository;

    @Autowired
    private TaskService taskService;

    @Autowired
    private WorkflowCfgService workflowCfgService;

    @Autowired
    private ActivCfgService activCfgService;

    @Override
    public SubTaskDto save(SubTaskDto subTaskDto) {
        if(subTaskDto != null){
            SubTask result = subTaskRepository.save((SubTask) subTaskDtoToPo(subTaskDto));
            subTaskDto.setId(result.getId());
        }
        return subTaskDto;
    }

    @Override
    public SubTaskDto getById(long subTaskId) {
        SubTask SubTask = subTaskRepository.findOne(subTaskId);
        return subTaskToDto(SubTask);
    }

    @Override
    public Long getLastSubTaskByTaskId(long taskId) {
        return subTaskRepository.selectLastByTaskId(taskId);
    }

    @Override
    public SubTaskDto subTaskToDto(Object subTask) {
        SubTaskDto subTaskDto = null;
        if(subTask != null){
            subTaskDto = new SubTaskDto();
            SubTask data = (SubTask) subTask;
            BeanUtils.copyProperties(data, subTaskDto);
            subTaskDto.setTask(taskService.taskToDto(data.getTask()));
            subTaskDto.setCfgWf(workflowCfgService.wfCfgWfPoToDto(data.getCfgWf()));
            subTaskDto.setCfgWfActiv(activCfgService.wfCfgActivToDto(data.getCfgWfActiv()));
        }
        return subTaskDto;
    }

    @Override
    public T subTaskDtoToPo(SubTaskDto subTaskDto) {
        SubTask subTask = null;
        if(subTaskDto != null){
            subTask = new SubTask();
            BeanUtils.copyProperties(subTaskDto, subTask);
            subTask.setTask((Task) taskService.taskDtoToPO(subTaskDto.getTask()));
            subTask.setCfgWf((CfgWf) workflowCfgService.wfCfgWfDtoToPo(subTaskDto.getCfgWf()));
            subTask.setCfgWfActiv((CfgWfActiv) activCfgService.wfCfgActivDtoToPo(subTaskDto.getCfgWfActiv()));
        }
        return (T) subTask;
    }
}

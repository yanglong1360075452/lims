package com.wizinno.lims.project.service.impl;

import com.wizinno.lims.project.domain.Execution;
import com.wizinno.lims.project.domain.SubTask;
import com.wizinno.lims.project.repository.ExecutionRepository;
import com.wizinno.lims.project.service.ExecutionService;
import com.wizinno.lims.project.service.SubTaskService;
import com.wizinno.lims.project.service.dto.ExecutionDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiuMei
 * @date 2017-11-14.
 */
@Service
public class ExecutionServiceImpl<T> implements ExecutionService<T> {

    @Autowired
    private ExecutionRepository executionRepository;

    @Autowired
    private SubTaskService subTaskService;

    @Override
    public ExecutionDto save(ExecutionDto executionDto) {
        if (executionDto != null) {
            Execution result = executionRepository.save((Execution) executionDtoToPo(executionDto));
            executionDto.setId(result.getId());
        }
        return executionDto;
    }

    @Override
    public ExecutionDto getById(long executionId) {
        Execution Execution = executionRepository.findOne(executionId);
        return executionToDto(Execution);
    }

    @Override
    public ExecutionDto getLastExecutionByTaskId(long taskId) {
        return executionToDto(executionRepository.selectLastByTaskId(taskId));
    }

    @Override
    public ExecutionDto executionToDto(Object execution) {
        ExecutionDto executionDto = null;
        if (execution != null) {
            executionDto = new ExecutionDto();
            Execution data = (Execution) execution;
            BeanUtils.copyProperties(data, executionDto);
            executionDto.setSubTask(subTaskService.subTaskToDto(data.getSubTask()));
        }
        return executionDto;
    }

    @Override
    public T executionDtoToPo(ExecutionDto executionDto) {
        Execution execution = null;
        if (executionDto != null) {
            execution = new Execution();
            BeanUtils.copyProperties(executionDto, execution);
            execution.setSubTask((SubTask) subTaskService.subTaskDtoToPo(executionDto.getSubTask()));
        }
        return (T) execution;
    }
}

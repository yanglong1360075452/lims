package com.wizinno.lims.project.service.dto;

import com.wizinno.lims.common.domain.BaseDto;

/**
 * @author LiuMei on 2017-07-24.
 */
public class ExecutionSampleDto extends BaseDto {

    private SubTaskDto subTask;

    private SampleDto sample;

    private ExecutionDto execution;

    public SubTaskDto getSubTask() {
        return subTask;
    }

    public void setSubTask(SubTaskDto subTask) {
        this.subTask = subTask;
    }

    public ExecutionDto getExecution() {
        return execution;
    }

    public void setExecution(ExecutionDto execution) {
        this.execution = execution;
    }

    public SampleDto getSample() {
        return sample;
    }

    public void setSample(SampleDto sample) {
        this.sample = sample;
    }

}

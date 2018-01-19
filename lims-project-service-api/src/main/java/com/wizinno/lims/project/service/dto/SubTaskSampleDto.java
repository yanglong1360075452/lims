package com.wizinno.lims.project.service.dto;

/**
 * @author LiuMei on 2017-07-24.
 */
public class SubTaskSampleDto {

    private SubTaskDto subTask;

    private SampleDto sample;

    private JobDto job;

    public JobDto getJob() {
        return job;
    }

    public void setJob(JobDto job) {
        this.job = job;
    }

    public SubTaskDto getSubTask() {
        return subTask;
    }

    public void setSubTask(SubTaskDto subTask) {
        this.subTask = subTask;
    }

    public SampleDto getSample() {
        return sample;
    }

    public void setSample(SampleDto sample) {
        this.sample = sample;
    }

}

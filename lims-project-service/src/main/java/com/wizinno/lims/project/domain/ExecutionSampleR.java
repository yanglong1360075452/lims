package com.wizinno.lims.project.domain;

import com.wizinno.lims.common.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author LiuMei on 2017-07-21.
 */
@Entity
@Table(name = "execution_sample_r")
public class ExecutionSampleR extends BaseEntity{

    /**
     * 冗余一个subTaskID,方便后续查询
     */
    @ManyToOne
    @JoinColumn(name = "subtask_id",nullable = false)
    private SubTask subTask;

    @ManyToOne
    @JoinColumn(name = "execution_id",nullable = false)
    private Execution execution;

    @ManyToOne
    @JoinColumn(name = "sample_id",nullable = false)
    private Sample sample;

    public Execution getExecution() {
        return execution;
    }

    public void setExecution(Execution execution) {
        this.execution = execution;
    }

    public Sample getSample() {
        return sample;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    public SubTask getSubTask() {
        return subTask;
    }

    public void setSubTask(SubTask subTask) {
        this.subTask = subTask;
    }
}

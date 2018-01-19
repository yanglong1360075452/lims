package com.wizinno.lims.task.domain;

import com.wizinno.lims.common.domain.BaseEntity;
import com.wizinno.lims.project.domain.Sample;

import javax.persistence.*;

/**
 * @author LiuMei on 2017-07-21.
 */
@Entity
@Table(name = "task_sample")
public class TaskSample extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "task_id",nullable = false)
    private Task task;

    @ManyToOne
    @JoinColumn(name = "sample_id",nullable = false)
    private Sample sample;

    /**
     * 样本用量
     */
    private String dosage;

    /**
     * 备注
     */
    private String note;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Sample getSample() {
        return sample;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}

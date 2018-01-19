package com.wizinno.lims.task.service.dto;

import com.wizinno.lims.common.domain.BaseDto;
import com.wizinno.lims.project.service.dto.SampleDto;

/**
 * @author LiuMei on 2017-07-24.
 */
public class TaskSampleDto extends BaseDto {

    private TaskDto task;

    private SampleDto sample;

    /**
     * 样本用量
     */
    private String dosage;

    /**
     * 备注
     */
    private String note;

    public TaskDto getTask() {
        return task;
    }

    public void setTask(TaskDto task) {
        this.task = task;
    }

    public SampleDto getSample() {
        return sample;
    }

    public void setSample(SampleDto sample) {
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

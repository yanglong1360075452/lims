package com.wizinno.lims.tracking.service.dto;

import com.wizinno.lims.project.service.dto.ProjectDto;
import com.wizinno.lims.project.service.dto.SampleDto;
import com.wizinno.lims.project.service.dto.SampleLotDto;
import com.wizinno.lims.project.service.dto.TaskDto;

import java.util.Date;

/**
 * @author LiuMei on 2017-08-10.
 */
public class TrackingDto {

    private Long id;

    private Integer type;
    private String typeDesc;

    private Integer operate;
    private String operateDesc;

    private ProjectDto project;

    private SampleLotDto sampleLot;

    private SampleDto sample;

    private TaskDto task;

    private String note;

    private Long createBy;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public Integer getOperate() {
        return operate;
    }

    public void setOperate(Integer operate) {
        this.operate = operate;
    }

    public String getOperateDesc() {
        return operateDesc;
    }

    public void setOperateDesc(String operateDesc) {
        this.operateDesc = operateDesc;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }

    public SampleLotDto getSampleLot() {
        return sampleLot;
    }

    public void setSampleLot(SampleLotDto sampleLot) {
        this.sampleLot = sampleLot;
    }

    public SampleDto getSample() {
        return sample;
    }

    public void setSample(SampleDto sample) {
        this.sample = sample;
    }

    public TaskDto getTask() {
        return task;
    }

    public void setTask(TaskDto task) {
        this.task = task;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

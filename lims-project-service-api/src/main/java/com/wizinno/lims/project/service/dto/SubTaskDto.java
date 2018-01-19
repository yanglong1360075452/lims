package com.wizinno.lims.project.service.dto;

import com.wizinno.lims.common.domain.BaseDto;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfActivDto;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfDto;

import java.util.Date;

/**
 * @author LiuMei
 * @date 2017-11-14.
 */
public class SubTaskDto extends BaseDto {

    /**
     * 任务
     */
    private TaskDto task;

    /**
     * 工作流
     */
    private CfgWfDto cfgWf;

    /**
     * 活动
     */
    private CfgWfActivDto cfgWfActiv;

    /**
     * 工作流名称
     * 记录运行当时工作流名称
     */
    private String wfName;

    /**
     * 工作流版本
     * 记录运行当时工作流版本
     */
    private String wfVer;

    /**
     * 活动名称
     * 记录运行当时活动名称
     */
    private String activName;

    /**
     * 活动版本
     * 记录运行当时活动版本
     */
    private String activVer;

    /**
     * 子任务开始时间
     */
    private Date startTime;

    /**
     * 子任务结束时间
     */
    private Date endTime;

    /**
     * 操作者
     */
    private Long operator;

    /**
     * 上一子任务ID
     */
    private Long preSubTaskId;

    /**
     * 使用的样本数
     */
    private Integer sampleCount;

    /**
     * 操作完成的样本数
     */
    private Integer finishSampleCount;

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

    public CfgWfDto getCfgWf() {
        return cfgWf;
    }

    public void setCfgWf(CfgWfDto cfgWf) {
        this.cfgWf = cfgWf;
    }

    public CfgWfActivDto getCfgWfActiv() {
        return cfgWfActiv;
    }

    public void setCfgWfActiv(CfgWfActivDto cfgWfActiv) {
        this.cfgWfActiv = cfgWfActiv;
    }

    public String getWfName() {
        return wfName;
    }

    public void setWfName(String wfName) {
        this.wfName = wfName;
    }

    public String getWfVer() {
        return wfVer;
    }

    public void setWfVer(String wfVer) {
        this.wfVer = wfVer;
    }

    public String getActivName() {
        return activName;
    }

    public void setActivName(String activName) {
        this.activName = activName;
    }

    public String getActivVer() {
        return activVer;
    }

    public void setActivVer(String activVer) {
        this.activVer = activVer;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public Long getPreSubTaskId() {
        return preSubTaskId;
    }

    public void setPreSubTaskId(Long preSubTaskId) {
        this.preSubTaskId = preSubTaskId;
    }

    public Integer getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(Integer sampleCount) {
        this.sampleCount = sampleCount;
    }

    public Integer getFinishSampleCount() {
        return finishSampleCount;
    }

    public void setFinishSampleCount(Integer finishSampleCount) {
        this.finishSampleCount = finishSampleCount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

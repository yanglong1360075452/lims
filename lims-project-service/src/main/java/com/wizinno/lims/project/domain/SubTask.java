package com.wizinno.lims.project.domain;

import com.wizinno.lims.common.domain.BaseEntity;
import com.wizinno.lims.workflow.cfg.domain.CfgWf;
import com.wizinno.lims.workflow.cfg.domain.CfgWfActiv;

import javax.persistence.*;
import java.util.Date;

/**
 * 任务执行
 * @author LiuMei
 * @date 2017-11-14.
 */
@Entity
@Table(name = "subtask")
public class SubTask extends BaseEntity{

    /**
     * 任务
     */
    @ManyToOne
    @JoinColumn(name="task_id",nullable = false)
    private Task task;

    /**
     * 工作流
     */
    @ManyToOne
    @JoinColumn(name = "wf_id",columnDefinition="bigint(20) not null COMMENT '工作流ID'")
    private CfgWf cfgWf;

    /**
     * 活动
     */
    @ManyToOne
    @JoinColumn(name = "activ_id",nullable = false)
    private CfgWfActiv cfgWfActiv;

    /**
     * 工作流名称
     * 记录运行当时工作流名称
     */
    @Column(name="wf_name")
    private String wfName;

    /**
     * 工作流版本
     * 记录运行当时工作流版本
     */
    @Column(name="wf_ver")
    private String wfVer;

    /**
     * 活动名称
     * 记录运行当时活动名称
     */
    @Column(name="activ_name")
    private String activName;

    /**
     * 活动版本
     * 记录运行当时活动版本
     */
    @Column(name="activ_ver")
    private String activVer;

    /**
     * 子任务开始时间
     */
    @Column(name="start_time")
    private Date startTime;

    /**
     * 子任务结束时间
     */
    @Column(name="end_time")
    private Date endTime;

    /**
     * 操作者
     */
    private Long operator;

    /**
     * 上一子任务ID
     */
    @Column(name="pre_subtask_id")
    private Long preSubTaskId;

    /**
     * 备注
     */
    private String note;

    /**
     * 使用的样本数
     */
    private Integer sampleCount;

    /**
     * 操作完成的样本数
     */
    private Integer finishSampleCount;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public CfgWf getCfgWf() {
        return cfgWf;
    }

    public void setCfgWf(CfgWf cfgWf) {
        this.cfgWf = cfgWf;
    }

    public CfgWfActiv getCfgWfActiv() {
        return cfgWfActiv;
    }

    public void setCfgWfActiv(CfgWfActiv cfgWfActiv) {
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

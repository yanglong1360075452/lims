package com.wizinno.lims.task.domain;

import com.wizinno.lims.common.domain.BaseEntity;
import com.wizinno.lims.workflow.cfg.domain.WfCfgActiv;
import com.wizinno.lims.workflow.cfg.domain.WfCfgWf;

import javax.persistence.*;
import java.util.Date;

/**
 * 任务执行步骤
 * @author LiuMei
 * @date 2017-11-14.
 */
@Entity
@Table(name = "task_step")
public class TaskStep extends BaseEntity{

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
    private WfCfgWf wfCfgWf;

    /**
     * 活动
     */
    @ManyToOne
    @JoinColumn(name = "activ_id",nullable = false)
    private WfCfgActiv wfCfgActiv;

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
     * 步骤执行开始时间
     */
    @Column(name="start_time")
    private Date startTime;

    /**
     * 步骤执行结束时间
     */
    @Column(name="end_time")
    private Date endTime;

    /**
     * 操作者
     */
    private Long operator;

    /**
     * 样本用量
     */
    private Double dosage;

    /**
     * 上一步骤ID
     */
    @Column(name="pre_step_id")
    private Long preStepId;

    /**
     * 运行状态
     */
    private Integer status;

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

    public WfCfgWf getWfCfgWf() {
        return wfCfgWf;
    }

    public void setWfCfgWf(WfCfgWf wfCfgWf) {
        this.wfCfgWf = wfCfgWf;
    }

    public WfCfgActiv getWfCfgActiv() {
        return wfCfgActiv;
    }

    public void setWfCfgActiv(WfCfgActiv wfCfgActiv) {
        this.wfCfgActiv = wfCfgActiv;
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

    public Double getDosage() {
        return dosage;
    }

    public void setDosage(Double dosage) {
        this.dosage = dosage;
    }

    public Long getPreStepId() {
        return preStepId;
    }

    public void setPreStepId(Long preStepId) {
        this.preStepId = preStepId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

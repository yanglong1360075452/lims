package com.wizinno.lims.task.service.dto;

import com.wizinno.lims.common.domain.BaseDto;
import com.wizinno.lims.workflow.cfg.service.dto.WfCfgActivDto;
import com.wizinno.lims.workflow.cfg.service.dto.WfCfgWfDto;

import java.util.Date;

/**
 * @author LiuMei
 * @date 2017-11-14.
 */
public class TaskStepDto extends BaseDto {

    /**
     * 任务
     */
    private TaskDto task;

    /**
     * 工作流
     */
    private WfCfgWfDto wfCfgWf;

    /**
     * 活动
     */
    private WfCfgActivDto wfCfgActiv;

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
     * 步骤执行开始时间
     */
    private Date startTime;

    /**
     * 步骤执行结束时间
     */
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
    private Long preStepId;

    /**
     * 运行状态
     */
    private Integer status;

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

    public WfCfgWfDto getWfCfgWf() {
        return wfCfgWf;
    }

    public void setWfCfgWf(WfCfgWfDto wfCfgWf) {
        this.wfCfgWf = wfCfgWf;
    }

    public WfCfgActivDto getWfCfgActiv() {
        return wfCfgActiv;
    }

    public void setWfCfgActiv(WfCfgActivDto wfCfgActiv) {
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

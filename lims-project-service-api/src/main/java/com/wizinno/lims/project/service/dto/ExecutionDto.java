package com.wizinno.lims.project.service.dto;

import com.wizinno.lims.common.domain.BaseDto;

import java.util.Date;

/**
 * @author LiuMei
 * @date 2017-11-14.
 */
public class ExecutionDto extends BaseDto {

    /**
     * 子任务
     */
    private SubTaskDto subTask;

    /**
     * 执行开始时间
     */
    private Date startTime;

    /**
     * 执行结束时间
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
     * 运行状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String note;

    public SubTaskDto getSubTask() {
        return subTask;
    }

    public void setSubTask(SubTaskDto subTask) {
        this.subTask = subTask;
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

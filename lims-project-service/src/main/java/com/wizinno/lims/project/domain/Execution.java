package com.wizinno.lims.project.domain;

import com.wizinno.lims.common.domain.BaseEntity;
import com.wizinno.lims.workflow.cfg.domain.CfgWf;
import com.wizinno.lims.workflow.cfg.domain.CfgWfActiv;

import javax.persistence.*;
import java.util.Date;

/**
 * 执行
 * @author LiuMei
 * @date 2017-11-14.
 */
@Entity
@Table(name = "execution")
public class Execution extends BaseEntity{

    /**
     * 子任务
     */
    @ManyToOne
    @JoinColumn(name="sub_task_id",nullable = false)
    private SubTask subTask;

    /**
     * 执行开始时间
     */
    @Column(name="start_time")
    private Date startTime;

    /**
     * 执行结束时间
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
     * 运行状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String note;

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

    public SubTask getSubTask() {
        return subTask;
    }

    public void setSubTask(SubTask subTask) {
        this.subTask = subTask;
    }
}

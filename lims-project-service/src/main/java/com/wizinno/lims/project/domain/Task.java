package com.wizinno.lims.project.domain;

import com.wizinno.lims.common.domain.BaseEntity;
import com.wizinno.lims.workflow.cfg.domain.CfgWf;

import javax.persistence.*;
import java.util.Date;

/**
 * @author LiuMei on 2017-07-18.
 */
@Entity
@Table(name = "task")
public class Task extends BaseEntity{

    /**
     * 任务编号
     */
    private String no;

    /**
     * 是否为默认任务
     */
    @Column(name = "default_task",nullable = false)
    private Boolean defaultTask;

    /**
     * 前导任务ID列表
     */
    @Column(name = "pre_id")
    private String preId;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="project_id")
    private Project project;

    /**
     * 工作内容
     */
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="job_id")
    private Job job;

    /**
     * 工作流
     */
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="wf_id")
    private CfgWf workflow;

    /**
     * 样本数量
     */
    @Column(nullable = false,name = "sample_amount")
    private Integer sampleAmount;

    /**
     * 计划开始时间
     */
    @Column(name = "plan_start_time")
    private Date planStartTime;

    /**
     * 计划完成时间
     */
    @Column(name = "plan_complete_time")
    private Date planCompleteTime;

    /**
     * 计划工时
     */
    @Column(name = "plan_labor_hour")
    private Integer planLaborHour;

    /**
     * 实际工时
     */
    @Column(name = "actual_labor_hour")
    private Integer actualLaborHour;

    /**
     * 任务分配时间
     */
    @Column(name = "task_allot_time")
    private Date taskAllotTime;

    /**
     * 实际开始时间
     */
    @Column(name = "actual_start_time")
    private Date actualStartTime;

    /**
     * 实际完成时间
     */
    @Column(name = "actual_complete_time")
    private Date actualCompleteTime;

    /**
     * 调度员
     */
    @Column(name = "allot_operator")
    private Long allotOperator;

    /**
     * 操作员
     */
    private Long operator;

    /**
     * 备注
     */
    private String note;

    /**
     * 任务状态
     */
    private Integer status;

    /**
     * 任务SOP 存疑
     */
    private String sop;

    public CfgWf getWorkflow() {
        return workflow;
    }

    public void setWorkflow(CfgWf workflow) {
        this.workflow = workflow;
    }

    public Boolean getDefaultTask() {
        return defaultTask;
    }

    public void setDefaultTask(Boolean defaultTask) {
        this.defaultTask = defaultTask;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPreId() {
        return preId;
    }

    public void setPreId(String preId) {
        this.preId = preId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getSop() {
        return sop;
    }

    public void setSop(String sop) {
        this.sop = sop;
    }

    public Integer getSampleAmount() {
        return sampleAmount;
    }

    public void setSampleAmount(Integer sampleAmount) {
        this.sampleAmount = sampleAmount;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanCompleteTime() {
        return planCompleteTime;
    }

    public void setPlanCompleteTime(Date planCompleteTime) {
        this.planCompleteTime = planCompleteTime;
    }

    public Integer getPlanLaborHour() {
        return planLaborHour;
    }

    public void setPlanLaborHour(Integer planLaborHour) {
        this.planLaborHour = planLaborHour;
    }

    public Integer getActualLaborHour() {
        return actualLaborHour;
    }

    public void setActualLaborHour(Integer actualLaborHour) {
        this.actualLaborHour = actualLaborHour;
    }

    public Date getTaskAllotTime() {
        return taskAllotTime;
    }

    public void setTaskAllotTime(Date taskAllotTime) {
        this.taskAllotTime = taskAllotTime;
    }

    public Date getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(Date actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public Date getActualCompleteTime() {
        return actualCompleteTime;
    }

    public void setActualCompleteTime(Date actualCompleteTime) {
        this.actualCompleteTime = actualCompleteTime;
    }

    public Long getAllotOperator() {
        return allotOperator;
    }

    public void setAllotOperator(Long allotOperator) {
        this.allotOperator = allotOperator;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

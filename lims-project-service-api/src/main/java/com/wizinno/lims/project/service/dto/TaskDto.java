package com.wizinno.lims.project.service.dto;

import com.wizinno.lims.common.domain.BaseDto;
import com.wizinno.lims.user.service.dto.UserSimpleDto;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfDto;

import java.util.Date;

/**
 * @author LiuMei on 2017-07-24.
 */
public class TaskDto extends BaseDto implements Comparable<TaskDto> {

    /**
     * 任务编号
     */
    private String no;

    /**
     * 前导任务ID列表
     */
    private String preId;

    private ProjectDto project;

    /**
     * 工作内容
     */
    private JobDto job;

    /**
     * 工作流
     */
    private CfgWfDto workflow;

    /**
     * 样本数量
     */
    private Integer sampleAmount;

    /**
     * 计划开始时间
     */
    private Date planStartTime;

    /**
     * 计划完成时间
     */
    private Date planCompleteTime;

    /**
     * 计划工时
     */
    private Integer planLaborHour;

    /**
     * 实际工时
     */
    private Integer actualLaborHour;

    /**
     * 任务分配时间
     */
    private Date taskAllotTime;

    /**
     * 实际开始时间
     */
    private Date actualStartTime;

    /**
     * 实际完成时间
     */
    private Date actualCompleteTime;

    /**
     * 调度员
     */
    private UserSimpleDto allotOperator;

    /**
     * 操作员
     */
    private UserSimpleDto operator;

    /**
     * 备注
     */
    private String note;

    /**
     * 任务状态
     */
    private Integer status;
    private String statusDesc;

    /**
     * 任务SOP 存疑
     */
    private String sop;

    /**
     * 是否为默认任务
     */
    private Boolean defaultTask;

    /**
     * 当前执行的SubTaskID
     */
    private Long currentSubTaskId;

    /**
     * 是否可以完成
     */
    private Boolean canFinish;

    @Override
    public int compareTo(TaskDto o) {
        if (this.getJob().getType() > o.getJob().getType()) {
            return 1;
        } else {
            return -1;
        }
    }

    public Boolean getCanFinish() {
        return canFinish;
    }

    public void setCanFinish(Boolean canFinish) {
        this.canFinish = canFinish;
    }

    public Long getCurrentSubTaskId() {
        return currentSubTaskId;
    }

    public void setCurrentSubTaskId(Long currentSubTaskId) {
        this.currentSubTaskId = currentSubTaskId;
    }

    public CfgWfDto getWorkflow() {
        return workflow;
    }

    public void setWorkflow(CfgWfDto workflow) {
        this.workflow = workflow;
    }

    public Boolean getDefaultTask() {
        return defaultTask;
    }

    public void setDefaultTask(Boolean defaultTask) {
        this.defaultTask = defaultTask;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
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

    public JobDto getJob() {
        return job;
    }

    public void setJob(JobDto job) {
        this.job = job;
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

    public UserSimpleDto getAllotOperator() {
        return allotOperator;
    }

    public void setAllotOperator(UserSimpleDto allotOperator) {
        this.allotOperator = allotOperator;
    }

    public UserSimpleDto getOperator() {
        return operator;
    }

    public void setOperator(UserSimpleDto operator) {
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

    public String getSop() {
        return sop;
    }

    public void setSop(String sop) {
        this.sop = sop;
    }

}

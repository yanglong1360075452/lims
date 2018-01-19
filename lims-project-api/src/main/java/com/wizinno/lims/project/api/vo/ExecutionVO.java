package com.wizinno.lims.project.api.vo;

import java.util.List;

/**
 * @author LiuMei
 * @date 2017-11-15.
 */
public class ExecutionVO {

    /**
     * SubTaskID
     */
    private Long subTaskId;

    /**
     * 操作样本ID列表
     */
    private List<Long> sampleIds;

    /**
     * 运行状态
     */
    private Integer executionStatus;

    /**
     * 运行ID
     */
    private Long executionId;

    /**
     * 说明
     */
    private String note;

    private Long extractMethod;

    public Long getExtractMethod() {
        return extractMethod;
    }

    public void setExtractMethod(Long extractMethod) {
        this.extractMethod = extractMethod;
    }

    public Long getExecutionId() {
        return executionId;
    }

    public void setExecutionId(Long executionId) {
        this.executionId = executionId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(Integer executionStatus) {
        this.executionStatus = executionStatus;
    }

    public List<Long> getSampleIds() {
        return sampleIds;
    }

    public void setSampleIds(List<Long> sampleIds) {
        this.sampleIds = sampleIds;
    }

    public Long getSubTaskId() {
        return subTaskId;
    }

    public void setSubTaskId(Long subTaskId) {
        this.subTaskId = subTaskId;
    }
}
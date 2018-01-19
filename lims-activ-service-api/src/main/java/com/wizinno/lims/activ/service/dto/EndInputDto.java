package com.wizinno.lims.activ.service.dto;

import java.util.List;

/**
 * @author LiuMei
 * @date 2017-11-17.
 */
public class EndInputDto {

    /**
     * 结束任务执行ID
     */
    private Long executionId;

    /**
     * 工作样本ID列表
     */
    private List<Long> sampleIds;

    /**
     * 运行状态
     */
    private Integer executionStatus;

    /**
     * 说明
     */
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getExecutionId() {
        return executionId;
    }

    public void setExecutionId(Long executionId) {
        this.executionId = executionId;
    }

    public List<Long> getSampleIds() {
        return sampleIds;
    }

    public void setSampleIds(List<Long> sampleIds) {
        this.sampleIds = sampleIds;
    }

    public Integer getExecutionStatus() {
        return executionStatus;
    }

    public void setExecutionStatus(Integer executionStatus) {
        this.executionStatus = executionStatus;
    }
}

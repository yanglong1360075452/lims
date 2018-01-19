package com.wizinno.lims.activ.extract.dto;

import com.wizinno.lims.activ.service.dto.StartInputDto;

/**
 * @author LiuMei
 * @date 2017-11-14.
 */
public class ExtractDto extends StartInputDto {

    /**
     * 任务执行ID
     */
    private Long executionId;


    /**
     * 上一任务执行ID
     */
    private Long preExecutionId;

    public Long getExecutionId() {
        return executionId;
    }

    public void setExecutionId(Long executionId) {
        this.executionId = executionId;
    }

    public Long getPreExecutionId() {
        return preExecutionId;
    }

    public void setPreExecutionId(Long preExecutionId) {
        this.preExecutionId = preExecutionId;
    }
}

package com.wizinno.lims.project.service;

import com.wizinno.lims.project.service.dto.ExecutionSampleDto;

import java.util.List;

/**
 * @author LiuMei
 * @date 2017-11-17.
 */
public interface ExecutionSampleService {

    /**
     * 批量添加
     * @param executionSampleDtoList
     */
    void addList(List<ExecutionSampleDto> executionSampleDtoList);

    /**
     * 根据subTaskId查询此次执行使用的样本ID列表
     * @param subTaskId
     * @return
     */
    List<Long> getSampleBySubTaskId(long subTaskId);

    /**
     * 根据subTaskId和样本ID查询
     * @param sampleId
     * @param subTaskId
     * @return
     */
    Long getLastExecutionIdBySampleIdAndSubTaskId(long sampleId,long subTaskId);
}

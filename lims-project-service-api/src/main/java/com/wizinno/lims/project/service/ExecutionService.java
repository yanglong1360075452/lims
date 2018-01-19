package com.wizinno.lims.project.service;

import com.wizinno.lims.project.service.dto.ExecutionDto;

/**
 * @author LiuMei on 2017-07-18.
 */
public interface ExecutionService<T> {

    /**
     * 添加活动实例
     * @param executionDto
     * @return
     */
    ExecutionDto save(ExecutionDto executionDto);

    /**
     * 根据ID获取详细信息
     * @param executionId
     * @return
     */
    ExecutionDto getById(long executionId);

    /**
     * 根据任务ID查询最后一次执行记录
     * @param taskId
     * @return
     */
    ExecutionDto getLastExecutionByTaskId(long taskId);

    /**
     * 数据结构转换
     * PO转DTO
     * @param execution
     * @return
     */
    ExecutionDto executionToDto(T execution);

    /**
     * 数据转换
     * DTO转PO
     * @param executionDto
     * @return
     */
    T executionDtoToPo(ExecutionDto executionDto);
}

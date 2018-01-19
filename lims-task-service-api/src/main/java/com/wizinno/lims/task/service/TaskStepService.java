package com.wizinno.lims.task.service;

import com.wizinno.lims.task.service.dto.TaskStepDto;

/**
 * @author LiuMei on 2017-07-18.
 */
public interface TaskStepService<T> {

    /**
     * 添加活动实例
     * @param taskStepDto
     * @return
     */
    TaskStepDto save(TaskStepDto taskStepDto);

    /**
     * 根据ID获取详细信息
     * @param stepId
     * @return
     */
    TaskStepDto getById(long stepId);

    /**
     * 数据结构转换
     * PO转DTO
     * @param taskStep
     * @return
     */
    TaskStepDto taskStepToDto(T taskStep);

    /**
     * 数据转换
     * DTO转PO
     * @param taskStepDto
     * @return
     */
    T taskStepDtoToPo(TaskStepDto taskStepDto);
}

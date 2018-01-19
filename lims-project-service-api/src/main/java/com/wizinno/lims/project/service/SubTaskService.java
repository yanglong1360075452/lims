package com.wizinno.lims.project.service;

import com.wizinno.lims.project.service.dto.SubTaskDto;

/**
 * @author LiuMei on 2017-07-18.
 */
public interface SubTaskService<T> {

    /**
     * 添加活动实例
     * @param subTaskDto
     * @return
     */
    SubTaskDto save(SubTaskDto subTaskDto);

    /**
     * 根据ID获取详细信息
     * @param subTaskId
     * @return
     */
    SubTaskDto getById(long subTaskId);

    /**
     * 根据任务ID查询当前运行的子任务
     * @param taskId
     * @return
     */
    Long getLastSubTaskByTaskId(long taskId);

    /**
     * 数据结构转换
     * PO转DTO
     * @param subTask
     * @return
     */
    SubTaskDto subTaskToDto(T subTask);

    /**
     * 数据转换
     * DTO转PO
     * @param subTaskDto
     * @return
     */
    T subTaskDtoToPo(SubTaskDto subTaskDto);
}

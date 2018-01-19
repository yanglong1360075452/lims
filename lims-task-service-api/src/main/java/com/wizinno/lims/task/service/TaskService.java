package com.wizinno.lims.task.service;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.task.service.condition.TaskCondition;
import com.wizinno.lims.task.service.dto.TaskDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author LiuMei on 2017-07-18.
 */
public interface TaskService<T> {

    /**
     * 批量添加任务
     * @param taskDTOs
     * @return
     */
    List<TaskDto> save(List<TaskDto> taskDTOs);

    /**
     * 根据ID查询任务信息
     * @param id
     * @return
     */
    TaskDto getById(long id);

    /**
     * 根据条件查询任务列表
     * @param taskCondition
     * @param pageable
     * @return
     */
    PageData<TaskDto> getByCondition(TaskCondition taskCondition, Pageable pageable);

    /**
     * 以项目为单位进行项目调度
     * @param projectId
     * @param taskDTOs
     * @param deleteList
     * @throws CustomException
     */
    void dispatchTask(long projectId,List<TaskDto> taskDTOs,List<Long> deleteList) throws CustomException;

    /**
     * 根据项目ID删除任务
     * @param projectId
     */
    void deleteTaskByProjectId(long projectId);

    /**
     * 根据项目ID删除任务样本分配记录
     * @param projectId
     */
    void deleteTaskSampleByProjectId(long projectId);

    /**
     * 数据结构转换
     * DTO转PO
     * @param taskDto
     * @return
     */
    T taskDtoToPO(TaskDto taskDto);

    /**
     * 数据转换
     * PO转DTO
     * @param task
     * @return
     */
    TaskDto taskToDto(T task);
}

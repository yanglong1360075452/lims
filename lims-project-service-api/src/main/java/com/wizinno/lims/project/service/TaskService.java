package com.wizinno.lims.project.service;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.project.service.condition.TaskCondition;
import com.wizinno.lims.project.service.dto.TaskDto;
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
     * 保存/修改任务
     * @param taskDto
     * @return
     */
    TaskDto save(TaskDto taskDto);

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
     *根据任务ID列表删除任务
     * 同时删除tracking记录
     * @param deleteIds
     */
    void deleteTaskByIdList(List<Long> deleteIds);

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

    /**
     * 任务开始
     * @param taskDto
     */
    void startTask(TaskDto taskDto);

    /**
     * 判断此task是否可以完成
     * @param taskDto
     * @return
     */
    Boolean taskCanFinish(TaskDto taskDto);

    /**
     * 任务完成
     * @param taskDto
     */
    void completeTask(TaskDto taskDto);
}

package com.wizinno.lims.project.service;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.project.service.dto.SampleDto;
import com.wizinno.lims.project.service.dto.SubTaskSampleDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author LiuMei
 * @date 2017-11-17.
 */
public interface SubTaskSampleService<T> {

    /**
     * 批量添加
     * @param subTaskSampleDtoList
     */
    void save(List<SubTaskSampleDto> subTaskSampleDtoList);

    /**
     * 根据SubTaskID分页查询此任务分配的样本列表
     * @param subTaskId
     * @param pageable
     * @return
     */
    PageData<SampleDto> getSampleIdBySubTaskId(long subTaskId, Pageable pageable);

    /**
     * 根据subTaskID查询可操作的所有样本ID
     * @param subTaskId
     * @return
     */
    List<Long> getSampleIdBySubTaskId(long subTaskId);

    /**
     * 数据转换
     * @param subTaskSampleDtoList
     * @return
     */
    List<T> subTaskSampleDtoToPo(List<SubTaskSampleDto> subTaskSampleDtoList);

    /**
     * 数据转换
     * @param subTaskSampleDto
     * @return
     */
    T subTaskSampleDtoToPo(SubTaskSampleDto subTaskSampleDto);
}

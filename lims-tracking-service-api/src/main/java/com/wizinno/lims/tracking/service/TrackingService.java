package com.wizinno.lims.tracking.service;

import com.wizinno.lims.tracking.service.dto.TrackingDto;

import java.util.List;

/**
 * @author LiuMei on 2017-08-10.
 */
public interface TrackingService {

    /**
     * 添加记录
     * @param trackingDto
     */
    void addTracking(TrackingDto trackingDto);

    /**
     * 批量添加
     * @param trackingDtoList
     */
    void addBatchTracking(List<TrackingDto> trackingDtoList);

    /**
     * 根据样本ID删除
     * @param sampleId
     */
    void deleteBySampleId(long sampleId);

    /**
     * 根据任务ID删除
     * @param taskId
     */
    void deleteByTaskId(long taskId);

}

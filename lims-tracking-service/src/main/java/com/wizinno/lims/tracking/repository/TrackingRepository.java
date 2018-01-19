package com.wizinno.lims.tracking.repository;

import com.wizinno.lims.tracking.domain.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LiuMei on 2017-08-10.
 */
public interface TrackingRepository extends JpaRepository<Tracking,Long> {

    /**
     * 根据样本ID删除Tracking记录
     * @param sampleId
     */
    void deleteBySampleId(long sampleId);

    /**
     * 根据任务ID删除Tracking记录
     * @param taskId
     */
    void deleteByTaskId(long taskId);
}

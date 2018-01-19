package com.wizinno.lims.project.repository;

import com.wizinno.lims.project.domain.SubTaskSampleR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

/**
 * @author LiuMei on 2017-07-24.
 */
public interface SubTaskSampleRepository extends JpaRepository<SubTaskSampleR,Long>,JpaSpecificationExecutor<SubTaskSampleR> {

    /**
     * 根据subTaskId查询样本ID列表
     * @param subTaskId
     * @return
     */
    @Query(value = "select DISTINCT (sample_id) from subtask_sample_r where subtask_id=?1",nativeQuery = true)
    List<BigInteger> getSampleIdsBySubTaskId(long subTaskId);
}

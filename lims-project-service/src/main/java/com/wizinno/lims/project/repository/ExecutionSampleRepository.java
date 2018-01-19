package com.wizinno.lims.project.repository;

import com.wizinno.lims.project.domain.ExecutionSampleR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

/**
 * @author LiuMei
 * @date 2017-11-22.
 */
public interface ExecutionSampleRepository extends JpaRepository<ExecutionSampleR, Long>, JpaSpecificationExecutor<ExecutionSampleR> {

    /**
     * 根据subTaskId查询样本ID列表
     * @param subTaskId
     * @return
     */
    @Query(value = "select DISTINCT (sample_id) from execution_sample_r where subtask_id = ?1",nativeQuery = true)
    List<BigInteger> getSampleBySubTaskId(long subTaskId);

    /**
     * 根据样本ID和subTaskID查询最后一次执行ID
     * @param sampleId
     * @param subTaskId
     * @return
     */
    @Query(value = " select execution_id from execution_sample_r where sample_id=?1 and subtask_id = ?2 order by create_time desc limit 1",nativeQuery = true)
    Long getLastExecutionIdBySampleIdAndSubTaskId(long sampleId,long subTaskId);
}

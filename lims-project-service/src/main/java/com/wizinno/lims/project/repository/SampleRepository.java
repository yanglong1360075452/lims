package com.wizinno.lims.project.repository;

import com.wizinno.lims.project.domain.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author LiuMei on 2017-06-14.
 */
public interface SampleRepository extends JpaRepository<Sample,Long>,JpaSpecificationExecutor<Sample> {

    /**
     * 根据项目ID查询样本总数
     * @param projectId
     * @return
     */
    @Query(value = " select count(distinct s.id) from sample s INNER JOIN project p on s.sample_lot_id = p.sample_lot_id" +
            " where p.id = ?1",nativeQuery = true)
    long countByProjectId(long projectId);

    /**
     * 根据样本批次ID查询最大的样本编号
     * 不包含已销毁 sample_status-6-已销毁
     * @param sampleLotId
     * @return
     */
    @Query(value = " select max(no) from sample where sample_lot_id = ?1 and sample_status != 6",nativeQuery = true)
    String selectMaxNoBySampleLotId(long sampleLotId);

    /**
     * 根据样本批次ID和样本状态查询样本列表
     * @param sampleLotId
     * @param sampleStatus
     * @return
     */
    List<Sample> getBySampleLotIdAndSampleStatus(long sampleLotId,int sampleStatus);

    /**
     * 根据样本批次ID查询样本列表
     * @param sampleLotId
     * @return
     */
    List<Sample> getBySampleLotId(long sampleLotId);

    /**
     * 根据executionId查询此次执行使用的样本
     * @param executionId
     * @return
     */
    @Query(value = " select * from sample where id in (select sample_id from execution_sample_r WHERE execution_id =?1)",nativeQuery = true)
    List<Sample> getUseSampleByExecutionId(long executionId);

    /**
     * 根据sampleLotId和父样本ID查询样本
     * @param sampleLotId
     * @param parentId
     * @return
     */
    Sample getBySampleLotIdAndParentId(long sampleLotId,long parentId);
}

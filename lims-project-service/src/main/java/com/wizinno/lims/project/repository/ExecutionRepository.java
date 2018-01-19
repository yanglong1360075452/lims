package com.wizinno.lims.project.repository;

import com.wizinno.lims.project.domain.Execution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author LiuMei on 2017-07-18.
 */
public interface ExecutionRepository extends JpaRepository<Execution,Long>,JpaSpecificationExecutor<Execution> {

    /**
     * 根据任务ID查询最后一个执行记录
     * @param taskId
     * @return
     */
    @Query(value = " select * from execution where task_id = ?1 order by id DESC limit 1",nativeQuery = true)
    Execution selectLastByTaskId(long taskId);
}

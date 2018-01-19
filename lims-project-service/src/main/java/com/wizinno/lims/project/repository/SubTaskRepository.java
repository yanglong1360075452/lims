package com.wizinno.lims.project.repository;

import com.wizinno.lims.project.domain.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author LiuMei on 2017-07-18.
 */
public interface SubTaskRepository extends JpaRepository<SubTask,Long>,JpaSpecificationExecutor<SubTask> {

    /**
     * 根据任务ID查询最后一个执行记录
     * @param taskId
     * @return
     */
    @Query(value = " select id from subtask where task_id = ?1 order by id DESC limit 1",nativeQuery = true)
    Long selectLastByTaskId(long taskId);
}

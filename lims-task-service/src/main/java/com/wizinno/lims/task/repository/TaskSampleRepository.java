package com.wizinno.lims.task.repository;

import com.wizinno.lims.task.domain.TaskSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author LiuMei on 2017-07-24.
 */
public interface TaskSampleRepository extends JpaRepository<TaskSample,Long> {

    /**
     * 根据任务ID删除任务
     * @param taskId
     */
    void deleteByTaskId(long taskId);

    /**
     * 根据项目ID删除任务
     * @param projectId
     */
    /*
    执行update/delete 需要加此注解
     */
    @Modifying
    @Query(value = "delete ts from task_sample ts INNER JOIN task t on ts.task_id = t.id INNER join project p on t.project_id = p.id WHERE  p.id=?1",
            nativeQuery = true)
    void deleteByProjectId(long projectId);

}

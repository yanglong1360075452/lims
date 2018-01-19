package com.wizinno.lims.project.repository;

import com.wizinno.lims.project.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author LiuMei on 2017-07-18.
 */
public interface TaskRepository extends JpaRepository<Task,Long>,JpaSpecificationExecutor<Task> {

    /**
     * 根据项目ID查询任务的最小状态
     * @param projectId
     * @return
     */
    @Query(value = " select min(status) from task where project_id = ?1",nativeQuery = true)
    Integer selectMinStatusByProjectId(long projectId);

    /**
     * 根据项目ID删除任务
     * @param projectId
     */
    void deleteByProjectId(long projectId);

    /**
     * 根据项目ID获取任务列表
     * @param projectId
     * @return
     */
    List<Task> getByProjectId(long projectId);

    /**
     * 根据项目ID查询任务数
     * @param projectId
     * @return
     */
    Long countByProjectId(long projectId);

    /**
     * 根据项目ID和任务状态查询任务数
     * @param projectId
     * @param status
     * @return
     */
    Long countByProjectIdAndStatus(long projectId,Integer status);
}

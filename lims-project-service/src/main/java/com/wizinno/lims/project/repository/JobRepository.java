package com.wizinno.lims.project.repository;

import com.wizinno.lims.project.domain.Job;
import com.wizinno.lims.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

/**
 * @author LiuMei on 2017-06-14.
 */
public interface JobRepository extends JpaRepository<Job,Long> {

    /**
     * 根据项目信息查询工作内容
     * @param project
     * @return
     */
    Set<Job> findByProject(Project project);

    /**
     * 根据项目信息查询工作内容ID列表
     * @param project
     * @return
     */
    @Query(value = "select  id from Job WHERE  project =?1")
    Set<Long> findIdsByProject(Project project);
}

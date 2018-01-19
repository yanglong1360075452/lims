package com.wizinno.lims.project.repository;

import com.wizinno.lims.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author LiuMei on 2017-06-14.
 */
public interface ProjectRepository extends JpaRepository<Project,Long>,JpaSpecificationExecutor<Project> {

    /**
     * 根据样本批次ID查询项目信息
     * @param sampleLotId
     * @return
     */
    Project getBySampleLotId(long sampleLotId);

    /**
     * 根据项目编号查询项目信息
     * @param no
     * @return
     */
    Project getByNo(String no);
}

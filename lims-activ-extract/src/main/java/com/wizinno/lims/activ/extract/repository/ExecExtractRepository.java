package com.wizinno.lims.activ.extract.repository;

import com.wizinno.lims.activ.extract.domain.ExecExtract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author LiuMei on 2017-12-01.
 */
public interface ExecExtractRepository extends JpaRepository<ExecExtract, Long>, JpaSpecificationExecutor<ExecExtract> {

    /**
     * 根据ExecutionID查询
     * @param executionId
     * @return
     */
    ExecExtract findByExecutionId(long executionId);
}

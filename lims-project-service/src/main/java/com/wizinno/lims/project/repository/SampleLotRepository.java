package com.wizinno.lims.project.repository;

import com.wizinno.lims.project.domain.SampleLot;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LiuMei on 2017-06-14.
 */
public interface SampleLotRepository extends JpaRepository<SampleLot,Long> {

    /**
     * 根据样本来源查询样本批次信息
     * @param sampleSource
     * @return
     */
    SampleLot getBySampleSource(long sampleSource);

}

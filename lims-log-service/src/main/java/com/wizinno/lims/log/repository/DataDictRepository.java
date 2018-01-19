package com.wizinno.lims.log.repository;

import com.wizinno.lims.log.domain.DataDict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author LiuMei on 2017-06-19.
 */
public interface DataDictRepository extends JpaRepository<DataDict,Long>,JpaSpecificationExecutor {
}

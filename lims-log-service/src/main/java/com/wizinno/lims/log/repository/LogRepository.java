package com.wizinno.lims.log.repository;

import com.wizinno.lims.log.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author LiuMei on 2017-06-13.
 */
public interface LogRepository extends JpaRepository<Log,Long>,JpaSpecificationExecutor {
}


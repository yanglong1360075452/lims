package com.wizinno.lims.activ.extract.repository;

import com.wizinno.lims.activ.extract.domain.ExtractMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author LiuMei on 2017-12-01.
 */
public interface ExtractMethodRepository extends JpaRepository<ExtractMethod, Long>, JpaSpecificationExecutor<ExtractMethod> {
}

package com.wizinno.lims.activ.extract.repository;

import com.wizinno.lims.activ.extract.domain.ExtractMethodScheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author LiuMei on 2017-12-01.
 */
public interface ExtractMethodSchemeRepository extends JpaRepository<ExtractMethodScheme, Long>, JpaSpecificationExecutor<ExtractMethodScheme> {

    /**
     * 根据物种/样本类型查询提取方法
     * @param species
     * @param sampleType
     * @return
     */
    List<ExtractMethodScheme> findBySpeciesAndSampleType(long species,long sampleType);

    /**
     * 根据样本类型查询保存方式
     * @param sampleCategory
     * @return
     */
    @Query(value = "select  save_way from extract_method_scheme WHERE  sample_category =?1 limit 1",nativeQuery = true)
    Long findSaveWayBySampleCategory(long sampleCategory);
}

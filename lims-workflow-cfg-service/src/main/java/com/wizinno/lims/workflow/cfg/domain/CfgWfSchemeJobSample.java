package com.wizinno.lims.workflow.cfg.domain;

import com.wizinno.lims.common.domain.BaseEntity;

import javax.persistence.*;

/**
 * @author LiuMei
 * @date 2017-11-14.
 */
@Entity
@Table(name = "cfg_wf_scheme_job_sample")
public class CfgWfSchemeJobSample extends BaseEntity{

    /**
     * 工作流
     */
    @ManyToOne
    @JoinColumn(name = "wf_id",nullable = false)
    private CfgWf cfgWf;

    /**
     * 样本类别
     */
    @Column(name = "sample_category",nullable = false)
    private Integer sampleCategory;

    /**
     * 样本类型
     */
    @Column(name = "sample_type",nullable = false)
    private Integer sampleType;

    /**
     * 物种分类
     */
    @Column(nullable = false)
    private Integer species;

    public CfgWf getCfgWf() {
        return cfgWf;
    }

    public void setCfgWf(CfgWf cfgWf) {
        this.cfgWf = cfgWf;
    }

    public Integer getSampleCategory() {
        return sampleCategory;
    }

    public void setSampleCategory(Integer sampleCategory) {
        this.sampleCategory = sampleCategory;
    }

    public Integer getSampleType() {
        return sampleType;
    }

    public void setSampleType(Integer sampleType) {
        this.sampleType = sampleType;
    }

    public Integer getSpecies() {
        return species;
    }

    public void setSpecies(Integer species) {
        this.species = species;
    }
}

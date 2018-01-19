package com.wizinno.lims.activ.extract.domain;

import javax.persistence.*;

/**
 * @author LiuMei
 * @date 2017-12-08.
 */
@Entity
@Table(name = "extract_method_scheme")
public class ExtractMethodScheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 物种分类
     */
    private Long species;

    /**
     * 样本类别
     */
    @Column(name="sample_category")
    private Long sampleCategory;

    /**
     * 样本类型
     */
    @Column(name="sample_type")
    private Long sampleType;

    /**
     * 提取方法
     */
    @ManyToOne
    @JoinColumn(name="extract_method",nullable = false)
    private ExtractMethod extractMethod;

    /**
     * 样本保存类型
     */
    @Column(name="save_way")
    private Long saveWay;

    public Long getSaveWay() {
        return saveWay;
    }

    public void setSaveWay(Long saveWay) {
        this.saveWay = saveWay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpecies() {
        return species;
    }

    public void setSpecies(Long species) {
        this.species = species;
    }

    public Long getSampleCategory() {
        return sampleCategory;
    }

    public void setSampleCategory(Long sampleCategory) {
        this.sampleCategory = sampleCategory;
    }

    public Long getSampleType() {
        return sampleType;
    }

    public void setSampleType(Long sampleType) {
        this.sampleType = sampleType;
    }

    public ExtractMethod getExtractMethod() {
        return extractMethod;
    }

    public void setExtractMethod(ExtractMethod extractMethod) {
        this.extractMethod = extractMethod;
    }
}

package com.wizinno.lims.project.domain;

import com.wizinno.lims.common.domain.BaseEntity;

import javax.persistence.*;

/**
 * @author LiuMei on 2017-06-14.
 */
@Entity
@Table(name = "sample_lot")
public class SampleLot extends BaseEntity{

    /**
     * 编号
     */
    @Column(nullable = false)
    private String no;

    /**
     * 样本类别
     */
    @Column(name = "sample_category",nullable = false)
    private Long sampleCategory;

    /**
     * 样本类型
     */
    @Column(name = "sample_type",nullable = false)
    private Long sampleType;

    /**
     * 物种分类
     */
    @Column(nullable = false)
    private Long species;

    /**
     * 保存形式
     */
    @Column(name = "save_way")
    private Long saveWay;

    /**
     * 样本来源
     */
    @Column(name = "sample_source",nullable = false)
    private Long sampleSource;

    /**
     * 项目引用数
     */
    @Column(name = "project_ref")
    private Integer projectRef;

    /**
     * 操作人员
     */
    private Long operator;

    /**
     * 样本备注
     */
    @Column(name = "sample_note")
    private String sampleNote;

    /**
     * 文库Index位置
     */
    @Column(name = "library_index")
    private Integer libraryIndex;

    /**
     * 文库片段大小
     */
    @Column(name = "library_size")
    private Integer librarySize;

    /**
     * 文库结构示例
     */
    @Column(name = "library_structure")
    private String libraryStructure;

    /**
     * 文库片段示例
     */
    @Column(name = "library_fragment")
    private String libraryFragment;

    /**
     * 附件
     */
    private String affix;

    /**
     * 描述
     */
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Integer status;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Long getSampleSource() {
        return sampleSource;
    }

    public void setSampleSource(Long sampleSource) {
        this.sampleSource = sampleSource;
    }

    public Integer getProjectRef() {
        return projectRef;
    }

    public void setProjectRef(Integer projectRef) {
        this.projectRef = projectRef;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public String getSampleNote() {
        return sampleNote;
    }

    public void setSampleNote(String sampleNote) {
        this.sampleNote = sampleNote;
    }

    public Integer getLibraryIndex() {
        return libraryIndex;
    }

    public void setLibraryIndex(Integer libraryIndex) {
        this.libraryIndex = libraryIndex;
    }

    public Integer getLibrarySize() {
        return librarySize;
    }

    public void setLibrarySize(Integer librarySize) {
        this.librarySize = librarySize;
    }

    public String getLibraryStructure() {
        return libraryStructure;
    }

    public void setLibraryStructure(String libraryStructure) {
        this.libraryStructure = libraryStructure;
    }

    public String getLibraryFragment() {
        return libraryFragment;
    }

    public void setLibraryFragment(String libraryFragment) {
        this.libraryFragment = libraryFragment;
    }

    public String getAffix() {
        return affix;
    }

    public void setAffix(String affix) {
        this.affix = affix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Long getSpecies() {
        return species;
    }

    public void setSpecies(Long species) {
        this.species = species;
    }

    public Long getSaveWay() {
        return saveWay;
    }

    public void setSaveWay(Long saveWay) {
        this.saveWay = saveWay;
    }
}

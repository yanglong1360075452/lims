package com.wizinno.lims.project.service.dto;

import java.util.Date;

/**
 * @author LiuMei on 2017-06-16.
 */
public class ProjectSimpleDto {

    private Long id;

    /**
     * 项目编号
     */
    private String no;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目类型
     */
    private Long projectType;
    private String projectTypeDesc;

    /**
     * 计划完成时间
     */
    private Date planCompleteTime;

    /**
     * 物种分类
     */
    private Long species;
    private String speciesDesc;

    /**
     * 样本类别
     */
    private Long sampleCategory;
    private String sampleCategoryDesc;

    /**
     * 项目状态
     */
    private Integer projectStatus;
    private String projectStatusDesc;

    /**
     * 生产状态
     */
    private Integer productStatus;
    private String productStatusDesc;

    /**
     * 实际完成时间
     */
    private Date actualCompleteTime;

    /**
     * 样本总数
     */
    private long sampleCount;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectTypeDesc() {
        return projectTypeDesc;
    }

    public void setProjectTypeDesc(String projectTypeDesc) {
        this.projectTypeDesc = projectTypeDesc;
    }

    public Date getPlanCompleteTime() {
        return planCompleteTime;
    }

    public void setPlanCompleteTime(Date planCompleteTime) {
        this.planCompleteTime = planCompleteTime;
    }

    public String getSpeciesDesc() {
        return speciesDesc;
    }

    public void setSpeciesDesc(String speciesDesc) {
        this.speciesDesc = speciesDesc;
    }

    public String getSampleCategoryDesc() {
        return sampleCategoryDesc;
    }

    public void setSampleCategoryDesc(String sampleCategoryDesc) {
        this.sampleCategoryDesc = sampleCategoryDesc;
    }

    public Integer getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectStatusDesc() {
        return projectStatusDesc;
    }

    public void setProjectStatusDesc(String projectStatusDesc) {
        this.projectStatusDesc = projectStatusDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusDesc() {
        return productStatusDesc;
    }

    public void setProductStatusDesc(String productStatusDesc) {
        this.productStatusDesc = productStatusDesc;
    }

    public Date getActualCompleteTime() {
        return actualCompleteTime;
    }

    public void setActualCompleteTime(Date actualCompleteTime) {
        this.actualCompleteTime = actualCompleteTime;
    }

    public long getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(long sampleCount) {
        this.sampleCount = sampleCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getProjectType() {
        return projectType;
    }

    public void setProjectType(Long projectType) {
        this.projectType = projectType;
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
}

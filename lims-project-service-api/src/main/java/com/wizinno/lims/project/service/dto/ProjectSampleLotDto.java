package com.wizinno.lims.project.service.dto;

/**
 * @author LiuMei on 2017-07-18.
 */
public class ProjectSampleLotDto {

    /**
     * 项目ID
     */
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
     * 样本批次ID
     */
    private Long sampleLotId;

    /**
     * 样本批次编号
     */
    private String sampleLotNo;

    /**
     * 样本批次描述
     */
    private String description;

    /**
     * 样本类别
     */
    private Long sampleCategory;
    private String sampleCategoryDesc;

    /**
     * 样本类型
     */
    private Long sampleType;
    private String sampleTypeDesc;

    /**
     * 物种分类
     */
    private Long species;
    private String speciesDesc;

    /**
     * 保存形式
     */
    private Long saveWay;
    private String saveWayDesc;

    /**
     * 样本来源
     */
    private Long sampleSource;
    private String sampleSourceDesc;

    /**
     * 样本备注
     */
    private String sampleNote;

    /**
     * 样本总数
     */
    private Integer sampleCount;

    private Integer projectStatus;
    private String projectStatusDesc;

    public Long getSampleLotId() {
        return sampleLotId;
    }

    public void setSampleLotId(Long sampleLotId) {
        this.sampleLotId = sampleLotId;
    }

    public String getSampleSourceDesc() {
        return sampleSourceDesc;
    }

    public void setSampleSourceDesc(String sampleSourceDesc) {
        this.sampleSourceDesc = sampleSourceDesc;
    }

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

    public String getSampleLotNo() {
        return sampleLotNo;
    }

    public void setSampleLotNo(String sampleLotNo) {
        this.sampleLotNo = sampleLotNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSampleCategoryDesc() {
        return sampleCategoryDesc;
    }

    public void setSampleCategoryDesc(String sampleCategoryDesc) {
        this.sampleCategoryDesc = sampleCategoryDesc;
    }

    public String getSampleTypeDesc() {
        return sampleTypeDesc;
    }

    public void setSampleTypeDesc(String sampleTypeDesc) {
        this.sampleTypeDesc = sampleTypeDesc;
    }

    public String getSpeciesDesc() {
        return speciesDesc;
    }

    public void setSpeciesDesc(String speciesDesc) {
        this.speciesDesc = speciesDesc;
    }

    public String getSaveWayDesc() {
        return saveWayDesc;
    }

    public void setSaveWayDesc(String saveWayDesc) {
        this.saveWayDesc = saveWayDesc;
    }

    public Long getSampleSource() {
        return sampleSource;
    }

    public void setSampleSource(Long sampleSource) {
        this.sampleSource = sampleSource;
    }

    public String getSampleNote() {
        return sampleNote;
    }

    public void setSampleNote(String sampleNote) {
        this.sampleNote = sampleNote;
    }

    public Integer getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(Integer sampleCount) {
        this.sampleCount = sampleCount;
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

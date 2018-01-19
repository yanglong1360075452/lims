package com.wizinno.lims.project.service.dto;

import com.wizinno.lims.common.domain.BaseDto;
import com.wizinno.lims.user.service.dto.UserSimpleDto;

import java.util.Set;

/**
 * @author LiuMei on 2017-06-14.
 */
public class SampleLotDto extends BaseDto {

    /**
     * 项目信息
     */
    private ProjectDto project;

    /**
     * 编号
     */
    private String no;

    private Set<SampleDto> samples;

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
    /**
     * 0-原始样本
     * 其他为具体样本批次号
     */
    private String sampleSourceDesc;

    /**
     * 项目引用数
     */
    private Integer projectRef;

    /**
     * 操作人员
     */
    private UserSimpleDto operator;

    /**
     * 样本备注
     */
    private String sampleNote;

    /**
     * 文库Index位置
     */
    private Long libraryIndex;
    private String libraryIndexDesc;

    /**
     * 文库片段大小
     */
    private Long librarySize;
    private String librarySizeDesc;

    /**
     * 文库结构示例
     */
    private String libraryStructure;

    /**
     * 文库片段示例
     */
    private String libraryFragment;

    /**
     * 附件
     */
    private String affix;

    private Boolean deleteAffix;

    /**
     * 描述
     */
    private String description;

    /**
     * 样本总数
     */
    private Integer sampleCount;

    private Long projectId;

    private Integer status;
    private String statusDesc;

    public String getSampleSourceDesc() {
        return sampleSourceDesc;
    }

    public void setSampleSourceDesc(String sampleSourceDesc) {
        this.sampleSourceDesc = sampleSourceDesc;
    }

    public Boolean getDeleteAffix() {
        return deleteAffix;
    }

    public void setDeleteAffix(Boolean deleteAffix) {
        this.deleteAffix = deleteAffix;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }

    public String getSampleTypeDesc() {
        return sampleTypeDesc;
    }

    public void setSampleTypeDesc(String sampleTypeDesc) {
        this.sampleTypeDesc = sampleTypeDesc;
    }

    public Long getSampleSource() {
        return sampleSource;
    }

    public void setSampleSource(Long sampleSource) {
        this.sampleSource = sampleSource;
    }

    public UserSimpleDto getOperator() {
        return operator;
    }

    public void setOperator(UserSimpleDto operator) {
        this.operator = operator;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Set<SampleDto> getSamples() {
        return samples;
    }

    public void setSamples(Set<SampleDto> samples) {
        this.samples = samples;
    }

    public String getSampleCategoryDesc() {
        return sampleCategoryDesc;
    }

    public void setSampleCategoryDesc(String sampleCategoryDesc) {
        this.sampleCategoryDesc = sampleCategoryDesc;
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

    public Integer getProjectRef() {
        return projectRef;
    }

    public void setProjectRef(Integer projectRef) {
        this.projectRef = projectRef;
    }

    public String getSampleNote() {
        return sampleNote;
    }

    public void setSampleNote(String sampleNote) {
        this.sampleNote = sampleNote;
    }

    public String getLibraryIndexDesc() {
        return libraryIndexDesc;
    }

    public void setLibraryIndexDesc(String libraryIndexDesc) {
        this.libraryIndexDesc = libraryIndexDesc;
    }

    public String getLibrarySizeDesc() {
        return librarySizeDesc;
    }

    public void setLibrarySizeDesc(String librarySizeDesc) {
        this.librarySizeDesc = librarySizeDesc;
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

    public Integer getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(Integer sampleCount) {
        this.sampleCount = sampleCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
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

    public Long getLibraryIndex() {
        return libraryIndex;
    }

    public void setLibraryIndex(Long libraryIndex) {
        this.libraryIndex = libraryIndex;
    }

    public Long getLibrarySize() {
        return librarySize;
    }

    public void setLibrarySize(Long librarySize) {
        this.librarySize = librarySize;
    }
}

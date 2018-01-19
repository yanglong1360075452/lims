package com.wizinno.lims.project.service.dto;

import com.wizinno.lims.common.domain.BaseDto;

import java.util.Date;
import java.util.Set;

/**
 * @author LiuMei on 2017-06-14.
 */
public class ProjectDto extends BaseDto{

    private Set<JobDto> jobs;

    private SampleLotDto sampleLot;

    /**
     * 项目编号
     */
    private String no;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 合同名称
     */
    private String contractName;

    /**
     * 子合同编号
     */
    private String subContractNo;

    /**
     * 子合同名称
     */
    private String subContractName;

    /**
     * 商机编号
     */
    private String businessNo;

    /**
     * 临时合同
     */
    private String tempContract;

    /**
     * 客户代表
     */
    private String customerRepresentative;

    /**
     * 合同备注
     */
    private String contractNote;

    /**
     * 客户编号
     */
    private String customerNo;

    /**
     * 客户单位
     */
    private String customerUnit;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 客户电话
     */
    private String customerPhone;

    /**
     * 客户邮箱
     */
    private String customerEmail;

    /**
     * 项目类型
     */
    private Long projectType;
    private String projectTypeDesc;

    /**
     * 优先级
     */
    private Long priority;
    private String priorityDesc;

    /**
     * 计划完成时间
     */
    private Date planCompleteTime;

    /**
     * 特殊要求
     */
    private String specialRequire;

    /**
     * 概要备注
     */
    private String summaryNote;

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

    public Set<JobDto> getJobs() {
        return jobs;
    }

    public void setJobs(Set<JobDto> jobs) {
        this.jobs = jobs;
    }

    public SampleLotDto getSampleLot() {
        return sampleLot;
    }

    public void setSampleLot(SampleLotDto sampleLot) {
        this.sampleLot = sampleLot;
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

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getSubContractNo() {
        return subContractNo;
    }

    public void setSubContractNo(String subContractNo) {
        this.subContractNo = subContractNo;
    }

    public String getSubContractName() {
        return subContractName;
    }

    public void setSubContractName(String subContractName) {
        this.subContractName = subContractName;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getTempContract() {
        return tempContract;
    }

    public void setTempContract(String tempContract) {
        this.tempContract = tempContract;
    }

    public String getCustomerRepresentative() {
        return customerRepresentative;
    }

    public void setCustomerRepresentative(String customerRepresentative) {
        this.customerRepresentative = customerRepresentative;
    }

    public String getContractNote() {
        return contractNote;
    }

    public void setContractNote(String contractNote) {
        this.contractNote = contractNote;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerUnit() {
        return customerUnit;
    }

    public void setCustomerUnit(String customerUnit) {
        this.customerUnit = customerUnit;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getProjectTypeDesc() {
        return projectTypeDesc;
    }

    public void setProjectTypeDesc(String projectTypeDesc) {
        this.projectTypeDesc = projectTypeDesc;
    }

    public String getPriorityDesc() {
        return priorityDesc;
    }

    public void setPriorityDesc(String priorityDesc) {
        this.priorityDesc = priorityDesc;
    }

    public Date getPlanCompleteTime() {
        return planCompleteTime;
    }

    public void setPlanCompleteTime(Date planCompleteTime) {
        this.planCompleteTime = planCompleteTime;
    }

    public String getSpecialRequire() {
        return specialRequire;
    }

    public void setSpecialRequire(String specialRequire) {
        this.specialRequire = specialRequire;
    }

    public String getSummaryNote() {
        return summaryNote;
    }

    public void setSummaryNote(String summaryNote) {
        this.summaryNote = summaryNote;
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

    public Long getProjectType() {
        return projectType;
    }

    public void setProjectType(Long projectType) {
        this.projectType = projectType;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
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
}

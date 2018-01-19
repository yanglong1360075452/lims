package com.wizinno.lims.project.domain;

import com.wizinno.lims.common.domain.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author LiuMei on 2017-06-14.
 */
@Entity
@Table(name = "project")
public class Project extends BaseEntity{

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "sample_lot_id")
    private SampleLot sampleLot;

    /**
     * 项目编号
     */
    private String no;

    /**
     * 项目名称
     */
    @Column(nullable = false)
    private String name;

    /**
     * 合同编号
     */
    @Column(nullable = false,name="contract_no")
    private String contractNo;

    /**
     * 合同名称
     */
    @Column(nullable = false,name = "contract_name")
    private String contractName;

    /**
     * 子合同编号
     */
    @Column(name = "sub_contract_no")
    private String subContractNo;

    /**
     * 子合同名称
     */
    @Column(name = "sub_contract_name")
    private String subContractName;

    /**
     * 商机编号
     */
    @Column(name = "business_no")
    private String businessNo;

    /**
     * 临时合同
     */
    @Column(name = "temp_contract")
    private String tempContract;

    /**
     * 客户代表
     */
    @Column(name = "customer_representative",nullable = false)
    private String customerRepresentative;

    /**
     * 合同备注
     */
    @Column(name = "contract_note",columnDefinition="TEXT")
    private String contractNote;

    /**
     * 客户编号
     */
    @Column(name = "customer_no",nullable = false)
    private String customerNo;

    /**
     * 客户单位
     */
    @Column(name = "customer_unit",nullable = false)
    private String customerUnit;

    /**
     * 客户姓名
     */
    @Column(name = "customer_name",nullable = false)
    private String customerName;

    /**
     * 客户电话
     */
    @Column(name = "customer_phone",nullable = false)
    private String customerPhone;

    /**
     * 客户邮箱
     */
    @Column(name = "customer_email",nullable = false)
    private String customerEmail;

    /**
     * 项目类型
     */
    @Column(name = "project_type",nullable = false)
    private Long projectType;

    /**
     * 优先级
     */
    @Column(nullable = false,columnDefinition="INT(2) default 3")
    private Long priority;

    /**
     * 计划完成时间
     */
    @Column(name = "plan_complete_time")
    private Date planCompleteTime;

    /**
     * 特殊要求
     */
    @Column(name = "special_require",columnDefinition="TEXT")
    private String specialRequire;

    /**
     * 概要备注
     */
    @Column(name = "summary_note",columnDefinition="TEXT")
    private String summaryNote;

    /**
     * 样本类别
     */
    @Column(name = "sample_category",nullable = false)
    private Long sampleCategory;

    /**
     * 样本类型
     */
    @Column(name = "sample_Type",nullable = false)
    private Long sampleType;

    /**
     * 物种分类
     */
    @Column(nullable = false)
    private Long species;

    /**
     * 项目状态
     */
    @Column(name = "project_status",nullable = false)
    private Integer projectStatus;

    /**
     * 生产状态
     */
    @Column(name = "product_status")
    private Integer productStatus;

    /**
     * 实际完成时间
     */
    @Column(name = "actual_complete_time")
    private Date actualCompleteTime;

    public SampleLot getSampleLot() {
        return sampleLot;
    }

    public void setSampleLot(SampleLot sampleLot) {
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

    public Integer getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
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

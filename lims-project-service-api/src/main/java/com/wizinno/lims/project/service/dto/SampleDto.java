package com.wizinno.lims.project.service.dto;

import com.wizinno.lims.common.domain.BaseDto;

import java.util.Date;

/**
 * @author LiuMei on 2017-06-14.
 */
public class SampleDto extends BaseDto{

    /**
     * 样本编号
     */
    private String no;

    private SampleLotDto sampleLot;

    /**
     * 原始样本ID
     */
    private Long originalId;

    /**
     * 父样本ID
     */
    private Long parentId;

    /**
     * 样本名称
     */
    private String name;

    private String libraryIndex;

    /**
     * 送样质量
     */
    private Double deliverQuality;

    /**
     * 送样浓度
     */
    private Double deliverConcentration;

    /**
     * 实测浓度
     */
    private Double actualConcentration;

    /**
     * 原始体积
     */
    private Double initVolume;

    /**
     * 剩余体积
     */
    private Double surplusVolume;

    /**
     * 生产时间
     */
    private Date productTime;

    /**
     * 样本状态
     */
    private Integer sampleStatus;
    private String sampleStatusDesc;

    /**
     * 保质期
     */
    private String limitTime;

    /**
     * 库位
     */
    private String storageLocation;

    /**
     * 生产状态
     */
    private Integer productStatus;
    private String productStatusDesc;

    /**
     * 接收时间
     */
    private Date receiveTime;

    /**
     * 备注
     */
    private String note;

    /**
     * 是否合格
     */
    private Boolean qualified;

    /**
     * 不合格原因
     */
    private String disqualifiedReason;

    /**
     * 生成此样本执行ID
     */
    private Long executionId;

    public Long getExecutionId() {
        return executionId;
    }

    public void setExecutionId(Long executionId) {
        this.executionId = executionId;
    }

    public Long getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Long originalId) {
        this.originalId = originalId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getLibraryIndex() {
        return libraryIndex;
    }

    public void setLibraryIndex(String libraryIndex) {
        this.libraryIndex = libraryIndex;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public SampleLotDto getSampleLot() {
        return sampleLot;
    }

    public void setSampleLot(SampleLotDto sampleLot) {
        this.sampleLot = sampleLot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getProductTime() {
        return productTime;
    }

    public void setProductTime(Date productTime) {
        this.productTime = productTime;
    }

    public Integer getSampleStatus() {
        return sampleStatus;
    }

    public void setSampleStatus(Integer sampleStatus) {
        this.sampleStatus = sampleStatus;
    }

    public String getSampleStatusDesc() {
        return sampleStatusDesc;
    }

    public void setSampleStatusDesc(String sampleStatusDesc) {
        this.sampleStatusDesc = sampleStatusDesc;
    }

    public String getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(String limitTime) {
        this.limitTime = limitTime;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
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

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getQualified() {
        return qualified;
    }

    public void setQualified(Boolean qualified) {
        this.qualified = qualified;
    }

    public String getDisqualifiedReason() {
        return disqualifiedReason;
    }

    public void setDisqualifiedReason(String disqualifiedReason) {
        this.disqualifiedReason = disqualifiedReason;
    }

    public Double getDeliverQuality() {
        return deliverQuality;
    }

    public void setDeliverQuality(Double deliverQuality) {
        this.deliverQuality = deliverQuality;
    }

    public Double getDeliverConcentration() {
        return deliverConcentration;
    }

    public void setDeliverConcentration(Double deliverConcentration) {
        this.deliverConcentration = deliverConcentration;
    }

    public Double getActualConcentration() {
        return actualConcentration;
    }

    public void setActualConcentration(Double actualConcentration) {
        this.actualConcentration = actualConcentration;
    }

    public Double getInitVolume() {
        return initVolume;
    }

    public void setInitVolume(Double initVolume) {
        this.initVolume = initVolume;
    }

    public Double getSurplusVolume() {
        return surplusVolume;
    }

    public void setSurplusVolume(Double surplusVolume) {
        this.surplusVolume = surplusVolume;
    }
}

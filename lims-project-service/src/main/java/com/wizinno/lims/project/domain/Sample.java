package com.wizinno.lims.project.domain;

import com.wizinno.lims.common.domain.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author LiuMei on 2017-06-14.
 */
@Entity
@Table(name = "sample")
public class Sample extends BaseEntity{

    private String no;

    /**
     * 样本批次信息
     */
    @ManyToOne
    @JoinColumn(name = "sample_lot_id",nullable = false)
    private SampleLot sampleLot;

    /**
     * 原始样本ID
     */
    @Column(name="original_id")
    private Long originalId;

    /**
     * 父样本ID
     */
    @Column(name="parent_id")
    private Long parentId;

    /**
     * 产生此样本的执行ID
     * 工作样本此项有值
     */
    @Column(name="execution_id")
    private Long executionId;

    /**
     * 样本名称
     */
    @Column(nullable = false)
    private String name;

    /**
     * 文库Index
     */
    @Column(name="library_index")
    private String libraryIndex;

    /**
     * 送样质量
     */
    @Column(name="deliver_quality")
    private Double deliverQuality;

    /**
     * 送样浓度
     */
    @Column(name="deliver_concentration")
    private Double deliverConcentration;

    /**
     * 实测浓度
     */
    @Column(name="actual_concentration")
    private Double actualConcentration;

    /**
     * 原始体积
     */
    @Column(name="init_volume")
    private Double initVolume;

    /**
     * 剩余体积
     */
    @Column(name="surplus_volume")
    private Double surplusVolume;

    /**
     * 生产时间
     */
    @Column(name="product_time")
    private Date productTime;

    /**
     * 样本状态
     */
    @Column(name="sample_status",nullable = false)
    private Integer sampleStatus;

    /**
     * 保质期
     */
    @Column(name="limit_time")
    private String limitTime;

    /**
     * 库位
     */
    @Column(name="storage_location")
    private String storageLocation;

    /**
     * 生产状态
     */
    @Column(name="product_status")
    private Integer productStatus;

    /**
     * 接收时间
     */
    @Column(name="receive_time")
    private Date receiveTime;

    /**
     * 备注
     */
    @Column(columnDefinition = "TEXT")
    private String note;

    /**
     * 是否合格
     */
    private Boolean qualified;

    /**
     * 不合格原因
     */
    @Column(name="disqualified_reason",columnDefinition = "TEXT")
    private String disqualifiedReason;

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

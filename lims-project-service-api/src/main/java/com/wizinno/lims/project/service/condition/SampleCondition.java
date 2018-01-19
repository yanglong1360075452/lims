package com.wizinno.lims.project.service.condition;

import java.util.List;

/**
 * @author LiuMei on 2017-06-23.
 */
public class SampleCondition {

    private Long sampleLotId;

    private String sampleLotNo;

    private String filter;

    private Long projectId;

    private String sampleNo;

    private List<Long> sampleCategory;

    private Integer sampleStatus;

    private Integer productStatus;

    public Integer getSampleStatus() {
        return sampleStatus;
    }

    public void setSampleStatus(Integer sampleStatus) {
        this.sampleStatus = sampleStatus;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getSampleLotNo() {
        return sampleLotNo;
    }

    public void setSampleLotNo(String sampleLotNo) {
        this.sampleLotNo = sampleLotNo;
    }

    public List<Long> getSampleCategory() {
        return sampleCategory;
    }

    public void setSampleCategory(List<Long> sampleCategory) {
        this.sampleCategory = sampleCategory;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getSampleLotId() {
        return sampleLotId;
    }

    public void setSampleLotId(Long sampleLotId) {
        this.sampleLotId = sampleLotId;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
}

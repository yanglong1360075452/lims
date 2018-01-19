package com.wizinno.lims.project.service.dto.job.content;

/**
 * @author LiuMei on 2017-06-15.
 */
public class SampleExtractDto {

    /**
     * 提取样本类别
     */
    private Long sampleCategory;
    private String sampleCategoryDesc;

    /**
     * 样本类型
     */
    private Long sampleType;
    private String sampleTypeDesc;

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
}

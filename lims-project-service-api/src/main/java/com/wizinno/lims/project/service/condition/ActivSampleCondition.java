package com.wizinno.lims.project.service.condition;

/**
 * @author LiuMei
 * @date 2017-11-30.
 */
public class ActivSampleCondition {

    private Long jobId;

    private Long sampleLotId;

    private Long sampleCategory;

    private Integer sampleCount;

    public Integer getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(Integer sampleCount) {
        this.sampleCount = sampleCount;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getSampleLotId() {
        return sampleLotId;
    }

    public void setSampleLotId(Long sampleLotId) {
        this.sampleLotId = sampleLotId;
    }

    public Long getSampleCategory() {
        return sampleCategory;
    }

    public void setSampleCategory(Long sampleCategory) {
        this.sampleCategory = sampleCategory;
    }
}

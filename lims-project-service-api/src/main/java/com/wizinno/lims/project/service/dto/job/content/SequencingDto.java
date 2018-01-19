package com.wizinno.lims.project.service.dto.job.content;

/**
 * @author LiuMei on 2017-06-15.
 */
public class SequencingDto {

    /**
     * 测序平台
     */
    private Integer seqPlatform;

    /**
     * 测序策略
     */
    private Integer seqStrategy;

    /**
     * 数据量
     */
    private String dataAmount;

    /**
     * 数据量单位
     */
    private Integer dataAmountUnit;

    public Integer getSeqPlatform() {
        return seqPlatform;
    }

    public void setSeqPlatform(Integer seqPlatform) {
        this.seqPlatform = seqPlatform;
    }

    public Integer getSeqStrategy() {
        return seqStrategy;
    }

    public void setSeqStrategy(Integer seqStrategy) {
        this.seqStrategy = seqStrategy;
    }

    public String getDataAmount() {
        return dataAmount;
    }

    public void setDataAmount(String dataAmount) {
        this.dataAmount = dataAmount;
    }

    public Integer getDataAmountUnit() {
        return dataAmountUnit;
    }

    public void setDataAmountUnit(Integer dataAmountUnit) {
        this.dataAmountUnit = dataAmountUnit;
    }
}

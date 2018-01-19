package com.wizinno.lims.workflow.service.dto;

/**
 * @author LiuMei
 * @date 2017-11-03.
 *
 * 工作流活动向工作流传递此实体以获取某个样本某个参数的值
 */
public class ParamDto {

    /**
     * 工作流活动ID
     */
    private Long activId;

    /**
     * 获取的参数名称
     */
    private String param;

    /**
     * 获取的样本ID
     */
    private Long sampleId;

    public Long getActivId() {
        return activId;
    }

    public void setActivId(Long activId) {
        this.activId = activId;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Long getSampleId() {
        return sampleId;
    }

    public void setSampleId(Long sampleId) {
        this.sampleId = sampleId;
    }
}

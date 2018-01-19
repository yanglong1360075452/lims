package com.wizinno.lims.workflow.cfg.service.dto;

/**
 * @author LiuMei
 * @date 2017-11-02.
 */
public class CfgWfParamMapDto {

    private CfgWfDto cfgWf;

    /**
     * 输入活动
     */
    private CfgWfActivDto inActiv;

    /**
     * 输入参数变量名
     */
    private String inParam;

    /**
     * 依赖的输出活动
     */
    private CfgWfActivDto outActiv;

    /**
     * 依赖的输出变量名映射
     */
    private String outParam;

    public CfgWfDto getCfgWf() {
        return cfgWf;
    }

    public void setCfgWf(CfgWfDto cfgWf) {
        this.cfgWf = cfgWf;
    }

    public CfgWfActivDto getInActiv() {
        return inActiv;
    }

    public void setInActiv(CfgWfActivDto inActiv) {
        this.inActiv = inActiv;
    }

    public String getInParam() {
        return inParam;
    }

    public void setInParam(String inParam) {
        this.inParam = inParam;
    }

    public CfgWfActivDto getOutActiv() {
        return outActiv;
    }

    public void setOutActiv(CfgWfActivDto outActiv) {
        this.outActiv = outActiv;
    }

    public String getOutParam() {
        return outParam;
    }

    public void setOutParam(String outParam) {
        this.outParam = outParam;
    }

}

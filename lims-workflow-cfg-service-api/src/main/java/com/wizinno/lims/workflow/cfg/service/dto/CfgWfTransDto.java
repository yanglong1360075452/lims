package com.wizinno.lims.workflow.cfg.service.dto;

import javax.persistence.Column;

/**
 * @author LiuMei
 * @date 2017-11-02.
 */
public class CfgWfTransDto {

    /**
     * 工作流
     */
    private CfgWfDto cfgWf;

    /**
     * 起点活动
     */
    private CfgWfActivDto fromActiv;

    /**
     * 终点活动
     */
    private CfgWfActivDto toActiv;

    /**
     * 条件公式
     */
    @Column(name="cond_formula")
    private String condFormula;

    /**
     * 条件说明
     */
    @Column(name="cond_desc")
    private String condDesc;

    public CfgWfDto getCfgWf() {
        return cfgWf;
    }

    public void setCfgWf(CfgWfDto cfgWf) {
        this.cfgWf = cfgWf;
    }

    public CfgWfActivDto getFromActiv() {
        return fromActiv;
    }

    public void setFromActiv(CfgWfActivDto fromActiv) {
        this.fromActiv = fromActiv;
    }

    public CfgWfActivDto getToActiv() {
        return toActiv;
    }

    public void setToActiv(CfgWfActivDto toActiv) {
        this.toActiv = toActiv;
    }

    public String getCondFormula() {
        return condFormula;
    }

    public void setCondFormula(String condFormula) {
        this.condFormula = condFormula;
    }

    public String getCondDesc() {
        return condDesc;
    }

    public void setCondDesc(String condDesc) {
        this.condDesc = condDesc;
    }
}

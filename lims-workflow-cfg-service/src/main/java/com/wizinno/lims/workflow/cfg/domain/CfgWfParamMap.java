package com.wizinno.lims.workflow.cfg.domain;

import com.sun.org.apache.xpath.internal.operations.String;
import com.wizinno.lims.common.domain.BaseEntity;

import javax.persistence.*;

/**
 * 变量映射表
 * @author LiuMei
 * @date 2017-10-25.
 */
@Entity
@Table(name = "cfg_wf_param_map")
public class CfgWfParamMap extends BaseEntity{

    /**
     * 工作流
     */
    @ManyToOne
    @JoinColumn(name = "wf_id",nullable = false)
    private CfgWf cfgWf;

    /**
     * 输入活动
     */
    @ManyToOne
    @JoinColumn(name = "in_activ_id")
    private CfgWfActiv inActiv;

    /**
     * 输入参数变量名
     */
    @Column(name = "in_param")
    private java.lang.String inParam;

    /**
     * 依赖的输出活动
     */
    @ManyToOne
    @JoinColumn(name = "out_activ_id")
    private CfgWfActiv outActiv;

    /**
     * 依赖的输出变量名映射
     */
    @Column(name = "out_param")
    private String outParam;

    public CfgWf getCfgWf() {
        return cfgWf;
    }

    public void setCfgWf(CfgWf cfgWf) {
        this.cfgWf = cfgWf;
    }

    public CfgWfActiv getInActiv() {
        return inActiv;
    }

    public void setInActiv(CfgWfActiv inActiv) {
        this.inActiv = inActiv;
    }

    public java.lang.String getInParam() {
        return inParam;
    }

    public void setInParam(java.lang.String inParam) {
        this.inParam = inParam;
    }

    public CfgWfActiv getOutActiv() {
        return outActiv;
    }

    public void setOutActiv(CfgWfActiv outActiv) {
        this.outActiv = outActiv;
    }

    public String getOutParam() {
        return outParam;
    }

    public void setOutParam(String outParam) {
        this.outParam = outParam;
    }
}

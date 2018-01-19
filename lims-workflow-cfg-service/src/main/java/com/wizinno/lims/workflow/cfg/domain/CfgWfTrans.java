package com.wizinno.lims.workflow.cfg.domain;

import com.wizinno.lims.common.domain.BaseEntity;

import javax.persistence.*;

/**
 * 工作流节点走向表
 * @author LiuMei
 * @date 2017-10-25.
 */
@Entity
@Table(name = "cfg_wf_trans")
public class CfgWfTrans extends BaseEntity{

    /**
     * 工作流
     */
    @ManyToOne
    @JoinColumn(name = "wf_id",nullable = false)
    private CfgWf cfgWf;

    /**
     * 起点活动
     */
    @ManyToOne
    @JoinColumn(name = "from_activ_id")
    private CfgWfActiv fromActiv;

    /**
     * 终点活动
     */
    @ManyToOne
    @JoinColumn(name = "to_activ_id")
    private CfgWfActiv toActiv;

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

    public CfgWf getCfgWf() {
        return cfgWf;
    }

    public void setCfgWf(CfgWf cfgWf) {
        this.cfgWf = cfgWf;
    }

    public CfgWfActiv getFromActiv() {
        return fromActiv;
    }

    public void setFromActiv(CfgWfActiv fromActiv) {
        this.fromActiv = fromActiv;
    }

    public CfgWfActiv getToActiv() {
        return toActiv;
    }

    public void setToActiv(CfgWfActiv toActiv) {
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

package com.wizinno.lims.workflow.cfg.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * @author LiuMei
 * @date 2017-10-25.
 */
@Embeddable
public class ActivParamCompositeKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "activ_id")
    private CfgWfActiv cfgWfActiv;

    private String param;

    public CfgWfActiv getCfgWfActiv() {
        return cfgWfActiv;
    }

    public void setCfgWfActiv(CfgWfActiv cfgWfActiv) {
        this.cfgWfActiv = cfgWfActiv;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}

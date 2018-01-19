package com.wizinno.lims.workflow.cfg.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author LiuMei
 * @date 2017-10-25.
 */
@Entity
@Table(name = "cfg_wf_activ_param")
public class CfgWfActivParam {

    @EmbeddedId
    private ActivParamCompositeKey id;

    /**
     * 变量类型
     * ENUM：config/in/out/runtime
     */
    @Column(name="param_type")
    private Integer paramType;

    /**
     * 变量注释
     */
    private String comments;

    @Column(nullable = false,name = "create_by")
    protected Long createBy;

    @Column(nullable = false,name = "update_by")
    protected Long updateBy;

    @Column(name = "create_time",nullable = false)
    protected Date createTime;

    @Column(name = "update_time",nullable = false)
    protected Date updateTime;

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public ActivParamCompositeKey getId() {
        return id;
    }

    public void setId(ActivParamCompositeKey id) {
        this.id = id;
    }

    public Integer getParamType() {
        return paramType;
    }

    public void setParamType(Integer paramType) {
        this.paramType = paramType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

package com.wizinno.lims.workflow.cfg.domain;

import com.wizinno.lims.common.domain.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static com.sun.org.apache.xml.internal.serialize.Method.TEXT;

/**
 * 工作流配置表
 * @author LiuMei
 * @date 2017-10-25.
 */
@Entity
@Table(name = "cfg_wf")
public class CfgWf extends BaseEntity {

    /**
     * 应用分类
     * ENUM:NGS/PCR…
     */
    private Integer application;

    /**
     * 工作流类别
     * ENUM：样本提取、样本检测、文库制备。。。
     */
    private Integer category;

    /**
     * 工作流名称
     */
    @Column(nullable = false)
    private String name;

    /**
     * 工作流描述
     */
    private String description;

    /**
     * 详细说明
     * 工作流SOP的整体说明
     */
    @Column(columnDefinition= TEXT)
    private String sop;

    /**
     * 备注
     */
    private String memo;

    /**
     * 版本号
     */
    private String ver;

    /**
     * 发布日期
     */
    @Column(name="release_time")
    private Date releaseTime;

    /**
     * 工作流步骤条组件名称
     */
    @Column(name="url_step")
    private String urlStep;

    @ManyToMany(fetch = FetchType.EAGER, cascade={CascadeType.REFRESH})
    @JoinTable(name="cfg_wf_activ_r", joinColumns=@JoinColumn(name="wf_id"), inverseJoinColumns=@JoinColumn(name="activ_id"))
    private List<CfgWfActiv> cfgWfActivList;

    public String getUrlStep() {
        return urlStep;
    }

    public void setUrlStep(String urlStep) {
        this.urlStep = urlStep;
    }

    public List<CfgWfActiv> getCfgWfActivList() {
        return cfgWfActivList;
    }

    public void setCfgWfActivList(List<CfgWfActiv> cfgWfActivList) {
        this.cfgWfActivList = cfgWfActivList;
    }

    public Integer getApplication() {
        return application;
    }

    public void setApplication(Integer application) {
        this.application = application;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSop() {
        return sop;
    }

    public void setSop(String sop) {
        this.sop = sop;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }
}

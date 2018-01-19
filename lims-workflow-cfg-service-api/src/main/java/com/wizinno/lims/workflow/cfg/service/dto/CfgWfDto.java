package com.wizinno.lims.workflow.cfg.service.dto;

import com.wizinno.lims.common.domain.BaseDto;

import java.util.Date;
import java.util.List;

/**
 * @author LiuMei
 * @date 2017-10-25.
 */
public class CfgWfDto extends BaseDto {

    /**
     * 应用分类
     * ENUM:NGS/PCR…
     */
    private Integer application;
    /**
     * 应用分类描述
     */
    private String applicationDesc;

    /**
     * 工作流类别
     * ENUM：样本提取、样本检测、文库制备。。。
     */
    private Integer category;
    /**
     * 类别描述
     */
    private String categoryDesc;

    /**
     * 工作流名称
     */
    private String name;

    /**
     * 工作流描述
     */
    private String description;

    /**
     * 详细说明
     * 工作流SOP的整体说明
     */
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
    private Date releaseTime;

    /**
     * 活动节点列表
     */
    private List<CfgWfActivDto> cfgWfActivList;

    /**
     * 活动节点走向列表
     */
    private List<CfgWfTransDto> cfgWfTransList;

    /**
     * 工作流步骤条组件名称
     */
    private String urlStep;

    public String getUrlStep() {
        return urlStep;
    }

    public void setUrlStep(String urlStep) {
        this.urlStep = urlStep;
    }

    public List<CfgWfActivDto> getCfgWfActivList() {
        return cfgWfActivList;
    }

    public void setCfgWfActivList(List<CfgWfActivDto> cfgWfActivList) {
        this.cfgWfActivList = cfgWfActivList;
    }

    public List<CfgWfTransDto> getCfgWfTransList() {
        return cfgWfTransList;
    }

    public void setCfgWfTransList(List<CfgWfTransDto> cfgWfTransList) {
        this.cfgWfTransList = cfgWfTransList;
    }

    public Integer getApplication() {
        return application;
    }

    public void setApplication(Integer application) {
        this.application = application;
    }

    public String getApplicationDesc() {
        return applicationDesc;
    }

    public void setApplicationDesc(String applicationDesc) {
        this.applicationDesc = applicationDesc;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
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

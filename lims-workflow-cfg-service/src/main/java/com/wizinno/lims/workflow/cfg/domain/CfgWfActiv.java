package com.wizinno.lims.workflow.cfg.domain;

import com.wizinno.lims.common.domain.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 工作流活动配置表
 * @author LiuMei
 * @date 2017-10-25.
 */
@Entity
@Table(name = "cfg_wf_activ")
public class CfgWfActiv extends BaseEntity{

    /**
     * 活动类别
     * ENUM：样本出库、浓度检测、质量初测、质量精测。。。
     */
    private Integer category;

    /**
     * 活动名称
     */
    @Column(nullable = false)
    private String name;

    /**
     * 活动描述
     */
    private String description;

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
    @Column(name = "release_time")
    private Date releaseTime;

    /**
     * UI操作页面
     * UI操作页面的入口
     */
    @Column(name = "url_op")
    private String urlOp;

    /**
     * 报告模板
     * 报告输出页面html格式，用于web显示或pdf报告导出
     */
    @Column(name = "url_rpt")
    private String urlRpt;

    /**
     * 在线SOP
     * 活动在线SOP手册页面入口
     */
    @Column(name = "url_sop")
    private String urlSop;

    /**
     * JAVA类
     * 后台业务逻辑java入口（该类实现工作流活动接口）
     */
    @Column(name = "java_class")
    private String javaClass;

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

    public String getUrlOp() {
        return urlOp;
    }

    public void setUrlOp(String urlOp) {
        this.urlOp = urlOp;
    }

    public String getUrlRpt() {
        return urlRpt;
    }

    public void setUrlRpt(String urlRpt) {
        this.urlRpt = urlRpt;
    }

    public String getUrlSop() {
        return urlSop;
    }

    public void setUrlSop(String urlSop) {
        this.urlSop = urlSop;
    }

    public String getJavaClass() {
        return javaClass;
    }

    public void setJavaClass(String javaClass) {
        this.javaClass = javaClass;
    }
}

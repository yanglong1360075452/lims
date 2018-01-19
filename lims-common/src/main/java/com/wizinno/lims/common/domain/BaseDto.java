package com.wizinno.lims.common.domain;

import java.util.Date;

/**
 * @author LiuMei
 * @date 2017-10-26.
 */
public class BaseDto {

    private Long id;

    private Long createBy;

    private Long updateBy;

    private Date createTime;

    private Date updateTime;

    public Long getCreateBy() {
        return createBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}

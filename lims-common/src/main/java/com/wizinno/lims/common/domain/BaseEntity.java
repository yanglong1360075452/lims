package com.wizinno.lims.common.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author LiuMei
 * @date 2017-10-25.
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false,name = "create_by")
    protected Long createBy;

    @Column(nullable = false,name = "update_by")
    protected Long updateBy;

    @Column(name = "create_time",nullable = false)
    protected Date createTime;

    @Column(name = "update_time",nullable = false)
    protected Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
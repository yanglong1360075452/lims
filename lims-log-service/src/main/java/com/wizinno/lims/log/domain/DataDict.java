package com.wizinno.lims.log.domain;

import com.wizinno.lims.common.domain.BaseEntity;

import javax.persistence.*;

/**
 * @author LiuMei on 2017-06-19.
 */
@Entity
@Table(name = "data_dict")
public class DataDict extends BaseEntity {

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "second_parent_id")
    private Long secondParentId;

    @Column(nullable = false)
    private Integer type;

    @Column(nullable = false)
    private Integer code;

    @Column(nullable = false)
    private String description;

    public Long getSecondParentId() {
        return secondParentId;
    }

    public void setSecondParentId(Long secondParentId) {
        this.secondParentId = secondParentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

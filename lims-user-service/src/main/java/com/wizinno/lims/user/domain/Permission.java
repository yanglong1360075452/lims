package com.wizinno.lims.user.domain;

import com.wizinno.lims.common.domain.BaseEntity;

import javax.persistence.*;

/**
 * @author LiuMei on 2017-05-31.
 */
@Entity
@Table(name = "permission")
public class Permission extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer code;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

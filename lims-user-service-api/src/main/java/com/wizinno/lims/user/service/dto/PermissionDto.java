package com.wizinno.lims.user.service.dto;

import com.wizinno.lims.common.domain.BaseDto;

/**
 * @author LiuMei on 2017-06-16.
 */
public class PermissionDto extends BaseDto {

    private String name;

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

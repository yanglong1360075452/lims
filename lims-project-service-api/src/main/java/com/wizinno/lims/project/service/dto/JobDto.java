package com.wizinno.lims.project.service.dto;

import com.wizinno.lims.common.domain.BaseDto;

/**
 * @author LiuMei on 2017-06-14.
 */
public class JobDto<T> extends BaseDto {

    private Integer type;
    private String typeDesc;

    private ProjectDto project;

    private T params;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    public ProjectDto getProject() {
        return project;
    }

    public void setProject(ProjectDto project) {
        this.project = project;
    }

}

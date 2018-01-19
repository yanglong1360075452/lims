package com.wizinno.lims.project.domain;

import com.wizinno.lims.common.domain.BaseEntity;

import javax.persistence.*;

/**
 * @author LiuMei on 2017-06-14.
 */
@Entity
@Table(name = "job")
public class Job extends BaseEntity {

    private Integer type;

    @Column(columnDefinition="JSON")
    private String params;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name="project_id")
    private Project project;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}

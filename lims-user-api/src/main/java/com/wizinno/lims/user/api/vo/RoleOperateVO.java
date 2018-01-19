package com.wizinno.lims.user.api.vo;

import java.util.List;

/**
 * @author LiuMei on 2017-06-02.
 */
public class RoleOperateVO {

    private Long id;

    private String name;

    private String description;

    private List<Long> permissions;

    @Override
    public String toString() {
        return "RoleOperateVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", permissions=" + permissions +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Long> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Long> permissions) {
        this.permissions = permissions;
    }
}

package com.wizinno.lims.user.service.dto;

import com.wizinno.lims.common.domain.BaseDto;

import java.util.Set;

/**
 * @author LiuMei on 2017-06-16.
 */
public class RoleDto extends BaseDto{

    private String name;

    private String description;

    private Set<PermissionDto> permissions;

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

    public Set<PermissionDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionDto> permissions) {
        this.permissions = permissions;
    }

}

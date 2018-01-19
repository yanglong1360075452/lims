package com.wizinno.lims.user.domain;

import com.wizinno.lims.common.domain.BaseEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * @author LiuMei on 2017-05-27.
 */
@Entity
@Table(name = "role")
public class Role extends BaseEntity{

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade={CascadeType.REFRESH})
    @JoinTable(name = "role_permission_r", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions;

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

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}

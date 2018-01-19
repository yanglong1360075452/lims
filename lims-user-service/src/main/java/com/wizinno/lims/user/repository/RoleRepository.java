package com.wizinno.lims.user.repository;

import com.wizinno.lims.user.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LiuMei on 2017-05-31.
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

    /**
     * 根据角色名查询角色信息
     * @param name
     * @return
     */
    Role findByName(String name);
}

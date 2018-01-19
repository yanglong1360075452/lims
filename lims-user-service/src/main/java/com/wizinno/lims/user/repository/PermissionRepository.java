package com.wizinno.lims.user.repository;

import com.wizinno.lims.user.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author LiuMei on 2017-05-31.
 */
public interface PermissionRepository extends JpaRepository<Permission,Long> {
}

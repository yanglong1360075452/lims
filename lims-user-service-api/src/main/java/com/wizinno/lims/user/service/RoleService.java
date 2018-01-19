package com.wizinno.lims.user.service;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.user.service.dto.RoleDto;
import org.springframework.data.domain.PageRequest;

/**
 * @author LiuMei on 2017-06-16.
 */
public interface RoleService {

    /**
     * 根据ID查询角色信息
     * @param id
     * @return
     */
    RoleDto findById(long id);

    /**
     * 根据角色名查询角色信息
     * @param name
     * @return
     */
    RoleDto findByName(String name);

    /**
     * 新增/更新角色信息
     * @param roleDto
     */
    void addOrUpdateRole(RoleDto roleDto);

    /**
     * 分页查询角色信息
     * @param pageRequest
     * @return
     */
    PageData<RoleDto> findAll(PageRequest pageRequest);

    /**
     * 根据角色ID删除角色
     * @param roleId
     */
    void deleteRole(long roleId);
}

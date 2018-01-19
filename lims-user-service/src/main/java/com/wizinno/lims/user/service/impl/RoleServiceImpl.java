package com.wizinno.lims.user.service.impl;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.user.domain.Permission;
import com.wizinno.lims.user.domain.Role;
import com.wizinno.lims.user.repository.RoleRepository;
import com.wizinno.lims.user.service.RoleService;
import com.wizinno.lims.user.service.dto.PermissionDto;
import com.wizinno.lims.user.service.dto.RoleDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author LiuMei on 2017-06-16.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDto findById(long id) {
        Role role = roleRepository.findOne(id);
        return roleToDto(role);
    }

    @Override
    public RoleDto findByName(String name) {
        Role role = roleRepository.findByName(name);
        return roleToDto(role);
    }

    @Override
    public void addOrUpdateRole(RoleDto roleDto) {
        Role role = roleDtoToPo(roleDto);
        roleRepository.save(role);
    }

    @Override
    public PageData<RoleDto> findAll(PageRequest pageRequest) {
        Page<Role> page = roleRepository.findAll(pageRequest);
        long totalElements = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<Role> content = page.getContent();
        List<RoleDto> roleDTOs = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(content)) {
            for (Role role : content) {
                    roleDTOs.add(roleToDto(role));
                }
        }
        return new PageData(pageRequest.getPageNumber(), pageRequest.getPageSize(), roleDTOs, totalPages, totalElements);
    }

    @Override
    public void deleteRole(long roleId) {
        roleRepository.delete(roleId);
    }

    private Role roleDtoToPo(RoleDto roleDto) {
        if (roleDto != null) {
            Role role = new Role();
            BeanUtils.copyProperties(roleDto, role);
            Set<PermissionDto> permissionDTOs = roleDto.getPermissions();
            if (CollectionUtils.isNotEmpty(permissionDTOs)) {
                Set<Permission> permissions = new HashSet<>();
                Permission permission;
                for (PermissionDto permissionDto : permissionDTOs) {
                    permission = new Permission();
                    BeanUtils.copyProperties(permissionDto, permission);
                    permissions.add(permission);
                }
                role.setPermissions(permissions);
            }
            return role;
        }else {
            return null;
        }
    }

    protected static RoleDto roleToDto(Role role) {
        if (role != null) {
            RoleDto roleDto = new RoleDto();
            BeanUtils.copyProperties(role, roleDto);
            Set<Permission> permissions = role.getPermissions();
            if (CollectionUtils.isNotEmpty(permissions)) {
                Set<PermissionDto> permissionDTOs = new HashSet<>();
                PermissionDto permissionDto;
                for (Permission permission : permissions) {
                    permissionDto = new PermissionDto();
                    BeanUtils.copyProperties(permission, permissionDto);
                    permissionDTOs.add(permissionDto);
                }
                roleDto.setPermissions(permissionDTOs);
            }
            return roleDto;
        } else {
            return null;
        }
    }
}

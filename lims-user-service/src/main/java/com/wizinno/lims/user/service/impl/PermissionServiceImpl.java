package com.wizinno.lims.user.service.impl;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.user.domain.Permission;
import com.wizinno.lims.user.repository.PermissionRepository;
import com.wizinno.lims.user.service.PermissionService;
import com.wizinno.lims.user.service.dto.PermissionDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuMei on 2017-06-16.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public PageData<PermissionDto> findAll(PageRequest pageRequest) {

        Page page = permissionRepository.findAll(pageRequest);
        long totalElements = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<Permission> content = page.getContent();

        List<PermissionDto> permissionDTOs = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(content)) {
            PermissionDto permissionDto;
            for (Permission permission : content) {
                permissionDto = new PermissionDto();
                BeanUtils.copyProperties(permission, permissionDto);
                permissionDTOs.add(permissionDto);
            }
        }
        return new PageData(pageRequest.getPageNumber(), pageRequest.getPageSize(), permissionDTOs, totalPages, totalElements);
    }

    @Override
    public PermissionDto findById(long id) {
        Permission permission = permissionRepository.findOne(id);
        PermissionDto permissionDto = new PermissionDto();
        BeanUtils.copyProperties(permission,permissionDto);
        return permissionDto;
    }

}

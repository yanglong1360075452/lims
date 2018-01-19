package com.wizinno.lims.user.service;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.user.service.dto.PermissionDto;
import org.springframework.data.domain.PageRequest;

/**
 * @author LiuMei on 2017-06-16.
 */
public interface PermissionService {

    /**
     * 分页查询权限信息
     * @param pageRequest
     * @return
     */
    PageData<PermissionDto> findAll(PageRequest pageRequest);

    /**
     * 根据权限ID查询权限信息
     * @param id
     * @return
     */
    PermissionDto findById(long id);

}

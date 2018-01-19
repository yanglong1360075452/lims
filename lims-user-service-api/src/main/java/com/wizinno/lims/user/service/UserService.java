package com.wizinno.lims.user.service;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.user.service.dto.UserDto;
import com.wizinno.lims.user.service.dto.UserSimpleDto;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author LiuMei on 2017-06-16.
 */
public interface UserService {

    /**
     * 根据用户名查询用户信息
     * @param name
     * @return
     */
    UserDto findUserByName(String name);

    /**
     * 新增/更新用户信息
     * @param userDto
     */
    void addOrUpdateUser(UserDto userDto);

    /**
     * 分页查询用户信息
     * @param pageRequest
     * @return
     */
    PageData findAll(PageRequest pageRequest);

    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    UserDto findById(long id);

    /**
     * 根据用户ID查询用户权限码
     * @param userId
     * @return
     */
    List<Integer> getUserPermissionsCode(long userId);

    /**
     * 根据用户ID查询用户简单信息
     * 用户数据库存储字段,不包含其他表关联字段
     * @param id
     * @return
     */
    UserSimpleDto findSimpleById(long id);

    /**
     * 查询所有用户简单信息
     * @return
     */
    List<UserSimpleDto> findAllSimple();
}

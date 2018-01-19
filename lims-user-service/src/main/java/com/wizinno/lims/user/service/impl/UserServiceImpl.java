package com.wizinno.lims.user.service.impl;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.user.domain.Role;
import com.wizinno.lims.user.domain.User;
import com.wizinno.lims.user.repository.UserRepository;
import com.wizinno.lims.user.service.UserService;
import com.wizinno.lims.user.service.dto.RoleDto;
import com.wizinno.lims.user.service.dto.UserDto;
import com.wizinno.lims.user.service.dto.UserSimpleDto;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto findUserByName(String name) {
        User user = userRepository.findByUsername(name);
        return userToDto(user);
    }

    @Override
    public void addOrUpdateUser(UserDto userDto) {
        if (userDto != null) {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            Set<RoleDto> roleDTOs = userDto.getRoles();
            if (CollectionUtils.isNotEmpty(roleDTOs)) {
                Set<Role> roles = new HashSet<>();
                Role role;
                for (RoleDto roleDto : roleDTOs) {
                    role = new Role();
                    BeanUtils.copyProperties(roleDto, role);
                    roles.add(role);
                }
                user.setRoles(roles);
            }
            userRepository.save(user);
        }
    }

    @Override
    public PageData findAll(PageRequest pageRequest) {
        Page<User> page = userRepository.findAll(pageRequest);
        long totalElements = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<User> content = page.getContent();

        List<UserDto> userDTOs = new ArrayList<>();
        if (content != null && content.size() > 0) {
            UserDto userDto;
            for (User user : content) {
                userDto = new UserDto();
                BeanUtils.copyProperties(user, userDto);
                Set<Role> roles = user.getRoles();
                if (CollectionUtils.isNotEmpty(roles)) {
                    Set<RoleDto> roleDTOs = new HashSet<>();
                    for (Role role : roles) {
                        roleDTOs.add(RoleServiceImpl.roleToDto(role));
                    }
                    userDto.setRoles(roleDTOs);
                }
                userDTOs.add(userDto);
            }
        }
        return new PageData(pageRequest.getPageNumber(), pageRequest.getPageSize(), userDTOs, totalPages, totalElements);
    }

    @Override
    public UserDto findById(long id) {
        return userToDto(userRepository.findOne(id));
    }

    @Override
    public List<Integer> getUserPermissionsCode(long userId) {
        return userRepository.getUserPermissionsCode(userId);
    }

    @Override
    public UserSimpleDto findSimpleById(long id) {
        User user = userRepository.findOne(id);
        if (user != null) {
            UserSimpleDto simpleDto = new UserSimpleDto();
            BeanUtils.copyProperties(user, simpleDto);
            return simpleDto;
        } else {
            return null;
        }
    }

    @Override
    public List<UserSimpleDto> findAllSimple() {
        List<User> all = userRepository.findAll();
        if (CollectionUtils.isNotEmpty(all)) {
            List<UserSimpleDto> userSimpleDTOs = new ArrayList<>();
            UserSimpleDto userSimpleDto;
            for (User user : all) {
                userSimpleDto = new UserSimpleDto();
                BeanUtils.copyProperties(user,userSimpleDto);
                userSimpleDTOs.add(userSimpleDto);
            }
            return userSimpleDTOs;
        } else {
            return null;
        }
    }

    public UserDto userToDto(User user) {
        if (user != null) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            Set<Role> roles = user.getRoles();
            if (CollectionUtils.isNotEmpty(roles)) {
                Set<RoleDto> roleDTOs = new HashSet<>();
                RoleDto roleDto;
                for (Role role : roles) {
                    roleDto = new RoleDto();
                    BeanUtils.copyProperties(role, roleDto);
                    roleDTOs.add(roleDto);
                }
                userDto.setRoles(roleDTOs);
            }
            return userDto;
        } else {
            return null;
        }
    }

}

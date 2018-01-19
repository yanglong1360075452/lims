package com.wizinno.lims.user.api;

import com.wizinno.lims.common.controller.BaseController;
import com.wizinno.lims.common.data.LogOperateEnum;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.common.security.UserContext;
import com.wizinno.lims.log.service.aspect.SystemControllerLog;
import com.wizinno.lims.user.api.vo.UserOperateVO;
import com.wizinno.lims.user.service.RoleService;
import com.wizinno.lims.user.service.UserService;
import com.wizinno.lims.user.service.dto.RoleDto;
import com.wizinno.lims.user.service.dto.UserDto;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.wizinno.lims.common.data.LogOperateTypeEnum.USER;


/**
 * @author LiuMei on 2017-05-27.
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 新建用户
     *
     * @param userOperateVO
     * @return
     */
    @SystemControllerLog(operate = LogOperateEnum.USER_CREATE, operateType = USER)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseVO createUser(@RequestBody UserOperateVO userOperateVO) {
        String username = userOperateVO.getUsername();
        String password = userOperateVO.getPassword();
        String nickname = userOperateVO.getNickname();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(nickname)) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        UserDto user = userService.findUserByName(username);
        if (user != null) {
            throw new CustomException(CustomExceptionCode.RECORD_EXIST);
        }
        user = new UserDto();
        BeanUtils.copyProperties(userOperateVO, user);
        Long userId = UserContext.getLoginUserID();
        user.setPassword(passwordEncoder.encode(password));
        user.setCreateBy(userId);
        user.setUpdateBy(userId);
        user.setStatus(true);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        List<Long> roles = userOperateVO.getRoles();
        if (CollectionUtils.isNotEmpty(roles)) {
            user.setRoles(roleIdTrans(roles, null));
        }
        userService.addOrUpdateUser(user);
        return new ResponseVO();
    }

    /**
     * 更新用户信息
     *
     * @param userOperateVO
     * @return
     */
    @SystemControllerLog(operate = LogOperateEnum.USER_UPDATE, operateType = USER)
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseVO updateUser(@RequestBody UserOperateVO userOperateVO) {
        Long id = userOperateVO.getId();
        String username = userOperateVO.getUsername();
        if (id == null || username == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        UserDto user = userService.findUserByName(username);
        if (user == null) {
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        String oldUsername = user.getUsername();
        if (id == 1) {
            if (!username.equals(oldUsername)) {
                throw new CustomException(CustomExceptionCode.CANNOT_UPDATE);
            }
        }
        String passwordOld = user.getPassword();
        BeanUtils.copyProperties(userOperateVO, user);
        Long userId = UserContext.getLoginUserID();
        user.setPassword(passwordOld);
        user.setUpdateBy(userId);
        user.setUpdateTime(new Date());
        List<Long> roles = userOperateVO.getRoles();
        user.setRoles(roleIdTrans(roles, id));

        userService.addOrUpdateUser(user);
        return new ResponseVO();
    }

    /**
     * 获取用户列表
     *
     * @param page
     * @param length
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseVO getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "length", defaultValue = "10") int length) {
        PageRequest pageRequest = new PageRequest(page - 1, length);
        return new ResponseVO(userService.findAll(pageRequest));
    }

    @RequestMapping(value = "/simple",method = RequestMethod.GET)
    public ResponseVO getSimpleUsers() {
        return new ResponseVO(userService.findAllSimple());
    }

    /**
     * 根据用户名称查询用户
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public ResponseVO findUserByName(@PathVariable String username) {
        UserDto userDto = userService.findUserByName(username);
        return new ResponseVO(userDto);
    }
    /**
     * 根据用户名称查询用户并判断用户密码是否匹配
     *
     * @param password
     * @return
     */
    @RequestMapping(value = "/password/{password}", method = RequestMethod.GET)
    public ResponseVO findUserByNameP(@PathVariable String password) {
        long userId = UserContext.getLoginUserID();
        UserDto user = userService.findById(userId);
        boolean matches = passwordEncoder.matches(password,user.getPassword());
        if(!matches){
            throw new CustomException(CustomExceptionCode.PASSWORD_ERROR);
        }
        return new ResponseVO(user);
    }

    /**
     * 更改用户状态
     *
     * @param id
     * @return
     */
    @SystemControllerLog(operate = LogOperateEnum.USER_STATUS, operateType = USER)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseVO updateStatus(@PathVariable long id) {
        if (id == 1) {
            throw new CustomException(CustomExceptionCode.CANNOT_UPDATE);
        }
        UserDto user = userService.findById(id);
        if (user == null) {
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        Long userId = UserContext.getLoginUserID();
        user.setStatus(!user.getStatus());
        user.setUpdateBy(userId);
        user.setUpdateTime(new Date());
        userService.addOrUpdateUser(user);
        return new ResponseVO();
    }

    /**
     * 重置密码
     *
     * @return
     */
    @SystemControllerLog(operate = LogOperateEnum.RESET_PASSWORD, operateType = USER)
    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public ResponseVO resetPassword(@RequestBody UserDto user) {
        if (user == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        long id = user.getId();
        String password = user.getPassword();
        if (StringUtils.isBlank(password)) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        UserDto users = userService.findById(id);
        if (users == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        Long userId = UserContext.getLoginUserID();
        users.setUpdateBy(userId);
        users.setCreateBy(userId);
        users.setPassword(passwordEncoder.encode(password));
        users.setUpdateTime(new Date());
        userService.addOrUpdateUser(users);
        return new ResponseVO();
    }

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public ResponseVO findUserByName(@PathVariable long id) {
        UserDto userDto = userService.findById(id);
        List<Integer> userPermissionsCode = userService.getUserPermissionsCode(id);
        userDto.setPermissions(userPermissionsCode);
        return new ResponseVO(userDto);
    }

    public Set<RoleDto> roleIdTrans(List<Long> ids, Long userId) {
        Set<RoleDto> roleList = null;
        if (CollectionUtils.isNotEmpty(ids)) {
            roleList = new HashSet<>();
            for (Long id : ids) {
                roleList.add(roleService.findById(id));
            }
        }
        if (userId != null && userId.equals(1)) {
            roleList.add(roleService.findById(1L));
        }
        return roleList;
    }
}

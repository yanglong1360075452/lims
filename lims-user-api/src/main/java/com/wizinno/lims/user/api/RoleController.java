package com.wizinno.lims.user.api;

import com.wizinno.lims.common.controller.BaseController;
import com.wizinno.lims.common.data.LogOperateEnum;
import com.wizinno.lims.common.data.LogOperateTypeEnum;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.common.security.UserContext;
import com.wizinno.lims.log.service.aspect.SystemControllerLog;
import com.wizinno.lims.user.api.vo.RoleOperateVO;
import com.wizinno.lims.user.service.PermissionService;
import com.wizinno.lims.user.service.RoleService;
import com.wizinno.lims.user.service.dto.PermissionDto;
import com.wizinno.lims.user.service.dto.RoleDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author LiuMei on 2017-06-02.
 */
@RestController
@RequestMapping("/api/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 新建角色
     *
     * @param roleOperateVO
     * @return
     */
    @SystemControllerLog(operate = LogOperateEnum.ROLE_CREATE, operateType = LogOperateTypeEnum.ROLE)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseVO createRole(@RequestBody RoleOperateVO roleOperateVO) throws CustomException {
        String roleName = roleOperateVO.getName();
        if (roleName == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        RoleDto role = roleService.findByName(roleName);
        if (role != null) {
            throw new CustomException(CustomExceptionCode.RECORD_EXIST);
        }
        Long userId = UserContext.getLoginUserID();
        role = new RoleDto();
        role.setName(roleName);
        role.setDescription(roleOperateVO.getDescription());
        role.setCreateBy(userId);
        role.setUpdateBy(userId);
        role.setCreateTime(new Date());
        role.setUpdateTime(new Date());
        List<Long> permissions = roleOperateVO.getPermissions();
        if (CollectionUtils.isNotEmpty(permissions)) {
            role.setPermissions(permissionIdTrans(permissions, null));
        }
        roleService.addOrUpdateRole(role);
        return new ResponseVO();
    }

    /**
     * 修改角色
     *
     * @param roleOperateVO
     * @return
     */
    @SystemControllerLog(operate = LogOperateEnum.ROLE_UPDATE, operateType = LogOperateTypeEnum.ROLE)
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseVO updateRole(@RequestBody RoleOperateVO roleOperateVO) throws CustomException {
        Long id = roleOperateVO.getId();
        String roleName = roleOperateVO.getName();
        if (id == null || roleName == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        RoleDto role = roleService.findById(id);
        if (role == null) {
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        String oldRoleName = role.getName();
        if (id == 1) {
            if (!roleName.equals(oldRoleName)) {
                throw new CustomException(CustomExceptionCode.CANNOT_UPDATE);
            }
        }
        Long userId = UserContext.getLoginUserID();
        role.setName(roleName);
        role.setDescription(roleOperateVO.getDescription());
        role.setUpdateBy(userId);
        role.setUpdateTime(new Date());
        List<Long> permissions = roleOperateVO.getPermissions();
        role.setPermissions(permissionIdTrans(permissions, id));
        roleService.addOrUpdateRole(role);
        return new ResponseVO();
    }

    /**
     * 获取角色列表
     *
     * @param page
     * @param length
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseVO getRoles(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "length", defaultValue = "10") int length) {
        PageRequest pageRequest = new PageRequest(page - 1, length);
        return new ResponseVO(roleService.findAll(pageRequest));
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @SystemControllerLog(operate = LogOperateEnum.ROLE_DELETE, operateType = LogOperateTypeEnum.ROLE)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseVO deleteRole(@PathVariable long id) throws CustomException {
        RoleDto role = roleService.findById(id);
        if (role == null) {
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        roleService.deleteRole(id);
        return new ResponseVO();
    }

    public Set<PermissionDto> permissionIdTrans(List<Long> ids, Long roleId) {
        Set<PermissionDto> permissionList = new HashSet<>();
        if (CollectionUtils.isNotEmpty(ids)) {
            for (Long id : ids) {
                permissionList.add(permissionService.findById(id));
            }
        }
        if (roleId != null && roleId.equals(1)) {
            permissionList.add(permissionService.findById(1L));
        }
        return permissionList;
    }
}

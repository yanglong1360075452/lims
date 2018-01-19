package com.wizinno.lims.user.api;

import com.wizinno.lims.common.controller.BaseController;
import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.user.service.PermissionService;
import com.wizinno.lims.user.service.dto.PermissionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiuMei on 2017-06-02.
 */
@RestController
@RequestMapping("/api/permission")
public class PermissionController extends BaseController {

    @Autowired
    PermissionService permissionService;

    /**
     * 获取权限列表
     *
     * @param page
     * @param length
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseVO getPermissions(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "length", defaultValue = "10") int length) {
        PageRequest pageRequest = new PageRequest(page-1,length);
        PageData<PermissionDto> permissions = permissionService.findAll(pageRequest);
        return new ResponseVO(permissions);
    }
}

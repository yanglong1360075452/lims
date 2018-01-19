package com.wizinno.lims.project.api.controller;

import com.wizinno.lims.activ.service.ActivService;
import com.wizinno.lims.activ.service.util.SpringContextUtils;
import com.wizinno.lims.common.controller.BaseController;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.project.service.SubTaskService;
import com.wizinno.lims.project.service.dto.SubTaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiuMei
 * @date 2017-12-01.
 */
@RestController
@RequestMapping("/api/task/sub")
public class SubTaskController extends BaseController {

    @Autowired
    private SubTaskService subTaskService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody
    ResponseVO getSubTaskById(@PathVariable("id") long id) {
        return new ResponseVO(subTaskService.getById(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/sample/{id}")
    public @ResponseBody
    ResponseVO getSampleListById(@PathVariable("id") long id, @RequestParam(value = "page", defaultValue = "1") int page,
                                 @RequestParam(value = "length", defaultValue = "10") int length) {
        SubTaskDto subTaskDto = subTaskService.getById(id);
        if (subTaskDto == null) {
            throw new CustomException(CustomExceptionCode.RECORD_NOT_EXIST);
        }
        String javaClass = subTaskDto.getCfgWfActiv().getJavaClass();
        ActivService activService = (ActivService) SpringContextUtils.getBeanByName(javaClass);
        PageRequest request = new PageRequest(page - 1, length);
        return new ResponseVO(activService.getPageShowData(subTaskDto, request));
    }
}

package com.wizinno.lims.workflow.cfg.api;

import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.workflow.cfg.service.ActivCfgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiuMei
 * @date 2017-10-31.
 */
@RestController
@RequestMapping("/api/cfg/activ")
public class ActivController {

    @Autowired
    private ActivCfgService activCfgService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseVO getWorkflowList(@RequestParam(value = "page", defaultValue = "1") int page,
                                      @RequestParam(value = "length", defaultValue = "10") int length) throws CustomException {
        PageRequest pageRequest = new PageRequest(page - 1, length);
        return new ResponseVO(activCfgService.findAll(null, pageRequest));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseVO getById(@PathVariable("id") long id) throws CustomException{
        return new ResponseVO(activCfgService.findById(id));
    };
}

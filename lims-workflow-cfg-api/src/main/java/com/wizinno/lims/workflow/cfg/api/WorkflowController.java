package com.wizinno.lims.workflow.cfg.api;

import com.wizinno.lims.common.controller.BaseController;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.workflow.cfg.service.WorkflowCfgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiuMei on 2017-08-16.
 */
@RestController
@RequestMapping("/api/cfg/workflow")
public class WorkflowController extends BaseController {

    @Autowired
    private WorkflowCfgService workflowCfgService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseVO getWorkflowList(@RequestParam(value = "page", defaultValue = "1") int page,
                                      @RequestParam(value = "length", defaultValue = "10") int length) {
        PageRequest pageRequest = new PageRequest(page - 1, length);
        return new ResponseVO(workflowCfgService.findAll(null, pageRequest));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseVO getById(@PathVariable("id") long id){
        return new ResponseVO(workflowCfgService.getById(id));
    }

    @RequestMapping(value = "/simple",method = RequestMethod.GET)
    public ResponseVO getSimpleWorkflowList(){
        return new ResponseVO(workflowCfgService.findAllSimple());
    }
}

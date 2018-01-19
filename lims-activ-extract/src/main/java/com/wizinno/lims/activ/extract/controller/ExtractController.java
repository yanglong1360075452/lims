package com.wizinno.lims.activ.extract.controller;

import com.wizinno.lims.activ.extract.service.ExtractService;
import com.wizinno.lims.common.controller.BaseController;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author  LiuMei on 2017-12-11.
 */
@RestController
@RequestMapping("/api/extract")
public class ExtractController extends BaseController {

    @Autowired
    private ExtractService extractService;

    /**
     * 根据物种类别和样本类型获取提取方法列表
     * @param species
     * @param sampleType
     * @return
     * @throws CustomException
     */
    @RequestMapping(value = "/method/{species}/{sampleType}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseVO getMethod(@PathVariable("species") long species, @PathVariable("sampleType") long sampleType) throws CustomException {
        List extractMethod = extractService.getExtractMethod(species, sampleType);
        return new ResponseVO(extractMethod);
    }

    /**
     * 根据提取方法获取提取方法SOP
     * @param method
     * @return
     * @throws CustomException
     */
    @RequestMapping(value = "/sop/{method}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseVO getSop(@PathVariable("method") long method) throws CustomException {
        return new ResponseVO(extractService.getSopByMethod(method));
    }

}

package com.wizinno.lims.log.api;

import com.wizinno.lims.common.controller.BaseController;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.log.service.DataDictService;
import com.wizinno.lims.log.service.condition.DataDictCondition;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuMei on 2017-06-19.
 *
 * 数据字典控制类
 */
@RestController
@RequestMapping("/api/data")
public class DataDictController extends BaseController {

    @Autowired
    private DataDictService dataDictService;

    /**
     * 根据条件获取数据字典
     * @param parentId 父ID
     * @param secondParentId 第二父ID
     * @param type 类型
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseVO getDataDict(@RequestParam(value = "parentId", required = false) Long parentId,
                                                @RequestParam(value = "secondParentId", required = false) Long secondParentId,
                                                @RequestParam(value = "type") int type) {
        DataDictCondition condition = new DataDictCondition();
        condition.setParentId(parentId);
        condition.setSecondParentId(secondParentId);
        condition.setType(type);
        return new ResponseVO(dataDictService.getByCondition(condition));
    }

    /**
     * 获取多个类型的数据字典
     * @param types
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/list")
    public @ResponseBody ResponseVO projectGet(@RequestParam(value = "type")String types) {
        if(StringUtils.isBlank(types)){
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        String[] split = types.split(",");
        List<Integer> typeList = new ArrayList<>();
        for(String type : split){
            typeList.add(Integer.parseInt(type));
        }
        return new ResponseVO(dataDictService.getDict(typeList));
    }

    /**
     * 根据ID获取数据字典描述
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseVO getDataDictById(@PathVariable("id") long id) {
        return new ResponseVO(dataDictService.getDescById(id));
    }
}

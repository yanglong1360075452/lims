package com.wizinno.lims.log.service;

import com.wizinno.lims.log.service.condition.DataDictCondition;
import com.wizinno.lims.log.service.dto.DataDictDto;

import java.util.HashMap;
import java.util.List;

/**
 * @author LiuMei on 2017-06-19.
 */
public interface DataDictService {

    /**
     * 根据条件获取数据字典
     * @param condition
     * @return
     */
    List<DataDictDto> getByCondition(DataDictCondition condition);

    /**
     * 根据ID获取描述
     * @param id
     * @return
     */
    String getDescById(long id);

    /**
     * 根据多个类型获取数据字典
     * @param types
     * @return
     */
    HashMap<Integer,List<DataDictDto>> getDict(List<Integer> types);
}

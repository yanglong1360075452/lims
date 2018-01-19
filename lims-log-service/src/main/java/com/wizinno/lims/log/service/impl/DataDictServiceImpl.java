package com.wizinno.lims.log.service.impl;

import com.wizinno.lims.common.query.Criteria;
import com.wizinno.lims.common.query.Restrictions;
import com.wizinno.lims.log.domain.DataDict;
import com.wizinno.lims.log.repository.DataDictRepository;
import com.wizinno.lims.log.service.DataDictService;
import com.wizinno.lims.log.service.condition.DataDictCondition;
import com.wizinno.lims.log.service.data.DataDictTypeEnum;
import com.wizinno.lims.log.service.dto.DataDictDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author LiuMei on 2017-06-19.
 */
@Service
public class DataDictServiceImpl implements DataDictService {

    @Autowired
    private DataDictRepository dataDictRepository;

    @Override
    public List<DataDictDto> getByCondition(DataDictCondition condition) {

        Integer type = condition.getType();
        Long parentId = condition.getParentId();
        Long secondParentId = condition.getSecondParentId();
        Criteria c = new Criteria();
        if (type != null) {
            c.add(Restrictions.eq("type", type, true));
        }
        if (parentId != null) {
            c.add(Restrictions.eq("parentId", parentId, true));
        }
        if (secondParentId != null) {
            c.add(Restrictions.eq("secondParentId", secondParentId, true));
        }
        c.addOrder("code","asc");
        List<DataDict> dataDict = dataDictRepository.findAll(c);
        List<DataDictDto> dataDictDTOs = null;
        if (CollectionUtils.isNotEmpty(dataDict)) {
            dataDictDTOs = new ArrayList<>();
            for (DataDict data : dataDict) {
                dataDictDTOs.add(dataDictToDto(data));
            }
        }
        return dataDictDTOs;
    }

    public DataDictDto dataDictToDto(DataDict dataDict){
        DataDictDto dataDictDto  = null;
        if(dataDict != null){
            dataDictDto = new DataDictDto();
            BeanUtils.copyProperties(dataDict, dataDictDto);
            dataDictDto.setTypeDesc(DataDictTypeEnum.getNameByCode(dataDict.getType()));
        }
        return dataDictDto;
    }

    @Override
    public String getDescById(long id) {
        DataDict dataDict = dataDictRepository.findOne(id);
        return dataDict.getDescription();
    }

    @Override
    public HashMap<Integer, List<DataDictDto>> getDict(List<Integer> types) {
        HashMap<Integer, List<DataDictDto>> data = null;
        if (CollectionUtils.isNotEmpty(types)) {
            Criteria c = new Criteria();
            c.add(Restrictions.in("type", types, true));
            c.addOrder("code","asc");
            List<DataDict> dataDict = dataDictRepository.findAll(c);
            if (CollectionUtils.isNotEmpty(dataDict)) {
                data = new HashMap<>(16);
                for(DataDict dict : dataDict){
                    Integer type = dict.getType();
                    List<DataDictDto> dataDictDTOs = data.get(type);
                    if(dataDictDTOs == null){
                        dataDictDTOs = new ArrayList<>();
                    }
                    dataDictDTOs.add(dataDictToDto(dict));
                    data.put(type,dataDictDTOs);
                }
            }
        }
        return data;
    }
}

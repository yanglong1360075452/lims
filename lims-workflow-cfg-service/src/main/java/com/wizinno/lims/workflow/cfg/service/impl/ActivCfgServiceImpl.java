package com.wizinno.lims.workflow.cfg.service.impl;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.workflow.cfg.domain.CfgWfActiv;
import com.wizinno.lims.workflow.cfg.repository.CfgWfActivRepository;
import com.wizinno.lims.workflow.cfg.service.ActivCfgService;
import com.wizinno.lims.workflow.cfg.service.condition.ActivCondition;
import com.wizinno.lims.workflow.cfg.service.data.ActivCategoryEnum;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfActivDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuMei
 * @date 2017-10-25.
 */
@Service
public class ActivCfgServiceImpl<T> implements ActivCfgService <T> {

    @Autowired
    private CfgWfActivRepository cfgWfActivRepository;

    @Override
    public PageData<CfgWfActivDto> findAll(ActivCondition condition, Pageable pageable) throws CustomException {
        Page<CfgWfActiv> all = cfgWfActivRepository.findAll(pageable);
        List<CfgWfActiv> content = all.getContent();
        List<CfgWfActivDto> cfgWfActivDtoList = wfCfgActivsToDto((List<T>) content);
        return new PageData<>(all.getNumber(), all.getSize(), cfgWfActivDtoList, all.getTotalPages(), all.getTotalElements());
    }

    @Override
    public CfgWfActivDto findById(long id) {
        return wfCfgActivToDto((T) cfgWfActivRepository.findOne(id));
    }

    @Override
    public CfgWfActivDto wfCfgActivToDto(T object) {
        CfgWfActivDto cfgWfActivDto = null;
        if (object != null) {
            CfgWfActiv cfgWfActiv = (CfgWfActiv) object;
            cfgWfActivDto = new CfgWfActivDto();
            BeanUtils.copyProperties(cfgWfActiv, cfgWfActivDto);
            cfgWfActivDto.setCategoryDesc(ActivCategoryEnum.getNameByCode(cfgWfActiv.getCategory()));
        }
        return cfgWfActivDto;
    }

    @Override
    public T wfCfgActivDtoToPo(CfgWfActivDto dto) {
        CfgWfActiv cfgWfActiv = null;
        if(dto != null){
            cfgWfActiv = new CfgWfActiv();
            BeanUtils.copyProperties(dto, cfgWfActiv);
        }
        return (T) cfgWfActiv;
    }

    @Override
    public List<CfgWfActivDto> wfCfgActivsToDto(List<T> wfCfgActivs) {
        List<CfgWfActivDto> cfgWfActivDtoList = null;
        if (CollectionUtils.isNotEmpty(wfCfgActivs)) {
            cfgWfActivDtoList = new ArrayList<>();
            for (T object : wfCfgActivs) {
                cfgWfActivDtoList.add(wfCfgActivToDto(object));
            }
        }
        return cfgWfActivDtoList;
    }

    @Override
    public List<T> wfCfgActivDtoToPos(List<CfgWfActivDto> cfgWfActivDtoList) {
        List<CfgWfActiv> data = null;
        if(CollectionUtils.isNotEmpty(cfgWfActivDtoList)){
            data = new ArrayList<>();
            for(CfgWfActivDto dto : cfgWfActivDtoList){
                data.add((CfgWfActiv) wfCfgActivDtoToPo(dto));
            }
        }
        return (List<T>) data;
    }
}

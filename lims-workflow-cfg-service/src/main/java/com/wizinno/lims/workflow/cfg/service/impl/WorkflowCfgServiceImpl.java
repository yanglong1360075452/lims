package com.wizinno.lims.workflow.cfg.service.impl;

import com.wizinno.lims.common.data.JobContentEnum;
import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.workflow.cfg.domain.CfgWf;
import com.wizinno.lims.workflow.cfg.repository.CfgWfRepository;
import com.wizinno.lims.workflow.cfg.service.ActivCfgService;
import com.wizinno.lims.workflow.cfg.service.WorkflowCfgService;
import com.wizinno.lims.workflow.cfg.service.WorkflowTransService;
import com.wizinno.lims.workflow.cfg.service.condition.WorkflowCondition;
import com.wizinno.lims.workflow.cfg.service.data.WorkflowApplicationEnum;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfDto;
import com.wizinno.lims.workflow.cfg.service.dto.WfSimpleDto;
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
public class WorkflowCfgServiceImpl<T> implements WorkflowCfgService<T> {

    @Autowired
    private CfgWfRepository cfgWfRepository;

    @Autowired
    private ActivCfgService activCfgService;

    @Autowired
    private WorkflowTransService workflowTransService;

    @Override
    public PageData<CfgWfDto> findAll(WorkflowCondition condition, Pageable pageable) throws CustomException {
        Page<CfgWf> all = cfgWfRepository.findAll(pageable);
        List<CfgWf> content = all.getContent();
        return new PageData<>(all.getNumber(), all.getSize(), wfCfgListToDtoList(content), all.getTotalPages(), all.getTotalElements());
    }

    @Override
    public List<WfSimpleDto> findAllSimple() throws CustomException {
        return wfSimpleListTrans(cfgWfRepository.findAll());
    }

    @Override
    public CfgWfDto getById(long id) {
        return wfCfgWfPoToDto((T) cfgWfRepository.findOne(id));
    }

    @Override
    public T wfCfgWfDtoToPo(CfgWfDto dto) {
        CfgWf cfgWf = null;
        if(dto != null){
            cfgWf = new CfgWf();
            BeanUtils.copyProperties(dto, cfgWf);
            cfgWf.setCfgWfActivList(activCfgService.wfCfgActivDtoToPos(cfgWf.getCfgWfActivList()));
        }
        return (T) cfgWf;
    }

    @Override
    public CfgWfDto wfCfgWfPoToDto(T po) {
        CfgWfDto cfgWfDto = null;
        if (po != null) {
            CfgWf cfgWf = (CfgWf) po;
            cfgWfDto = new CfgWfDto();
            BeanUtils.copyProperties(cfgWf, cfgWfDto);
            cfgWfDto.setCategoryDesc(JobContentEnum.getNameByCode(cfgWf.getCategory()));
            cfgWfDto.setApplicationDesc(WorkflowApplicationEnum.getNameByCode(cfgWf.getApplication()));
            cfgWfDto.setCfgWfActivList(activCfgService.wfCfgActivsToDto(cfgWfDto.getCfgWfActivList()));
            cfgWfDto.setCfgWfTransList(workflowTransService.getListByWfId(cfgWf.getId()));
        }
        return cfgWfDto;
    }

    private List<CfgWfDto> wfCfgListToDtoList(List<CfgWf> cfgWfs) {
        List<CfgWfDto> cfgWfDtoList = null;
        if (CollectionUtils.isNotEmpty(cfgWfs)) {
            cfgWfDtoList = new ArrayList<>();
            for (CfgWf cfgWf : cfgWfs) {
                cfgWfDtoList.add(wfCfgWfPoToDto((T) cfgWf));
            }
        }
        return cfgWfDtoList;
    }

    private List<WfSimpleDto> wfSimpleListTrans(List<CfgWf> cfgWfs){
        List<WfSimpleDto> data = null;
        if(CollectionUtils.isNotEmpty(cfgWfs)){
            data = new ArrayList<>();
            for(CfgWf cfgWf : cfgWfs){
                data.add(wfSimpleTrans(cfgWf));
            }
        }
        return data;
    }

    private WfSimpleDto wfSimpleTrans(CfgWf cfgWf){
        WfSimpleDto simpleDto = null;
        if(cfgWf != null){
            simpleDto = new WfSimpleDto();
            simpleDto.setId(cfgWf.getId());
            simpleDto.setName(cfgWf.getName());
        }
        return simpleDto;
    }
}

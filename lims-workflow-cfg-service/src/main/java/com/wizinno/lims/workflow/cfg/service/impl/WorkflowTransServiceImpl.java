package com.wizinno.lims.workflow.cfg.service.impl;

import com.wizinno.lims.workflow.cfg.domain.CfgWfTrans;
import com.wizinno.lims.workflow.cfg.repository.CfgWfTransRepository;
import com.wizinno.lims.workflow.cfg.service.ActivCfgService;
import com.wizinno.lims.workflow.cfg.service.WorkflowTransService;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfTransDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuMei
 * @date 2017-11-02.
 */
@Service
public class WorkflowTransServiceImpl implements WorkflowTransService {

    @Autowired
    private CfgWfTransRepository cfgWfTransRepository;

    @Autowired
    private ActivCfgService activCfgService;

    @Override
    public List<CfgWfTransDto> getListByWfId(long workflowId) {
        List<CfgWfTrans> cfgWfTrans = cfgWfTransRepository.findByCfgWfId(workflowId);
        return wfCfgWfTransListToDto(cfgWfTrans);
    }

    @Override
    public CfgWfTransDto getTransByFromActiv(long workflowId, Long fromActivId) {
        CfgWfTrans cfgWfTrans = cfgWfTransRepository.findByCfgWfIdAndFromActivId(workflowId, fromActivId);
        return wfCfgWfTransToDto(cfgWfTrans);
    }

    private CfgWfTransDto wfCfgWfTransToDto(CfgWfTrans cfgWfTrans){
        CfgWfTransDto cfgWfTransDto = null;
        if(cfgWfTrans != null){
            cfgWfTransDto = new CfgWfTransDto();
            BeanUtils.copyProperties(cfgWfTrans, cfgWfTransDto);
            cfgWfTransDto.setFromActiv(activCfgService.wfCfgActivToDto(cfgWfTrans.getFromActiv()));
            cfgWfTransDto.setToActiv(activCfgService.wfCfgActivToDto(cfgWfTrans.getToActiv()));
        }
        return cfgWfTransDto;
    }

    private List<CfgWfTransDto> wfCfgWfTransListToDto(List<CfgWfTrans> cfgWfTrans){
        List<CfgWfTransDto> cfgWfTransDtoList = null;
        if(CollectionUtils.isNotEmpty(cfgWfTrans)){
            cfgWfTransDtoList = new ArrayList<>();
            for(CfgWfTrans item : cfgWfTrans){
                cfgWfTransDtoList.add(wfCfgWfTransToDto(item));
            }
        }
        return cfgWfTransDtoList;
    }
}

package com.wizinno.lims.workflow.cfg.service;

import com.wizinno.lims.workflow.cfg.service.dto.CfgWfTransDto;

import java.util.List;

/**
 * @author LiuMei
 * @date 2017-11-02.
 */
public interface WorkflowTransService {

    /**
     * 根据workflowID获取工作流走向列表
     *
     * @param workflowId
     * @return
     */
    List<CfgWfTransDto> getListByWfId(long workflowId);

    /**
     * 根据FromActivId查询下一ActivId
     *
     * @param workflowId
     * @param fromActivId
     * @return
     */
    CfgWfTransDto getTransByFromActiv(long workflowId, Long fromActivId);
}

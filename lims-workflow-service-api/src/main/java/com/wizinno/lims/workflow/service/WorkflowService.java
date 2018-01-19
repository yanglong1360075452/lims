package com.wizinno.lims.workflow.service;

import com.wizinno.lims.workflow.service.dto.ParamDto;

/**
 * @author LiuMei
 * @date 2017-11-03.
 */
public interface WorkflowService {

    void activStart();

    /**
     * 工作流活动向工作流获取某个样本某个参数值
     * @param paramDto
     * @return
     */
    String getParamValue(ParamDto paramDto);

    //todo
    void activEnd();

}

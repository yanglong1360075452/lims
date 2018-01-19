package com.wizinno.lims.workflow.cfg.service;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.workflow.cfg.service.condition.WorkflowCondition;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfDto;
import com.wizinno.lims.workflow.cfg.service.dto.WfSimpleDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author LiuMei on 2017-08-16.
 */
public interface WorkflowCfgService<T> {

    /**
     * 分页查询工作流信息
     * @param condition
     * @param pageable
     * @return
     * @throws CustomException
     */
    PageData<CfgWfDto> findAll(WorkflowCondition condition, Pageable pageable) throws CustomException;

    /**
     * 查询所有工作流简单信息
     * @return
     * @throws CustomException
     */
    List<WfSimpleDto> findAllSimple() throws CustomException;

    /**
     * 根据ID查询工作流信息
     * @param id
     * @return
     */
    CfgWfDto getById(long id);

    /**
     * 数据转换
     * @param dto
     * @return
     */
    T wfCfgWfDtoToPo(CfgWfDto dto);

    /**
     * 数据转换
     * @param po
     * @return
     */
    CfgWfDto wfCfgWfPoToDto(T po);

}

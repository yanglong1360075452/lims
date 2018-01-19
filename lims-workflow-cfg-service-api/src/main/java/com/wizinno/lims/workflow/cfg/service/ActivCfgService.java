package com.wizinno.lims.workflow.cfg.service;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.workflow.cfg.service.condition.ActivCondition;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfActivDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author LiuMei on 2017-08-16.
 */
public interface ActivCfgService<T> {

    /**
     * 分页查询工作流节点信息
     * @param condition
     * @param pageable
     * @return
     * @throws CustomException
     */
    PageData<CfgWfActivDto> findAll(ActivCondition condition, Pageable pageable) throws CustomException;

    /**
     * 根据ID查询信息
     * @param id
     * @return
     */
    CfgWfActivDto findById(long id);

    /**
     * 数据转换
     * @param object
     * @return
     */
    CfgWfActivDto wfCfgActivToDto(T object);

    /**
     * 数据转换
     * @param dto
     * @return
     */
    T wfCfgActivDtoToPo(CfgWfActivDto dto);

    /**
     * 集合转换
     * @param wfCfgActivs
     * @return
     */
    List<CfgWfActivDto> wfCfgActivsToDto(List<T> wfCfgActivs);

    /**
     * 集合转换
     * @param cfgWfActivDtoList
     * @return
     */
    List<T> wfCfgActivDtoToPos(List<CfgWfActivDto> cfgWfActivDtoList);
}

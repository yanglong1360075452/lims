package com.wizinno.lims.project.service;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.project.service.condition.ProjectCondition;
import com.wizinno.lims.project.service.dto.ProjectSampleLotDto;
import com.wizinno.lims.project.service.dto.SampleLotDto;
import org.springframework.data.domain.Pageable;

/**
 * @author LiuMei on 2017-06-22.
 */
public interface SampleLotService<T> {

    /**
     * 添加/修改
     * 样本批次信息
     * @param sampleLotDto
     * @return
     * @throws CustomException
     */
    Long addOrUpdateSampleLot(SampleLotDto sampleLotDto) throws CustomException;

    /**
     * 修改样本批次附件信息
     * @param sampleLotId
     * @param affix
     */
    void updateSampleLotAffix(long sampleLotId,String affix);

    /**
     * 根据样本批次id查询样本批次信息
     * @param id
     * @return
     */
    SampleLotDto getById(long id);

    /**
     * 根据样本来源查询样本批次信息
     * @param sampleSource
     * @return
     */
    SampleLotDto getBySampleSource(long sampleSource);

    /**
     * 样本批次数据转换
     * PO转DTO
     * @param sampleLot
     * @return
     */
    SampleLotDto sampleLotToDto(T sampleLot);

    /**
     * 根据条件查询批次信息
     * @param condition
     * @param pageable
     * @return
     * @throws CustomException
     */
    PageData<ProjectSampleLotDto> getProjectSampleLotByCondition(ProjectCondition condition, Pageable pageable) throws CustomException;

    /**
     * 数据结构转换
     * DTO转PO
     * @param sampleLotDto
     * @return
     */
    Object sampleLotDtoToPO(SampleLotDto sampleLotDto);
}

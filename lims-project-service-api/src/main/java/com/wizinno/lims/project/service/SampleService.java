package com.wizinno.lims.project.service;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.project.service.condition.ActivSampleCondition;
import com.wizinno.lims.project.service.condition.SampleCondition;
import com.wizinno.lims.project.service.dto.SampleDto;
import com.wizinno.lims.project.service.dto.SampleLotDto;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author LiuMei on 2017-06-22.
 */
public interface SampleService<T> {

    /**
     * 批量操作样本
     * 添加/编辑
     * @param sampleLotDto
     * @throws CustomException
     */
    void operateSample(SampleLotDto sampleLotDto) throws CustomException;

    /**
     * 批量操作样本
     * @param sampleDtoList
     */
    void batchOperateSample(List<SampleDto> sampleDtoList);

    /**
     * 查询样本信息
     * @param id
     * @return
     * @throws CustomException
     */
    SampleDto getSampleById(long id) throws CustomException;

    /**
     * 根据SampleLotID和父样本ID查询样本
     * @param sampleLotId
     * @param parentId
     * @return
     */
    SampleDto getSampleBySampleLotIdAndParentId(long sampleLotId,long parentId);

    /**
     * 样本接收删除样本
     * @param id
     * @throws CustomException
     */
    void receiveDeleteSample(List<Long> id) throws CustomException;

    /**
     * 删除样本
     * @param id
     * @throws CustomException
     */
    void deleteSample(List<Long> id) throws CustomException;

    /**
     * 根据条件查询样本列表
     * @param condition
     * @param pageRequest
     * @return
     */
    PageData<SampleDto> getSamplesByCondition(SampleCondition condition, PageRequest pageRequest);

    /**
     * 根据条件查询样本列表
     * @param condition
     * @return
     */
    List<SampleDto> getSamplesByCondition(SampleCondition condition);

    /**
     * 根据样本批次Id获取最大样本序号
     * @param sampleLotId
     * @return
     */
    String getMaxNoBySampleLotId(long sampleLotId);

    /**
     * 接收样本
     * @param sampleLotId
     * @param ids
     * @throws CustomException
     */
    void receiveSamples(long sampleLotId,List<Long> ids) throws CustomException;

    /**
     * 拒收样本
     * @param sampleLotId
     * @param ids
     * @throws CustomException
     */
    void rejectSamples(long sampleLotId,List<Long> ids) throws CustomException;

    /**
     * 根据样本批次ID和样本状态查询样本列表
     * @param sampleLotId
     * @param sampleStatus
     * @return
     * @throws CustomException
     */
    List<SampleDto> getBySampleLotIdAndSampleStatus(long sampleLotId,int sampleStatus) throws CustomException;

    /**
     * 数据结构转换
     * DTO转PO
     * @param sampleDto
     * @return
     */
    T sampleDtoToPO(SampleDto sampleDto);

    /**
     * 数据转换
     * @param data
     * @return
     */
    SampleDto sampleToDto(T data);

    /**
     * 根据executionId查询此次执行使用的样本
     * @param executionId
     * @return
     */
    List<SampleDto> getUseSampleByExecutionId(long executionId);

    /**
     * 节点获取可执行列表
     * @param condition
     * @return
     */
    List<SampleDto> activGetSample(ActivSampleCondition condition);
}

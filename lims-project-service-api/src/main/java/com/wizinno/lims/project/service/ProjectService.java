package com.wizinno.lims.project.service;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.project.service.condition.ProjectCondition;
import com.wizinno.lims.project.service.dto.ProjectDto;
import com.wizinno.lims.project.service.dto.ProjectSimpleDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author LiuMei on 2017-06-14.
 */
public interface ProjectService {


    /**
     * 新建/编辑项目
     * @param projectDto
     * @return
     * @throws CustomException
     */
    ProjectDto addOrUpdate(ProjectDto projectDto) throws CustomException;

    /**
     * 修改项目状态
     * @param projectId
     * @param status
     * @throws CustomException
     */
    void updateProjectStatus(long projectId,int status) throws CustomException;

    /**
     * 根据ID获取项目信息
     * @param id
     * @return
     * @throws CustomException
     */
    ProjectDto getProjectById(long id) throws CustomException;

    /**
     * 根据项目编号获取项目信息
     * @param no
     * @return
     * @throws CustomException
     */
    ProjectDto getProjectByNo(String no) throws CustomException;

    /**
     * 根据样本批次ID获取项目信息
     * @param sampleLotId
     * @return
     * @throws CustomException
     */
    ProjectDto getProjectBySampleLotId(long sampleLotId) throws CustomException;


    /**
     * 根据条件分页查询项目信息
     * @param condition
     * @param pageable
     * @return
     * @throws CustomException
     */
    PageData<ProjectSimpleDto> getProjectByCondition(ProjectCondition condition, Pageable pageable) throws CustomException;

    /**
     * 根据项目ID查询样本数目
     * @param projectId
     * @return
     */
    long countSampleByProjectId(long projectId);

    /**
     * 项目交付生产
     * @param projectIds
     * @throws CustomException
     */
    void deliveryProduct(List<Long> projectIds) throws CustomException;

    /**
     * 取消生产
     * @param projectId
     */
    void cancelProduce(long projectId);

    /**
     * 取消项目
     * @param projectId
     */
    void cancel(long projectId);

    /**
     * 恢复项目
     * @param projectId
     * @param status
     */
    void recover(long projectId,int status);

    /**
     * 详细转换
     * @param project
     * @return
     */
    ProjectDto projectToDto(Object project);

    /**
     * 数据结构转换
     * 只转换项目数据库存储字段,不转换其他表关联信息
     * @param project
     * @return
     */
    ProjectDto projectSimpleToDto(Object project);

    /**
     * 数据结构转换
     * 只把项目的样本批次信息一起转换,其他关联信息不做转换
     * @param projectDto
     * @return
     */
    Object projectDtoSimpleToPO(ProjectDto projectDto);

    /**
     * 判断项目是否已交付生产
     * @param projectId
     * @return
     */
    Boolean hadDelivered(long projectId);
}

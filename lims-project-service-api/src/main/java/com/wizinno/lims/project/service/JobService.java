package com.wizinno.lims.project.service;

import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.project.service.dto.JobDto;
import com.wizinno.lims.project.service.dto.ProjectDto;

import java.util.Set;

/**
 * @author LiuMei on 2017-07-24.
 */
public interface JobService<T> {

    /**
     * 根据项目信息查询工作内容
     * @param projectDto
     * @return
     * @throws CustomException
     */
    Set<JobDto> findByProject(ProjectDto projectDto) throws CustomException;

    /**
     * 根据工作内容ID查询工作内容信息
     * @param id
     * @return
     * @throws CustomException
     */
    JobDto getById(long id) throws CustomException;

    /**
     * 数据类型转换
     * DTO转PO
     * @param jobDto
     * @return
     */
    T jobDtoToPO(JobDto jobDto);

    /**
     * 数据类型转换
     * PO转DTO
     * @param o
     * @return
     */
    JobDto jobToDto(T o);
}

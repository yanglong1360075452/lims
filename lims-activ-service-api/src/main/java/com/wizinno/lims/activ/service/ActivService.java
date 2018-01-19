package com.wizinno.lims.activ.service;

import com.wizinno.lims.activ.service.dto.EndInputDto;
import com.wizinno.lims.activ.service.dto.StartInputDto;
import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.project.service.dto.ExecutionDto;
import com.wizinno.lims.project.service.dto.SubTaskDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author LiuMei
 * @date 2017-11-03.
 */
public interface ActivService<T> {

    /**
     * 任务开始执行
     * @param data
     * @return
     * @throws CustomException
     */
    ExecutionDto start(StartInputDto data) throws CustomException;

    /**
     * 任务结束执行
     * @param data
     * @return
     * @throws CustomException
     */
    T end(EndInputDto data) throws CustomException;

    /**
     * 获取当前subTask可执行的样本列表
     * @param subTaskDto
     * @return
     * @throws CustomException
     */
    List<T> getExecutionSample(SubTaskDto subTaskDto) throws CustomException;

    /**
     * 每个subTask获取页面展示数据
     * @param subTaskDto
     * @param pageable
     * @return
     * @throws CustomException
     */
    PageData<T> getPageShowData(SubTaskDto subTaskDto, Pageable pageable) throws CustomException;
}

package com.wizinno.lims.activ.attenuation.service.impl;

import com.wizinno.lims.activ.attenuation.service.AttenuationService;
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
 * @date 2018-01-16.
 */
public class AttenuationServiceImpl implements AttenuationService {
    @Override
    public ExecutionDto start(StartInputDto data) throws CustomException {
        return null;
    }

    @Override
    public Object end(EndInputDto data) throws CustomException {
        return null;
    }

    @Override
    public List getExecutionSample(SubTaskDto subTaskDto) throws CustomException {
        return null;
    }

    @Override
    public PageData getPageShowData(SubTaskDto subTaskDto, Pageable pageable) throws CustomException {
        return null;
    }
}

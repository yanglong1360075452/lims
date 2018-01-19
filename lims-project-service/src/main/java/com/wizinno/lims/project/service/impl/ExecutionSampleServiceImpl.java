package com.wizinno.lims.project.service.impl;

import com.wizinno.lims.common.util.ListUtil;
import com.wizinno.lims.project.domain.*;
import com.wizinno.lims.project.repository.ExecutionSampleRepository;
import com.wizinno.lims.project.service.*;
import com.wizinno.lims.project.service.dto.ExecutionSampleDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuMei
 * @date 2017-11-17.
 */
@Service
public class ExecutionSampleServiceImpl implements ExecutionSampleService {

    @Autowired
    private ExecutionSampleRepository executionSampleRepository;

    @Autowired
    private SampleService sampleService;

    @Autowired
    private ExecutionService executionService;

    @Autowired
    private SubTaskService subTaskService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addList(List<ExecutionSampleDto> executionSampleDtoList) {
        if (CollectionUtils.isNotEmpty(executionSampleDtoList)) {
            List<ExecutionSampleR> executionSampleRList = new ArrayList<>();
            ExecutionSampleR executionSampleR;
            for (ExecutionSampleDto executionSampleDto : executionSampleDtoList) {
                executionSampleR = new ExecutionSampleR();
                BeanUtils.copyProperties(executionSampleDto, executionSampleR);
                executionSampleR.setExecution((Execution) executionService.executionDtoToPo(executionSampleDto.getExecution()));
                executionSampleR.setSample((Sample) sampleService.sampleDtoToPO(executionSampleDto.getSample()));
                executionSampleR.setSubTask((SubTask) subTaskService.subTaskDtoToPo(executionSampleDto.getSubTask()));
                executionSampleRList.add(executionSampleR);
            }
            if (CollectionUtils.isNotEmpty(executionSampleRList)) {
                executionSampleRepository.save(executionSampleRList);
            }
        }
    }


    @Override
    public List<Long> getSampleBySubTaskId(long subTaskId) {
        List<BigInteger> ids = executionSampleRepository.getSampleBySubTaskId(subTaskId);
        return ListUtil.bigIntegerToLong(ids);
    }

    @Override
    public Long getLastExecutionIdBySampleIdAndSubTaskId(long sampleId, long subTaskId) {
        return executionSampleRepository.getLastExecutionIdBySampleIdAndSubTaskId(sampleId,subTaskId);
    }
}

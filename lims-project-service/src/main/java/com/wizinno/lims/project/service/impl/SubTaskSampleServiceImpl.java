package com.wizinno.lims.project.service.impl;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.query.Criteria;
import com.wizinno.lims.common.query.Restrictions;
import com.wizinno.lims.common.util.ListUtil;
import com.wizinno.lims.project.domain.*;
import com.wizinno.lims.project.repository.SubTaskSampleRepository;
import com.wizinno.lims.project.service.JobService;
import com.wizinno.lims.project.service.SampleService;
import com.wizinno.lims.project.service.SubTaskSampleService;
import com.wizinno.lims.project.service.SubTaskService;
import com.wizinno.lims.project.service.dto.SampleDto;
import com.wizinno.lims.project.service.dto.SubTaskSampleDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuMei
 * @date 2017-11-17.
 */
@Service
public class SubTaskSampleServiceImpl<T> implements SubTaskSampleService<T> {

    @Autowired
    private SubTaskService subTaskService;

    @Autowired
    private SampleService sampleService;

    @Autowired
    private JobService jobService;

    @Autowired
    private SubTaskSampleRepository subTaskSampleRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(List<SubTaskSampleDto> subTaskSampleDtoList) {
        if (CollectionUtils.isNotEmpty(subTaskSampleDtoList)) {
            List<SubTaskSampleR> list = (List<SubTaskSampleR>) subTaskSampleDtoToPo(subTaskSampleDtoList);
            subTaskSampleRepository.save(list);
        }
    }

    @Override
    public PageData<SampleDto> getSampleIdBySubTaskId(long subTaskId, Pageable pageable) {
        Criteria c = new Criteria();
        c.add(Restrictions.eq("subTask",subTaskId,true));
        Page page = subTaskSampleRepository.findAll(c, pageable);
        long totalElements = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<SubTaskSampleR> content = page.getContent();
        List<SampleDto> sampleList = null;
        if(CollectionUtils.isNotEmpty(content)){
            sampleList = new ArrayList<>();
            for(SubTaskSampleR subTaskSampleR : content){
                sampleList.add(sampleService.sampleToDto(subTaskSampleR.getSample()));
            }
        }
        return new PageData(pageable.getPageNumber(), pageable.getPageSize(), sampleList, totalPages, totalElements);
    }

    @Override
    public List<Long> getSampleIdBySubTaskId(long subTaskId) {
        return ListUtil.bigIntegerToLong(subTaskSampleRepository.getSampleIdsBySubTaskId(subTaskId));
    }

    @Override
    public T subTaskSampleDtoToPo(SubTaskSampleDto subTaskSampleDto) {
        SubTaskSampleR subTaskSampleR = null;
        if (subTaskSampleDto != null) {
            subTaskSampleR = new SubTaskSampleR();
            BeanUtils.copyProperties(subTaskSampleDto, subTaskSampleR);
            subTaskSampleR.setSubTask((SubTask) subTaskService.subTaskDtoToPo(subTaskSampleDto.getSubTask()));
            subTaskSampleR.setSample((Sample) sampleService.sampleDtoToPO(subTaskSampleDto.getSample()));
            subTaskSampleR.setJob((Job) jobService.jobDtoToPO(subTaskSampleDto.getJob()));
        }
        return (T) subTaskSampleR;
    }

    @Override
    public List<T> subTaskSampleDtoToPo(List<SubTaskSampleDto> list) {
        List<SubTaskSampleR> subTaskSampleRList = null;
        if (CollectionUtils.isNotEmpty(list)) {
            subTaskSampleRList = new ArrayList<>();
            for (SubTaskSampleDto subTaskSampleDto : list) {
                subTaskSampleRList.add((SubTaskSampleR) subTaskSampleDtoToPo(subTaskSampleDto));
            }
        }
        return (List<T>) subTaskSampleRList;
    }
}

package com.wizinno.lims.tracking.service.impl;

import com.wizinno.lims.project.domain.Project;
import com.wizinno.lims.project.domain.Sample;
import com.wizinno.lims.project.domain.SampleLot;
import com.wizinno.lims.project.service.ProjectService;
import com.wizinno.lims.project.service.SampleLotService;
import com.wizinno.lims.project.service.SampleService;
import com.wizinno.lims.project.domain.Task;
import com.wizinno.lims.project.service.TaskService;
import com.wizinno.lims.tracking.domain.Tracking;
import com.wizinno.lims.tracking.repository.TrackingRepository;
import com.wizinno.lims.tracking.service.TrackingService;
import com.wizinno.lims.tracking.service.dto.TrackingDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiuMei on 2017-08-10.
 */
@Service
public class TrackingServiceImpl implements TrackingService {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SampleLotService sampleLotService;

    @Autowired
    private SampleService sampleService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TrackingRepository trackingRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addTracking(TrackingDto trackingDto) {
        trackingRepository.save(trackingDtoToPO(trackingDto));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addBatchTracking(List<TrackingDto> trackingDtoList) {
        trackingRepository.save(trackingDTOsToPO(trackingDtoList));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBySampleId(long sampleId) {
        trackingRepository.deleteBySampleId(sampleId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByTaskId(long taskId) {
        trackingRepository.deleteByTaskId(taskId);
    }

    public Tracking trackingDtoToPO(TrackingDto trackingDto){
        Tracking tracking = null;
        if(trackingDto != null){
            tracking = new Tracking();
            BeanUtils.copyProperties(trackingDto,tracking);
            tracking.setProject((Project) projectService.projectDtoSimpleToPO(trackingDto.getProject()));
            tracking.setSampleLot((SampleLot) sampleLotService.sampleLotDtoToPO(trackingDto.getSampleLot()));
            tracking.setSample((Sample) sampleService.sampleDtoToPO(trackingDto.getSample()));
            tracking.setTask((Task) taskService.taskDtoToPO(trackingDto.getTask()));
        }
        return tracking;
    }

    public List<Tracking> trackingDTOsToPO(List<TrackingDto> trackingDtoList){
        List<Tracking> trackingList = null;
        if(trackingDtoList != null && trackingDtoList.size() > 0){
            trackingList = new ArrayList<>();
            for(TrackingDto trackingDto : trackingDtoList){
                trackingList.add(trackingDtoToPO(trackingDto));
            }
        }
        return trackingList;
    }
}

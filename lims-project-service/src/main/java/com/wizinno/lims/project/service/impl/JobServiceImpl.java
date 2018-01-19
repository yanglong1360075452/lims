package com.wizinno.lims.project.service.impl;

import com.google.gson.Gson;
import com.wizinno.lims.common.data.JobContentEnum;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.log.service.DataDictService;
import com.wizinno.lims.project.domain.Job;
import com.wizinno.lims.project.domain.Project;
import com.wizinno.lims.project.repository.JobRepository;
import com.wizinno.lims.project.service.JobService;
import com.wizinno.lims.project.service.ProjectService;
import com.wizinno.lims.project.service.dto.JobDto;
import com.wizinno.lims.project.service.dto.ProjectDto;
import com.wizinno.lims.project.service.dto.job.content.*;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LiuMei on 2017-07-24.
 */
@Service
public class JobServiceImpl<T> implements JobService<T> {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DataDictService dataDictService;

    private Gson gson = new Gson();

    @Override
    public Set<JobDto> findByProject(ProjectDto projectDto) throws CustomException {
        Set<JobDto> jobDTOs = null;
        if (projectDto != null) {
            Project project = new Project();
            BeanUtils.copyProperties(projectDto, project);
            Set<Job> jobs = jobRepository.findByProject(project);
            jobDTOs = jobsToDto(jobs);
        }
        return jobDTOs;
    }

    @Override
    public JobDto getById(long id) throws CustomException {
        Job job = jobRepository.findOne(id);
        return jobToDto((T) job);
    }

    private Set<JobDto> jobsToDto(Set<Job> jobs) {
        Set<JobDto> jobDTOs = null;
        if (CollectionUtils.isNotEmpty(jobs)) {
            jobDTOs = new HashSet<>();
            for (Job job : jobs) {
                jobDTOs.add(jobToDto((T) job));
            }
        }
        return jobDTOs;
    }

    @Override
    public T jobDtoToPO(JobDto jobDto) {
        Job job = null;
        if (jobDto != null) {
            job = new Job();
            BeanUtils.copyProperties(jobDto, job);
            Object params = jobDto.getParams();
            job.setParams(gson.toJson(params));
            ProjectDto projectDto = jobDto.getProject();
            job.setProject((Project) projectService.projectDtoSimpleToPO(projectDto));
        }
        return (T) job;
    }

    @Override
    public JobDto jobToDto(T o) {
        JobDto jobDto = null;
        if (o != null) {
            Job job = (Job) o;
            jobDto = new JobDto();
            BeanUtils.copyProperties(job, jobDto);
            Project project = job.getProject();
            jobDto.setProject(projectService.projectSimpleToDto(project));
            int type = job.getType();
            jobDto.setTypeDesc(JobContentEnum.getNameByCode(type));
            if (JobContentEnum.SAMPLE_EXTRACT.toCode().equals(type)) {
                SampleExtractDto sampleExtractDto = gson.fromJson(job.getParams(), SampleExtractDto.class);
                sampleExtractDto.setSampleCategoryDesc(dataDictService.getDescById(sampleExtractDto.getSampleCategory()));
                sampleExtractDto.setSampleTypeDesc(dataDictService.getDescById(sampleExtractDto.getSampleType()));
                jobDto.setParams(sampleExtractDto);
            } else if (JobContentEnum.SAMPLE_CHECK.toCode().equals(type)) {
                SampleCheckDto sampleCheckDto = gson.fromJson(job.getParams(), SampleCheckDto.class);
                jobDto.setParams(sampleCheckDto);
            } else if (JobContentEnum.LIBRARY_BUILD.toCode().equals(type)) {
                LibraryBuildDto libraryBuildDto = gson.fromJson(job.getParams(), LibraryBuildDto.class);
                jobDto.setParams(libraryBuildDto);
            } else if (JobContentEnum.LIBRARY_CHECK.toCode().equals(type)) {
                LibraryCheckDto libraryCheckDto = gson.fromJson(job.getParams(), LibraryCheckDto.class);
                jobDto.setParams(libraryCheckDto);
            } else if (JobContentEnum.LIBRARY_RATION.toCode().equals(type)) {
                LibraryRationDto libraryRationDto = gson.fromJson(job.getParams(), LibraryRationDto.class);
                jobDto.setParams(libraryRationDto);
            } else if (JobContentEnum.SEQUENCING.toCode().equals(type)) {
                SequencingDto sequencingDto = gson.fromJson(job.getParams(), SequencingDto.class);
                jobDto.setParams(sequencingDto);
            } else if (JobContentEnum.SEQUENCING_QC.toCode().equals(type)) {
                SequencingQcDto sequencingQcDto = gson.fromJson(job.getParams(), SequencingQcDto.class);
                jobDto.setParams(sequencingQcDto);
            } else if (JobContentEnum.LETTER_ANALYSIS.toCode().equals(type)) {
                LetterAnalysisDto letterAnalysisDto = gson.fromJson(job.getParams(), LetterAnalysisDto.class);
                jobDto.setParams(letterAnalysisDto);
            } else if (JobContentEnum.OTHER.toCode().equals(type)) {
                OtherDto otherDto = gson.fromJson(job.getParams(), OtherDto.class);
                jobDto.setParams(otherDto);
            }
        }
        return jobDto;
    }
}

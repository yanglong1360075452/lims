package com.wizinno.lims.activ.extract.service.impl;

import com.wizinno.lims.activ.extract.domain.ExecExtract;
import com.wizinno.lims.activ.extract.domain.ExtractMethod;
import com.wizinno.lims.activ.extract.domain.ExtractMethodScheme;
import com.wizinno.lims.activ.extract.dto.ExtractDto;
import com.wizinno.lims.activ.extract.dto.ExtractSampleDto;
import com.wizinno.lims.activ.extract.repository.ExecExtractRepository;
import com.wizinno.lims.activ.extract.repository.ExtractMethodRepository;
import com.wizinno.lims.activ.extract.repository.ExtractMethodSchemeRepository;
import com.wizinno.lims.activ.extract.service.ExtractService;
import com.wizinno.lims.activ.service.dto.EndInputDto;
import com.wizinno.lims.activ.service.dto.StartInputDto;
import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.data.SampleStatusEnum;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.common.security.UserContext;
import com.wizinno.lims.project.service.*;
import com.wizinno.lims.project.service.condition.ActivSampleCondition;
import com.wizinno.lims.project.service.data.ExecutionStatus;
import com.wizinno.lims.project.service.dto.*;
import com.wizinno.lims.project.service.dto.job.content.SampleExtractDto;
import com.wizinno.lims.user.service.UserService;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfActivDto;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfDto;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LiuMei
 * @date 2017-11-09.
 */
@Service("ExtractService")
public class ExtractServiceImpl<T> implements ExtractService<T> {

    @Autowired
    private ExecutionService executionService;

    @Autowired
    private SampleService sampleService;

    @Autowired
    private ExecutionSampleService executionSampleService;

    @Autowired
    private ExecExtractRepository execExtractRepository;

    @Autowired
    private SubTaskSampleService subTaskSampleService;

    @Autowired
    private SampleLotService sampleLotService;

    @Autowired
    private UserService userService;

    @Autowired
    private SubTaskService subTaskService;

    @Autowired
    private ExtractMethodSchemeRepository extractMethodSchemeRepository;

    @Autowired
    private ExtractMethodRepository extractMethodRepository;

    private Integer DNA_ID = 12;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ExecutionDto start(StartInputDto data) throws CustomException {
        ExecutionDto executionDto = null;
        if (data != null) {
            Long extractMethod = data.getExtractMethod();
            if (extractMethod == null) {
                throw new CustomException(CustomExceptionCode.PARAM_ERROR);
            }
            ExtractDto extractDto = new ExtractDto();
            BeanUtils.copyProperties(data, extractDto);
            List<Long> sampleIds = extractDto.getSampleIds();
            SubTaskDto subTaskDto = extractDto.getSubTask();
            CfgWfActivDto wfCfgActiv = extractDto.getWfCfgActiv();
            CfgWfDto wfCfgWf = extractDto.getWfCfgWf();
            String note = extractDto.getNote();
            if (CollectionUtils.isEmpty(sampleIds) || subTaskDto == null || wfCfgActiv == null || wfCfgWf == null) {
                throw new CustomException(CustomExceptionCode.PARAM_ERROR);
            }
            Date now = new Date();
            Long userId = UserContext.getLoginUserID();

            Date startTime = subTaskDto.getStartTime();
            if (startTime == null) {
                subTaskDto.setStartTime(now);
            }
            subTaskDto.setUpdateTime(now);
            subTaskDto.setUpdateBy(userId);
            subTaskService.save(subTaskDto);

            executionDto = new ExecutionDto();
            executionDto.setSubTask(subTaskDto);
            executionDto.setStartTime(now);
            executionDto.setNote(note);
            executionDto.setOperator(userId);
            executionDto.setCreateBy(userId);
            executionDto.setCreateTime(now);
            executionDto.setUpdateBy(userId);
            executionDto.setUpdateTime(now);
            //生成任务执行记录
            executionDto = executionService.save(executionDto);

            //添加样本提取单独执行记录
            ExecExtract execExtract = new ExecExtract();
            execExtract.setExecutionId(executionDto.getId());
            execExtract.setExtractMethod(extractMethod);
            execExtract.setCreateBy(userId);
            execExtract.setCreateTime(now);
            execExtract.setUpdateBy(userId);
            execExtract.setUpdateTime(now);
            execExtractRepository.save(execExtract);

            List<ExecutionSampleDto> executionSampleDtoList = new ArrayList<>();
            ExecutionSampleDto executionSampleDto;
            for (Long sampleId : sampleIds) {
                SampleDto originSample = sampleService.getSampleById(sampleId);
                executionSampleDto = new ExecutionSampleDto();
                executionSampleDto.setSample(originSample);
                executionSampleDto.setExecution(executionDto);
                executionSampleDto.setSubTask(subTaskDto);
                executionSampleDto.setCreateBy(userId);
                executionSampleDto.setCreateTime(now);
                executionSampleDto.setUpdateBy(userId);
                executionSampleDto.setUpdateTime(now);
                executionSampleDtoList.add(executionSampleDto);
            }
            if (CollectionUtils.isNotEmpty(executionSampleDtoList)) {
                //添加任务执行-样本对应关系
                executionSampleService.addList(executionSampleDtoList);
            }
        }
        return executionDto;
    }

    @Override
    public T end(EndInputDto data) throws CustomException {
        if (data != null) {
            Long userId = UserContext.getLoginUserID();
            Date now = new Date();
            Long executionId = data.getExecutionId();
            Integer executionStatus = data.getExecutionStatus();
            String note = data.getNote();
            if (executionId == null || executionStatus == null) {
                throw new CustomException(CustomExceptionCode.PARAM_ERROR);
            }
            if (executionStatus.equals(ExecutionStatus.FAIL.toCode()) && StringUtils.isBlank(note)) {
                throw new CustomException(CustomExceptionCode.PARAM_ERROR);
            }
            ExecutionDto executionDto = executionService.getById(executionId);
            if (executionDto != null) {
                //更改execution记录
                executionDto.setStatus(executionStatus);
                executionDto.setUpdateBy(userId);
                executionDto.setUpdateTime(now);
                executionDto.setEndTime(now);
                executionDto.setNote(note);
                executionService.save(executionDto);

                //获取此次执行使用的样本ID列表
                List<SampleDto> useSampleList = sampleService.getUseSampleByExecutionId(executionId);
                SubTaskDto subTaskDto = executionDto.getSubTask();
                Long subTaskId = subTaskDto.getId();
                JobDto job = subTaskDto.getTask().getJob();
                Long jobId = job.getId();
                //查询相同任务是否已有样本批次信息
                SampleLotDto sampleLotDto = sampleLotService.getBySampleSource(jobId);
                Long sampleLotId = null;
                if (sampleLotDto != null) {
                    sampleLotId = sampleLotDto.getId();
                }
                /**
                 * 提取成功,生成样本批次/工作样本
                 * 如果样本已经生成过就更新原纪录不再生成新样本
                 */
                if (executionStatus.equals(ExecutionStatus.SUCCESS.toCode())) {
                    SampleLotDto originSampleLot = subTaskDto.getTask().getProject().getSampleLot();
                    if (sampleLotDto == null) {
                        //添加新生成的样本批次
                        sampleLotDto = new SampleLotDto();
                        //todo 生成编号优化
                        sampleLotDto.setNo(originSampleLot.getNo() + "-01");
                        SampleExtractDto params = (SampleExtractDto) job.getParams();
                        Long sampleCategory = params.getSampleCategory();
                        sampleLotDto.setOperator(userService.findSimpleById(userId));
                        sampleLotDto.setSampleCategory(sampleCategory);
                        sampleLotDto.setSampleType(params.getSampleType());
                        sampleLotDto.setSpecies(originSampleLot.getSpecies());
                        sampleLotDto.setSaveWay(extractMethodSchemeRepository.findSaveWayBySampleCategory(sampleCategory));
                        sampleLotDto.setSampleSource(jobId);
                        sampleLotDto.setCreateBy(userId);
                        sampleLotDto.setCreateTime(now);
                        sampleLotDto.setUpdateBy(userId);
                        sampleLotDto.setUpdateTime(now);
                        sampleLotId = sampleLotService.addOrUpdateSampleLot(sampleLotDto);
                        sampleLotDto.setId(sampleLotId);
                    }
                    Long sampleCategory = sampleLotDto.getSampleCategory();
                    Boolean DNA;
                    if (sampleCategory.equals(DNA_ID)) {
                        DNA = true;
                    } else {
                        DNA = false;
                    }
                    List<SampleDto> sampleDtoList = new ArrayList<>();
                    SampleDto sampleDto;
                    for (SampleDto useSample : useSampleList) {
                        Long useSampleId = useSample.getId();
                        sampleDto = sampleService.getSampleBySampleLotIdAndParentId(sampleLotId, useSampleId);
                        if (sampleDto == null) {
                            sampleDto = new SampleDto();
                            sampleDto.setSampleLot(sampleLotDto);
                            sampleDto.setName(useSample.getName());
                            sampleDto.setSampleStatus(SampleStatusEnum.PRODUCED.toCode());
                            sampleDto.setProductTime(now);
                            sampleDto.setExecutionId(executionDto.getId());
                            sampleDto.setParentId(useSampleId);
                            sampleDto.setOriginalId(useSampleId);
                            sampleDto.setCreateBy(userId);
                            sampleDto.setCreateTime(now);
                            if (DNA) {
                                sampleDto.setNo(useSample.getNo() + "_D");
                            } else {
                                sampleDto.setNo(useSample.getNo() + "_R");
                            }
                        }
                        sampleDto.setUpdateBy(userId);
                        sampleDto.setUpdateTime(now);
                        sampleDtoList.add(sampleDto);
                    }
                    if (CollectionUtils.isNotEmpty(sampleDtoList)) {
                        //添加/更新生成的工作样本
                        sampleService.batchOperateSample(sampleDtoList);
                    }
                } else {
                    /**
                     * 提取失败
                     * 如果之前有生成的工作样本记录,删除之前的工作样本
                     */
                    List<Long> sampleIds = new ArrayList<>();
                    for (SampleDto useSample : useSampleList) {
                        Long useSampleId = useSample.getId();
                        if (sampleLotId != null) {
                            SampleDto sampleDto = sampleService.getSampleBySampleLotIdAndParentId(sampleLotId, useSampleId);
                            if (sampleDto != null) {
                                sampleIds.add(sampleDto.getId());
                            }
                        }
                    }
                    if (CollectionUtils.isNotEmpty(sampleIds)) {
                        sampleService.deleteSample(sampleIds);
                    }
                }

                List<Long> executionSampleList = executionSampleService.getSampleBySubTaskId(subTaskId);
                if (CollectionUtils.isNotEmpty(executionSampleList)) {
                    int size = executionSampleList.size();
                    subTaskDto.setFinishSampleCount(size);
                    subTaskDto.setUpdateBy(userId);
                    subTaskDto.setUpdateTime(now);
                    if (subTaskDto.getSampleCount().equals(size)) {
                        //所有样本已操作
                        subTaskDto.setEndTime(now);
                    }
                    subTaskService.save(subTaskDto);

                }
            }
        }
        return null;
    }

    @Override
    public List<T> getExecutionSample(SubTaskDto subTaskDto) throws CustomException {
        Integer sampleCount = subTaskDto.getSampleCount();
        ActivSampleCondition condition = new ActivSampleCondition();
        SampleLotDto sampleLot = subTaskDto.getTask().getProject().getSampleLot();
        condition.setSampleCategory(sampleLot.getSampleCategory());
        condition.setSampleCount(sampleCount);
        condition.setSampleLotId(sampleLot.getId());
        condition.setJobId(subTaskDto.getTask().getJob().getId());
        return sampleService.activGetSample(condition);
    }

    @Override
    public PageData<T> getPageShowData(SubTaskDto subTaskDto, Pageable pageable) throws CustomException {
        Long id = subTaskDto.getId();
        TaskDto task = subTaskDto.getTask();
        JobDto job = task.getJob();
        SampleExtractDto params = (SampleExtractDto) job.getParams();
        PageData data = subTaskSampleService.getSampleIdBySubTaskId(id, pageable);
        List<SampleDto> sampleDtoList = data.getRows();
        if (CollectionUtils.isNotEmpty(sampleDtoList)) {
            List<ExtractSampleDto> extractSampleDtoList = new ArrayList<>();
            ExtractSampleDto extractSampleDto;
            for (SampleDto sampleDto : sampleDtoList) {
                extractSampleDto = new ExtractSampleDto();
                Long sampleId = sampleDto.getId();
                extractSampleDto.setId(sampleId);
                extractSampleDto.setNo(sampleDto.getNo());
                extractSampleDto.setName(sampleDto.getName());
                extractSampleDto.setExtractCategory(params.getSampleCategory());
                extractSampleDto.setExtractCategoryDesc(params.getSampleCategoryDesc());
                extractSampleDto.setExtractType(params.getSampleType());
                extractSampleDto.setExtractTypeDesc(params.getSampleTypeDesc());
                //查询样本最新样本提取结果
                Long executionId = executionSampleService.getLastExecutionIdBySampleIdAndSubTaskId(sampleId, id);
                if (executionId != null) {
                    ExecutionDto executionDto = executionService.getById(executionId);
                    if (executionDto != null) {
                        Integer status = executionDto.getStatus();
                        extractSampleDto.setStatus(status);
                        extractSampleDto.setStatusDesc(ExecutionStatus.getNameByCode(status));
                        extractSampleDto.setOperator(userService.findSimpleById(executionDto.getUpdateBy()));
                        extractSampleDto.setOperateTime(executionDto.getUpdateTime());
                        extractSampleDto.setNote(executionDto.getNote());
                        ExecExtract execExtract = execExtractRepository.findByExecutionId(executionId);
                        Long extractMethod = execExtract.getExtractMethod();
                        extractSampleDto.setExtractMethod(extractMethod);
                        extractSampleDto.setExtractMethodDesc(extractMethodRepository.getOne(extractMethod).getName());
                    }
                }
                extractSampleDtoList.add(extractSampleDto);
            }
            data.setRows(extractSampleDtoList);
        }
        return data;
    }

    @Override
    public List<ExtractMethod> getExtractMethod(long species, long extractType) {
        List<ExtractMethodScheme> data = extractMethodSchemeRepository.findBySpeciesAndSampleType(species, extractType);
        List<ExtractMethod> extractMethodList = null;
        if(CollectionUtils.isNotEmpty(data)){
            extractMethodList = new ArrayList<>();
            for (ExtractMethodScheme scheme : data){
                extractMethodList.add(scheme.getExtractMethod());
            }
        }
        return extractMethodList;
    }

    @Override
    public String getSopByMethod(long method) {
        String sop = null;
        ExtractMethod extractMethod = extractMethodRepository.findOne(method);
        if(extractMethod != null){
            sop = extractMethod.getSop();
        }
        return sop;
    }
}

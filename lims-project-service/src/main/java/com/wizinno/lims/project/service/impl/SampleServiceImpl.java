package com.wizinno.lims.project.service.impl;

import com.wizinno.lims.common.data.*;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.common.query.Criteria;
import com.wizinno.lims.common.query.Restrictions;
import com.wizinno.lims.common.query.SimpleExpression;
import com.wizinno.lims.common.security.UserContext;
import com.wizinno.lims.common.util.CommonUtil;
import com.wizinno.lims.common.util.HibernateUtil;
import com.wizinno.lims.project.domain.Project;
import com.wizinno.lims.project.domain.Sample;
import com.wizinno.lims.project.domain.SampleLot;
import com.wizinno.lims.project.domain.SubTaskSampleR;
import com.wizinno.lims.project.repository.ProjectRepository;
import com.wizinno.lims.project.repository.SampleLotRepository;
import com.wizinno.lims.project.repository.SampleRepository;
import com.wizinno.lims.project.service.ProjectService;
import com.wizinno.lims.project.service.SampleLotService;
import com.wizinno.lims.project.service.SampleService;
import com.wizinno.lims.project.service.condition.ActivSampleCondition;
import com.wizinno.lims.project.service.condition.SampleCondition;
import com.wizinno.lims.project.service.dto.ProjectDto;
import com.wizinno.lims.project.service.dto.SampleDto;
import com.wizinno.lims.project.service.dto.SampleLotDto;
import com.wizinno.lims.tracking.service.TrackingService;
import com.wizinno.lims.tracking.service.dto.TrackingDto;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author LiuMei on 2017-06-22.
 */
@Service
public class SampleServiceImpl<T> implements SampleService<T> {

    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    private SampleLotRepository sampleLotRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private SampleLotService sampleLotService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TrackingService trackingService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void operateSample(SampleLotDto sampleLotDto) throws CustomException {
        if (sampleLotDto != null) {
            Long id = sampleLotDto.getId();
            if (id != null) {
                Project project = projectRepository.getBySampleLotId(id);
                List<TrackingDto> trackingDTOs = new ArrayList<>();
                TrackingDto trackingDto;
                SampleLot sampleLot = sampleLotRepository.findOne(id);
                Long userId = sampleLotDto.getUpdateBy();
                Date updateTime = sampleLotDto.getUpdateTime();
                Set<SampleDto> sampleDTOs = sampleLotDto.getSamples();
                Set<Sample> samplesAdd = new HashSet<>();
                if (CollectionUtils.isNotEmpty(sampleDTOs)) {
                    Sample sample;
                    for (SampleDto sampleDto : sampleDTOs) {
                        Long sampleId = sampleDto.getId();
                        //新增样本
                        if (sampleId == null) {
                            sample = new Sample();
                            BeanUtils.copyProperties(sampleDto, sample);
                            sample.setCreateBy(userId);
                            sample.setCreateTime(updateTime);
                            sample.setSampleLot(sampleLot);
                            sample.setUpdateBy(userId);
                            sample.setUpdateTime(updateTime);
                            sample.setSampleStatus(SampleStatusEnum.BOOK_BUILDING.toCode());
                            samplesAdd.add(sample);
                        } else {
                            //编辑样本
                            sample = sampleRepository.findOne(sampleId);
                            Set<String> exclusiveFields = new HashSet<>();
                            exclusiveFields.add("id");
                            exclusiveFields.add("no");
                            exclusiveFields.add("sampleLot");
                            exclusiveFields.add("originalId");
                            exclusiveFields.add("parentId");
                            exclusiveFields.add("sampleStatus");
                            exclusiveFields.add("storageLocation");
                            exclusiveFields.add("productStatus");
                            exclusiveFields.add("receiveTime");
                            exclusiveFields.add("createBy");
                            exclusiveFields.add("createTime");
                            sample = (Sample) CommonUtil.updateTrans(sampleDto, sample, exclusiveFields);
                            sample.setUpdateBy(userId);
                            sample.setUpdateTime(updateTime);
                            sampleRepository.save(sample);

                            trackingDto = new TrackingDto();
                            trackingDto.setProject(projectService.projectToDto(project));
                            trackingDto.setSampleLot(sampleLotDto);
                            trackingDto.setSample(sampleToDto((T) sample));
                            trackingDto.setType(TrackingTypeEnum.SAMPLE.toCode());
                            trackingDto.setOperate(TrackingOperateEnum.SAMPLE_UPDATE.toCode());
                            trackingDto.setCreateTime(updateTime);
                            trackingDto.setCreateBy(userId);
                            trackingDTOs.add(trackingDto);
                        }
                    }
                }
                String maxNo = getMaxNoBySampleLotId(sampleLot.getId());
                int no = 0;
                if (StringUtils.isNotBlank(maxNo)) {
                    no = Integer.parseInt(maxNo);
                }
                for (Sample sample : samplesAdd) {
                    sample = sampleRepository.save(sample);
                    if (StringUtils.isBlank(sample.getNo())) {
                        String formatDigit = "%03d";
                        String endId = String.format(formatDigit, ++no);
                        sample.setNo(endId);
                    }
                }
                List<Sample> sampleList = sampleRepository.save(samplesAdd);
                if (!project.getProjectStatus().equals(ProjectStatusEnum.NEW_PROJECT.toCode())) {
                    project.setUpdateBy(userId);
                    project.setUpdateTime(updateTime);
                    project.setProjectStatus(ProjectStatusEnum.NEW_PROJECT.toCode());
                    projectRepository.save(project);
                    trackingDto = new TrackingDto();
                    trackingDto.setProject(projectService.projectToDto(project));
                    trackingDto.setSampleLot(sampleLotDto);
                    trackingDto.setType(TrackingTypeEnum.PROJECT.toCode());
                    trackingDto.setOperate(TrackingOperateEnum.SAMPLE_ADD.toCode());
                    trackingDto.setCreateTime(updateTime);
                    trackingDto.setCreateBy(userId);
                    trackingDTOs.add(trackingDto);
                }
                if (CollectionUtils.isNotEmpty(sampleList)) {
                    for (Sample sample : sampleList) {
                        trackingDto = new TrackingDto();
                        trackingDto.setProject(projectService.projectToDto(project));
                        trackingDto.setSampleLot(sampleLotDto);
                        trackingDto.setSample(sampleToDto((T) sample));
                        trackingDto.setType(TrackingTypeEnum.SAMPLE.toCode());
                        trackingDto.setOperate(TrackingOperateEnum.SAMPLE_ADD.toCode());
                        trackingDto.setCreateTime(updateTime);
                        trackingDto.setCreateBy(userId);
                        trackingDTOs.add(trackingDto);
                    }
                }
                trackingService.addBatchTracking(trackingDTOs);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void batchOperateSample(List<SampleDto> sampleDtoList) {
        if (CollectionUtils.isNotEmpty(sampleDtoList)) {
            List<Sample> samples = new ArrayList<>();
            Sample sample;
            for (SampleDto sampleDto : sampleDtoList) {
                sample = new Sample();
                BeanUtils.copyProperties(sampleDto, sample);
                sample.setSampleLot((SampleLot) sampleLotService.sampleLotDtoToPO(sampleDto.getSampleLot()));
                samples.add(sample);
            }
            sampleRepository.save(samples);
        }
    }

    @Override
    public SampleDto getSampleById(long id) throws CustomException {
        Sample sample = sampleRepository.findOne(id);
        return sampleToDto((T) sample);
    }

    @Override
    public SampleDto getSampleBySampleLotIdAndParentId(long sampleLotId, long parentId) {
        return sampleToDto((T) sampleRepository.getBySampleLotIdAndParentId(sampleLotId,parentId));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void receiveDeleteSample(List<Long> id) throws CustomException {
        List<Sample> samples = sampleRepository.findAll(id);
        if (CollectionUtils.isNotEmpty(samples)) {
            for (Sample sample : samples) {
                trackingService.deleteBySampleId(sample.getId());
                sampleRepository.delete(sample.getId());
            }
            Long sampleLotId = samples.get(0).getSampleLot().getId();
            List<Sample> sampleList = sampleRepository.getBySampleLotId(sampleLotId);
            List<Sample> sampleLists = sampleRepository.getBySampleLotIdAndSampleStatus(
                    sampleLotId, SampleStatusEnum.BOOK_BUILDING.toCode());
            ProjectDto projectDto = projectService.getProjectBySampleLotId(sampleLotId);
            Integer status = projectDto.getProjectStatus();
            if (CollectionUtils.isNotEmpty(sampleList) && CollectionUtils.isEmpty(sampleLists)) {
                if (!status.equals(ProjectStatusEnum.SAMPLE_DELIVERY.toCode())) {
                    projectService.updateProjectStatus(projectDto.getId(), ProjectStatusEnum.SAMPLE_DELIVERY.toCode());
                }
            } else if (CollectionUtils.isEmpty(sampleList)) {
                if (!status.equals(ProjectStatusEnum.NEW_PROJECT.toCode())) {
                    projectService.updateProjectStatus(projectDto.getId(), ProjectStatusEnum.NEW_PROJECT.toCode());
                }
            }
            List<TrackingDto> trackingDTOs = new ArrayList<>();
            TrackingDto projectTracking = new TrackingDto();
            projectTracking.setProject(projectDto);
            projectTracking.setSampleLot(projectDto.getSampleLot());
            projectTracking.setType(TrackingTypeEnum.PROJECT.toCode());
            projectTracking.setOperate(TrackingOperateEnum.SAMPLE_DELETE.toCode());
            projectTracking.setCreateTime(new Date());
            projectTracking.setCreateBy(UserContext.getLoginUserID());
            trackingDTOs.add(projectTracking);
            TrackingDto sampleLotTracking = new TrackingDto();
            sampleLotTracking.setProject(projectDto);
            sampleLotTracking.setSampleLot(projectDto.getSampleLot());
            sampleLotTracking.setType(TrackingTypeEnum.SAMPLE_LOT.toCode());
            sampleLotTracking.setOperate(TrackingOperateEnum.SAMPLE_DELETE.toCode());
            sampleLotTracking.setCreateTime(new Date());
            sampleLotTracking.setCreateBy(UserContext.getLoginUserID());
            trackingDTOs.add(sampleLotTracking);
            trackingService.addBatchTracking(trackingDTOs);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSample(List<Long> id) throws CustomException {
        List<Sample> samples = sampleRepository.findAll(id);
        if (CollectionUtils.isNotEmpty(samples)) {
            for (Sample sample : samples) {
                trackingService.deleteBySampleId(sample.getId());
                sampleRepository.delete(sample.getId());
            }
        }
    }

    @Override
    public PageData<SampleDto> getSamplesByCondition(SampleCondition condition, PageRequest pageRequest) {
        Long sampleLotId = condition.getSampleLotId();
        String filter = condition.getFilter();
        String sampleNo = condition.getSampleNo();
        List<Long> sampleCategory = condition.getSampleCategory();
        String sampleLotNo = condition.getSampleLotNo();
        Integer sampleStatus = condition.getSampleStatus();
        Integer productStatus = condition.getProductStatus();
        Session session = HibernateUtil.getSession();
        org.hibernate.Criteria criteria = session.createCriteria(Sample.class, "s");
        if (StringUtils.isNotBlank(filter)) {
            criteria.add(Property.forName("name").like(filter, MatchMode.ANYWHERE));
        }
        if (StringUtils.isNotBlank(sampleNo)) {
            criteria.add(Property.forName("no").like(sampleNo, MatchMode.ANYWHERE));
        }
        if (sampleStatus != null) {
            criteria.add(Property.forName("sampleStatus").eq(sampleStatus));
        }
        if (productStatus != null) {
            criteria.add(Property.forName("productStatus").eq(productStatus));
        }
        if (sampleLotId != null || sampleCategory != null || StringUtils.isNotBlank(sampleLotNo)) {
            //关联实体中有关联关系的关系表
            criteria.createAlias("sampleLot", "sl");
            if (sampleLotId != null) {
                criteria.add(Property.forName("sl.id").eq(sampleLotId));
            }
            if (CollectionUtils.isNotEmpty(sampleCategory)) {
                criteria.add(Property.forName("sl.sampleCategory").in(sampleCategory));
            }
            if (StringUtils.isNotBlank(sampleLotNo)) {
                criteria.add(Property.forName("sl.no").like(sampleLotNo, MatchMode.ANYWHERE));
            }
        }
        int pageSize = pageRequest.getPageSize();
        int pageNumber = pageRequest.getPageNumber();
        long totalElements = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        Long totalPages = CommonUtil.getTotalPage(totalElements, pageSize);
        criteria.setProjection(null);
        criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        criteria.setFirstResult(pageSize * pageNumber);
        criteria.setMaxResults(pageSize);
        criteria.addOrder(Order.desc("createTime"));
        List<Sample> content = criteria.list();
        return new PageData(pageRequest.getPageNumber(), pageRequest.getPageSize(), samplesToDTOs(content), totalPages, totalElements);
    }

    @Override
    public List<SampleDto> getSamplesByCondition(SampleCondition condition) {
        Long sampleLotId = condition.getSampleLotId();
        String filter = condition.getFilter();
        Criteria criteria = new Criteria();
        if (sampleLotId != null) {
            criteria.add(Restrictions.eq("sampleLot", sampleLotId, true));
        }
        if (StringUtils.isNotBlank(filter)) {
            SimpleExpression no = Restrictions.like("no", filter, true);
            SimpleExpression name = Restrictions.like("name", filter, true);
            criteria.add(Restrictions.or(no, name));
        }
        List<Sample> content = sampleRepository.findAll(criteria);
        return samplesToDTOs(content);
    }

    @Override
    public String getMaxNoBySampleLotId(long sampleLotId) {
        return sampleRepository.selectMaxNoBySampleLotId(sampleLotId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void receiveSamples(long sampleLotId, List<Long> ids) throws CustomException {
        Long userId = UserContext.getLoginUserID();
        Date now = new Date();
        if (CollectionUtils.isNotEmpty(ids)) {
            Project project = projectRepository.getBySampleLotId(sampleLotId);
            if (project == null) {
                throw new CustomException(CustomExceptionCode.PARAM_ERROR);
            }
            List<Sample> samples = new ArrayList<>();
            for (Long id : ids) {
                Sample sample = sampleRepository.findOne(id);
                if (sample == null || !sample.getSampleLot().getId().equals(sampleLotId)) {
                    throw new CustomException(CustomExceptionCode.PARAM_ERROR);
                }
                Integer sampleStatus = sample.getSampleStatus();
                if (!sampleStatus.equals(SampleStatusEnum.RECEIVED.toCode())) {
                    sample.setReceiveTime(now);
                    sample.setSampleStatus(SampleStatusEnum.RECEIVED.toCode());
                    sample.setUpdateBy(userId);
                    sample.setUpdateTime(now);
                    samples.add(sample);
                }
            }
            List<TrackingDto> trackingDTOs = new ArrayList<>();
            TrackingDto trackingDto;
            if (samples.size() > 0) {
                List<Sample> save = sampleRepository.save(samples);
                ProjectDto projectDto = projectService.projectSimpleToDto(project);
                if (CollectionUtils.isNotEmpty(save)) {
                    for (Sample sample : save) {
                        trackingDto = new TrackingDto();
                        trackingDto.setProject(projectDto);
                        trackingDto.setSampleLot(projectDto.getSampleLot());
                        trackingDto.setSample(sampleToDto((T) sample));
                        trackingDto.setType(TrackingTypeEnum.SAMPLE.toCode());
                        trackingDto.setOperate(TrackingOperateEnum.SAMPLE_RECEIVE.toCode());
                        trackingDto.setCreateTime(now);
                        trackingDto.setCreateBy(userId);
                        trackingDTOs.add(trackingDto);
                    }
                }
                List<Sample> sampleList = sampleRepository.getBySampleLotIdAndSampleStatus(sampleLotId, SampleStatusEnum.BOOK_BUILDING.toCode());
                if (CollectionUtils.isEmpty(sampleList)) {
                    projectService.updateProjectStatus(project.getId(), ProjectStatusEnum.SAMPLE_DELIVERY.toCode());
                    trackingDto = new TrackingDto();
                    trackingDto.setProject(projectDto);
                    trackingDto.setSampleLot(projectDto.getSampleLot());
                    trackingDto.setType(TrackingTypeEnum.PROJECT.toCode());
                    trackingDto.setOperate(TrackingOperateEnum.SAMPLE_RECEIVE.toCode());
                    trackingDto.setCreateTime(now);
                    trackingDto.setCreateBy(userId);
                    trackingDTOs.add(trackingDto);
                }
            }
            trackingService.addBatchTracking(trackingDTOs);
        }
    }

    @Override
    public void rejectSamples(long sampleLotId, List<Long> ids) throws CustomException {
        Long userId = UserContext.getLoginUserID();
        Date now = new Date();
        Project project = projectRepository.getBySampleLotId(sampleLotId);
        if (project == null) {
            throw new CustomException(CustomExceptionCode.PARAM_ERROR);
        }
        ProjectDto projectDto = projectService.projectSimpleToDto(project);
        if (CollectionUtils.isNotEmpty(ids)) {
            List<Sample> samples = new ArrayList<>();
            for (Long id : ids) {
                Sample sample = sampleRepository.findOne(id);
                if (sample == null || !sample.getSampleLot().getId().equals(sampleLotId)) {
                    throw new CustomException(CustomExceptionCode.PARAM_ERROR);
                }
                Integer sampleStatus = sample.getSampleStatus();
                if (!sampleStatus.equals(SampleStatusEnum.REJECTION.toCode())) {
                    sample.setSampleStatus(SampleStatusEnum.REJECTION.toCode());
                    sample.setUpdateBy(userId);
                    sample.setUpdateTime(now);
                    sample.setReceiveTime(null);
                    samples.add(sample);
                }
            }
            if (samples.size() > 0) {
                List<Sample> save = sampleRepository.save(samples);
                List<TrackingDto> trackingDTOs = new ArrayList<>();
                TrackingDto trackingDto;
                if (CollectionUtils.isNotEmpty(save)) {
                    for (Sample sample : save) {
                        trackingDto = new TrackingDto();
                        trackingDto.setProject(projectDto);
                        trackingDto.setSampleLot(projectDto.getSampleLot());
                        trackingDto.setSample(sampleToDto((T) sample));
                        trackingDto.setType(TrackingTypeEnum.SAMPLE.toCode());
                        trackingDto.setOperate(TrackingOperateEnum.SAMPLE_REJECTION.toCode());
                        trackingDto.setCreateTime(now);
                        trackingDto.setCreateBy(userId);
                        trackingDTOs.add(trackingDto);
                    }
                }
                List<Sample> sampleList = sampleRepository.getBySampleLotIdAndSampleStatus(sampleLotId, SampleStatusEnum.BOOK_BUILDING.toCode());
                List<Sample> sampleReceiveList = sampleRepository.getBySampleLotIdAndSampleStatus(sampleLotId, SampleStatusEnum.RECEIVED.toCode());
                if (CollectionUtils.isEmpty(sampleList)) {
                    //样本除了退回的都是已接收,更改项目状态为样本送达
                    if (CollectionUtils.isNotEmpty(sampleReceiveList)) {
                        projectService.updateProjectStatus(project.getId(), ProjectStatusEnum.SAMPLE_DELIVERY.toCode());
                    } else {
                        //全部是已退回,更改项目为新项目
                        projectService.updateProjectStatus(project.getId(), ProjectStatusEnum.NEW_PROJECT.toCode());
                    }
                    trackingDto = new TrackingDto();
                    trackingDto.setProject(projectDto);
                    trackingDto.setSampleLot(projectDto.getSampleLot());
                    trackingDto.setType(TrackingTypeEnum.PROJECT.toCode());
                    trackingDto.setOperate(TrackingOperateEnum.SAMPLE_REJECTION.toCode());
                    trackingDto.setCreateTime(now);
                    trackingDto.setCreateBy(userId);
                    trackingDTOs.add(trackingDto);
                }
                trackingService.addBatchTracking(trackingDTOs);
            }
        }
    }

    @Override
    public List<SampleDto> getBySampleLotIdAndSampleStatus(long sampleLotId, int sampleStatus) throws CustomException {
        List<Sample> samples = sampleRepository.getBySampleLotIdAndSampleStatus(sampleLotId, sampleStatus);
        return samplesToDTOs(samples);
    }

    @Override
    public T sampleDtoToPO(SampleDto sampleDto) {
        Sample sample = null;
        if (sampleDto != null) {
            sample = new Sample();
            BeanUtils.copyProperties(sampleDto, sample);
        }
        return (T) sample;
    }

    @Override
    public SampleDto sampleToDto(T data) {
        SampleDto sampleDto = null;
        if (data != null) {
            Sample sample = (Sample) data;
            sampleDto = new SampleDto();
            BeanUtils.copyProperties(sample, sampleDto);
            SampleLot sampleLot = sample.getSampleLot();
            sampleDto.setSampleLot(sampleLotService.sampleLotToDto(sampleLot));
            sampleDto.setProductStatusDesc(ProductStatusEnum.getNameByCode(sampleDto.getProductStatus()));
            sampleDto.setSampleStatusDesc(SampleStatusEnum.getNameByCode(sampleDto.getSampleStatus()));
        }
        return sampleDto;
    }

    @Override
    public List<SampleDto> getUseSampleByExecutionId(long executionId) {
        return samplesToDTOs(sampleRepository.getUseSampleByExecutionId(executionId));
    }

    @Override
    public List<SampleDto> activGetSample(ActivSampleCondition condition) {
        Long sampleLotId = condition.getSampleLotId();
        Long jobId = condition.getJobId();
        Long sampleCategory = condition.getSampleCategory();
        Session session = HibernateUtil.getSession();
        org.hibernate.Criteria criteria = session.createCriteria(Sample.class, "s");
        if (sampleLotId != null || sampleCategory != null) {
            //关联实体中有关联关系的关系表
            criteria.createAlias("sampleLot", "sl");
            if (sampleLotId != null) {
                criteria.add(Property.forName("sl.id").eq(sampleLotId));
            }
            if (sampleCategory != null) {
                criteria.add(Property.forName("sl.sampleCategory").eq(sampleCategory));
            }
        }
        if (jobId != null) {
            //关联实体中没有关联关系的关系表
            DetachedCriteria sisCri = DetachedCriteria.forClass(SubTaskSampleR.class, "ts");
            sisCri.add(Property.forName("ts.job.id").eq(jobId));
            ProjectionList pList = Projections.projectionList();
            //子查询只查部分字段
            pList.add(Projections.property("ts.sample.id").as("sampleId"));
            sisCri.setProjection(pList);
            criteria.add(Property.forName("s.id").notIn(sisCri));
        }
        criteria.setProjection(null);
        criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        criteria.addOrder(Order.asc("s.id"));
        Integer sampleCount = condition.getSampleCount();
        if (sampleCount != null) {
            criteria.setMaxResults(sampleCount);
        }
        List<Sample> content = criteria.list();
        return samplesToDTOs(content);
    }

    public List<SampleDto> samplesToDTOs(List<Sample> samples) {
        List<SampleDto> sampleDTOs = null;
        if (CollectionUtils.isNotEmpty(samples)) {
            sampleDTOs = new ArrayList<>();
            for (Sample sample : samples) {
                sampleDTOs.add(sampleToDto((T) sample));
            }
        }
        return sampleDTOs;
    }
}

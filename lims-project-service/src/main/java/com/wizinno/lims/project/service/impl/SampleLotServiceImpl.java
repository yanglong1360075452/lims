package com.wizinno.lims.project.service.impl;

import com.wizinno.lims.common.data.*;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.security.UserContext;
import com.wizinno.lims.common.util.CommonUtil;
import com.wizinno.lims.common.util.HibernateUtil;
import com.wizinno.lims.log.service.DataDictService;
import com.wizinno.lims.project.domain.Project;
import com.wizinno.lims.project.domain.SampleLot;
import com.wizinno.lims.project.repository.ProjectRepository;
import com.wizinno.lims.project.repository.SampleLotRepository;
import com.wizinno.lims.project.service.ProjectService;
import com.wizinno.lims.project.service.SampleLotService;
import com.wizinno.lims.project.service.condition.ProjectCondition;
import com.wizinno.lims.project.service.dto.ProjectDto;
import com.wizinno.lims.project.service.dto.ProjectSampleLotDto;
import com.wizinno.lims.project.service.dto.SampleLotDto;
import com.wizinno.lims.tracking.service.dto.TrackingDto;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.sql.JoinType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author LiuMei on 2017-06-22.
 */
@Service
public class SampleLotServiceImpl implements SampleLotService {

    @Autowired
    private SampleLotRepository sampleLotRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DataDictService dataDictService;

    @Autowired
    private ProjectService projectService;

    @Override
    public Long addOrUpdateSampleLot(SampleLotDto sampleLotDto) throws CustomException {
        Long userId = sampleLotDto.getUpdateBy();
        Date updateTime = sampleLotDto.getUpdateTime();
        if (sampleLotDto != null) {
            Long id = sampleLotDto.getId();
            SampleLot sampleLot;
            List<TrackingDto> trackingDTOs = new ArrayList<>();
            TrackingDto trackingDto = new TrackingDto();
            trackingDto.setType(TrackingTypeEnum.SAMPLE_LOT.toCode());
            trackingDto.setCreateBy(userId);
            trackingDto.setCreateTime(updateTime);
            if (id != null) {
                trackingDto.setOperate(TrackingOperateEnum.SAMPLE_LOT_UPDATE.toCode());
                sampleLot = sampleLotRepository.findOne(id);
                Set<String> exclusiveFields = new HashSet<>();
                exclusiveFields.add("id");
                exclusiveFields.add("no");
                exclusiveFields.add("samples");
                exclusiveFields.add("sampleCategory");
                exclusiveFields.add("sampleType");
                exclusiveFields.add("species");
                exclusiveFields.add("sampleSource");
                exclusiveFields.add("operator");
                exclusiveFields.add("affix");
                exclusiveFields.add("createBy");
                exclusiveFields.add("updateBy");
                exclusiveFields.add("updateTime");
                exclusiveFields.add("createTime");
                sampleLot = (SampleLot) CommonUtil.updateTrans(sampleLotDto, sampleLot, exclusiveFields);
                if (sampleLotDto.getDeleteAffix()) {
                    sampleLot.setAffix(null);
                }
            } else {
                trackingDto.setOperate(TrackingOperateEnum.SAMPLE_LOT_ADD.toCode());
                sampleLot = new SampleLot();
                sampleLotDto.setCreateBy(userId);
                sampleLotDto.setCreateTime(updateTime);
                BeanUtils.copyProperties(sampleLotDto, sampleLot);
            }
            sampleLot.setStatus(SampleLotStatusEnum.VALID.toCode());
            sampleLot.setUpdateBy(userId);
            sampleLot.setUpdateTime(updateTime);
            sampleLot = sampleLotRepository.save(sampleLot);
            ProjectDto projectDto = projectService.getProjectBySampleLotId(sampleLot.getId());
            SampleLotDto sampleLotDto1 = sampleLotToDto(sampleLot);
            trackingDto.setProject(projectDto);
            trackingDto.setSampleLot(sampleLotDto1);
            trackingDTOs.add(trackingDto);
            Long projectId = sampleLotDto.getProjectId();
            //给项目添加样本批次
            if (projectId != null && id == null) {
                Project project = projectRepository.findOne(projectId);
                project.setSampleLot(sampleLot);
                projectRepository.save(project);

                trackingDto = new TrackingDto();
                trackingDto.setProject(projectDto);
                trackingDto.setType(TrackingTypeEnum.PROJECT.toCode());
                trackingDto.setSampleLot(sampleLotDto1);
                trackingDto.setOperate(TrackingOperateEnum.SAMPLE_LOT_ADD.toCode());
                trackingDto.setCreateBy(userId);
                trackingDto.setCreateTime(updateTime);
                trackingDTOs.add(trackingDto);
            }
            return sampleLot.getId();
        } else {
            return null;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSampleLotAffix(long sampleLotId, String affix) {
        SampleLot one = sampleLotRepository.findOne(sampleLotId);
        one.setUpdateTime(new Date());
        one.setUpdateBy(UserContext.getLoginUserID());
        one.setAffix(affix);
        sampleLotRepository.save(one);
    }

    @Override
    public SampleLotDto getById(long id) {
        SampleLot sampleLot = sampleLotRepository.findOne(id);
        return sampleLotToDto(sampleLot);
    }

    @Override
    public SampleLotDto getBySampleSource(long sampleSource) {
        return sampleLotToDto(sampleLotRepository.getBySampleSource(sampleSource));
    }

    @Override
    public PageData<ProjectSampleLotDto> getProjectSampleLotByCondition(ProjectCondition condition, Pageable pageable) throws CustomException {

        String projectNo = condition.getProjectNo();
        String sampleLotNo = condition.getSampleLotNo();
        String sampleLotDesc = condition.getSampleLotDesc();
        List<Integer> projectStatus = condition.getProjectStatus();
        Session session = HibernateUtil.getSession();
        org.hibernate.Criteria criteria = session.createCriteria(Project.class);
        if (StringUtils.isNotBlank(projectNo)) {
            criteria.add(Property.forName("no").eq(projectNo));
        }
        if (CollectionUtils.isNotEmpty(projectStatus)) {
            criteria.add(Property.forName("projectStatus").in(projectStatus));
        }
        criteria.createAlias("sampleLot", "sl", JoinType.INNER_JOIN);
        if (StringUtils.isNotBlank(sampleLotNo) || StringUtils.isNotBlank(sampleLotDesc)) {
            if (StringUtils.isNotBlank(sampleLotNo)) {
                criteria.add(Property.forName("sl.no").eq(sampleLotNo));
            }
            if (StringUtils.isNotBlank(sampleLotDesc)) {
                criteria.add(Property.forName("sl.description").like(sampleLotDesc, MatchMode.ANYWHERE));
            }
        }
        int pageSize = pageable.getPageSize();
        int pageNumber = pageable.getPageNumber();
        long totalElements = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
        Long totalPages = CommonUtil.getTotalPage(totalElements, pageSize);
        criteria.setProjection(null);
        criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        criteria.setFirstResult(pageSize * pageNumber);
        criteria.setMaxResults(pageSize);
        criteria.addOrder(Order.desc("createTime"));
        List<Project> list = criteria.list();
        List<ProjectSampleLotDto> projectSampleLotDTOs = null;
        if (CollectionUtils.isNotEmpty(list)) {
            projectSampleLotDTOs = new ArrayList<>();
            ProjectSampleLotDto projectSampleLotDto;
            for (Project project : list) {
                if (project != null) {
                    projectSampleLotDto = new ProjectSampleLotDto();
                    projectSampleLotDto.setId(project.getId());
                    projectSampleLotDto.setNo(project.getNo());
                    projectSampleLotDto.setName(project.getName());
                    Long sampleCategory = project.getSampleCategory();
                    projectSampleLotDto.setSampleCategory(sampleCategory);
                    projectSampleLotDto.setSampleCategoryDesc(dataDictService.getDescById(sampleCategory));
                    Long species = project.getSpecies();
                    projectSampleLotDto.setSpecies(species);
                    projectSampleLotDto.setSpeciesDesc(dataDictService.getDescById(species));
                    Integer status = project.getProjectStatus();
                    projectSampleLotDto.setProjectStatus(status);
                    projectSampleLotDto.setProjectStatusDesc(ProjectStatusEnum.getNameByCode(status));
                    SampleLot sampleLot = project.getSampleLot();
                    if (sampleLot != null) {
                        Long sampleSource = sampleLot.getSampleSource();
                        projectSampleLotDto.setSampleSource(sampleSource);
                        if (sampleSource == 0) {
                            projectSampleLotDto.setSampleSourceDesc("原始样本");
                        }
                        Long saveWay = sampleLot.getSaveWay();
                        projectSampleLotDto.setSaveWay(saveWay);
                        projectSampleLotDto.setSaveWayDesc(dataDictService.getDescById(saveWay));
                        Long sampleType = sampleLot.getSampleType();
                        projectSampleLotDto.setSampleType(sampleType);
                        projectSampleLotDto.setSampleTypeDesc(dataDictService.getDescById(sampleType));
                        projectSampleLotDto.setSampleCount((int) projectService.countSampleByProjectId(project.getId()));
                        projectSampleLotDto.setSampleLotNo(sampleLot.getNo());
                        projectSampleLotDto.setSampleNote(sampleLot.getSampleNote());
                        projectSampleLotDto.setDescription(sampleLot.getDescription());
                        projectSampleLotDto.setSampleLotId(sampleLot.getId());
                    }
                    projectSampleLotDTOs.add(projectSampleLotDto);
                }
            }
        }

        return new PageData(pageNumber, pageSize, projectSampleLotDTOs, totalPages, totalElements);
    }

    @Override
    public Object sampleLotDtoToPO(SampleLotDto sampleLotDto) {
        SampleLot sampleLot = null;
        if (sampleLotDto != null) {
            sampleLot = new SampleLot();
            BeanUtils.copyProperties(sampleLotDto, sampleLot);
        }
        return sampleLot;
    }

    @Override
    public SampleLotDto sampleLotToDto(Object sampleLot) {
        SampleLotDto sampleLotDto = null;
        if (sampleLot != null) {
            sampleLotDto = new SampleLotDto();
            BeanUtils.copyProperties(sampleLot, sampleLotDto);
            sampleLotDto.setSpeciesDesc(dataDictService.getDescById(sampleLotDto.getSpecies()));
            sampleLotDto.setStatusDesc(SampleLotStatusEnum.getNameByCode(sampleLotDto.getStatus()));
            if (null != sampleLotDto.getLibraryIndex()) {
                sampleLotDto.setLibraryIndexDesc(dataDictService.getDescById(sampleLotDto.getLibraryIndex()));
            }
            if (null != sampleLotDto.getLibrarySize()) {
                sampleLotDto.setLibrarySizeDesc(dataDictService.getDescById(sampleLotDto.getLibrarySize()));
            }
            sampleLotDto.setSampleCategoryDesc(dataDictService.getDescById(sampleLotDto.getSampleCategory()));
            sampleLotDto.setSampleTypeDesc(dataDictService.getDescById(sampleLotDto.getSampleType()));
            sampleLotDto.setSaveWayDesc(dataDictService.getDescById(sampleLotDto.getSaveWay()));
            Long sampleSource = sampleLotDto.getSampleSource();
            if (sampleSource != null && sampleSource != 0) {
                //非原始样本
                sampleLotDto.setSampleSourceDesc(sampleLotRepository.findOne(sampleSource).getNo());
            }
        }
        return sampleLotDto;
    }
}

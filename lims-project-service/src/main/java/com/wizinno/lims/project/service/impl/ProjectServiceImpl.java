package com.wizinno.lims.project.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.google.gson.Gson;
import com.wizinno.lims.common.data.*;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.common.query.Criteria;
import com.wizinno.lims.common.query.Criterion;
import com.wizinno.lims.common.query.Restrictions;
import com.wizinno.lims.common.security.UserContext;
import com.wizinno.lims.common.util.CommonUtil;
import com.wizinno.lims.common.util.ListUtil;
import com.wizinno.lims.log.service.DataDictService;
import com.wizinno.lims.project.domain.Job;
import com.wizinno.lims.project.domain.Project;
import com.wizinno.lims.project.domain.SampleLot;
import com.wizinno.lims.project.repository.JobRepository;
import com.wizinno.lims.project.repository.ProjectRepository;
import com.wizinno.lims.project.repository.SampleLotRepository;
import com.wizinno.lims.project.repository.SampleRepository;
import com.wizinno.lims.project.service.JobService;
import com.wizinno.lims.project.service.ProjectService;
import com.wizinno.lims.project.service.SampleLotService;
import com.wizinno.lims.project.service.condition.ProjectCondition;
import com.wizinno.lims.project.service.dto.JobDto;
import com.wizinno.lims.project.service.dto.ProjectDto;
import com.wizinno.lims.project.service.dto.ProjectSimpleDto;
import com.wizinno.lims.project.service.dto.SampleLotDto;
import com.wizinno.lims.project.service.TaskService;
import com.wizinno.lims.project.service.dto.TaskDto;
import com.wizinno.lims.tracking.service.TrackingService;
import com.wizinno.lims.tracking.service.dto.TrackingDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LiuMei on 2017-06-14.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private SampleLotRepository sampleLotRepository;

    @Autowired
    private SampleLotService sampleLotService;

    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    private TaskService taskService;

    @Autowired
    private JobService jobService;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private DataDictService dataDictService;

    @Autowired
    private TrackingService trackingService;

    private Gson gson = new Gson();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProjectDto addOrUpdate(ProjectDto projectDto) throws CustomException {
        Long id = projectDto.getId();
        long userId = projectDto.getUpdateBy();
        Date updateTime = projectDto.getUpdateTime();
        Project project;
        Set<Long> oldJobs = null;
        TrackingDto trackingDto;
        //新建项目
        if (id == null) {
            //添加项目记录
            project = new Project();
            BeanUtils.copyProperties(projectDto, project);
            project.setProjectStatus(ProjectStatusEnum.NEW_PROJECT.toCode());
            project.setCreateBy(userId);
            project.setCreateTime(updateTime);
            project.setUpdateBy(userId);
            project.setUpdateTime(updateTime);
            project = projectRepository.save(project);

            //添加新建项目日志记录
            trackingDto = new TrackingDto();
            trackingDto.setProject(projectSimpleToDto(project));
            trackingDto.setType(TrackingTypeEnum.PROJECT.toCode());
            trackingDto.setOperate(TrackingOperateEnum.PROJECT_CREATE.toCode());
            trackingDto.setCreateBy(userId);
            trackingDto.setCreateTime(updateTime);
            trackingService.addTracking(trackingDto);
        } else {//编辑项目
            project = projectRepository.findOne(id);

            //添加编辑项目日志记录
            trackingDto = new TrackingDto();
            trackingDto.setProject(projectSimpleToDto(project));
            trackingDto.setType(TrackingTypeEnum.PROJECT.toCode());
            trackingDto.setOperate(TrackingOperateEnum.PROJECT_UPDATE.toCode());
            trackingDto.setCreateBy(userId);
            trackingDto.setCreateTime(updateTime);
            trackingService.addTracking(trackingDto);

            //修改样本批次信息
            oldJobs = jobRepository.findIdsByProject(project);
            SampleLot sampleLot = project.getSampleLot();
            Long oldCategory = project.getSampleCategory();
            Long oldSpecies = project.getSpecies();
            Long oldSampleType = project.getSampleType();
            Long sampleCategory = projectDto.getSampleCategory();
            Long species = projectDto.getSpecies();
            Long sampleType = projectDto.getSampleType();
            //如果有修改样本类别/物种分类/样本类型,同步更改样本批次对应信息
            if (sampleLot != null) {
                if (!oldCategory.equals(sampleCategory) || !oldSpecies.equals(species) || !oldSampleType.equals(sampleType)) {
                    if (!oldCategory.equals(sampleCategory)) {
                        sampleLot.setSampleCategory(sampleCategory);
                    }
                    if (!oldSpecies.equals(species)) {
                        sampleLot.setSpecies(species);
                    }
                    if(!oldSampleType.equals(sampleType)){
                        sampleLot.setSampleType(sampleType);
                    }
                    sampleLot = sampleLotRepository.save(sampleLot);

                    //添加修改样本批次信息日志
                    trackingDto = new TrackingDto();
                    trackingDto.setProject(projectSimpleToDto(project));
                    trackingDto.setSampleLot(sampleLotService.sampleLotToDto(sampleLot));
                    trackingDto.setType(TrackingTypeEnum.SAMPLE_LOT.toCode());
                    trackingDto.setOperate(TrackingOperateEnum.SAMPLE_LOT_UPDATE.toCode());
                    trackingDto.setCreateBy(userId);
                    trackingDto.setCreateTime(updateTime);
                    trackingService.addTracking(trackingDto);
                }
            }
            //设置项目不能修改的字段信息
            Set<String> exclusiveFields = new HashSet<>();
            exclusiveFields.add("jobs");
            exclusiveFields.add("sampleLot");
            exclusiveFields.add("no");
            exclusiveFields.add("productStatus");
            exclusiveFields.add("actualCompleteTime");
            exclusiveFields.add("projectStatus");
            exclusiveFields.add("createBy");
            exclusiveFields.add("createTime");
            project = (Project) CommonUtil.updateTrans(projectDto, project, exclusiveFields);
        }

        //生成项目编号
        if (project.getNo() == null) {
            String formatDigit = "%04d";
            String formatDate = new SimpleDateFormat("yy").format(new Date());
            String endId = String.format(formatDigit, project.getId());
            String no = formatDate + endId;
            project.setNo(no);
            project.setUpdateBy(userId);
            project.setUpdateTime(updateTime);
            project = projectRepository.save(project);
        }

        //工作内容(新增或更改或删除)
        Set<JobDto> jobDTOs = projectDto.getJobs();
        Set<Long> saveIds = new HashSet<>();
        Set<Job> jobs = new HashSet<>();
        for (JobDto jobDto : jobDTOs) {
            Long jobDtoId = jobDto.getId();
            Job job;
            if (jobDtoId == null) {
                job = new Job();
                BeanUtils.copyProperties(jobDto, job);
                job.setCreateBy(userId);
                job.setCreateTime(updateTime);
                job.setProject(project);
            } else {
                saveIds.add(jobDtoId);
                job = jobRepository.findOne(jobDtoId);
            }
            Object params = jobDto.getParams();
            if (params != null) {
                job.setParams(gson.toJson(params));
            }
            job.setUpdateBy(userId);
            job.setUpdateTime(updateTime);
            jobs.add(job);
        }
        if (oldJobs != null) {
            Set<Long> minus = ListUtil.minus(oldJobs, saveIds);
            for (Long delete : minus) {
                jobRepository.delete(delete);
            }
        }
        jobRepository.save(jobs);
        BeanUtils.copyProperties(project, projectDto);
        return projectDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateProjectStatus(long projectId, int status) throws CustomException {
        Project project = projectRepository.findOne(projectId);
        if (project != null) {
            project.setProjectStatus(status);
            project.setUpdateTime(new Date());
            project.setUpdateBy(UserContext.getLoginUserID());
            projectRepository.save(project);
        }
    }


    @Override
    public ProjectDto getProjectById(long id) throws CustomException {
        Project project = projectRepository.findOne(id);
        return projectToDto(project);
    }

    @Override
    public ProjectDto getProjectByNo(String no) throws CustomException {
        Project project = projectRepository.getByNo(no);
        return projectToDto(project);
    }

    @Override
    public ProjectDto getProjectBySampleLotId(long sampleLotId) throws CustomException {
        Project project = projectRepository.getBySampleLotId(sampleLotId);
        return projectToDto(project);
    }

    @Override
    public PageData<ProjectSimpleDto> getProjectByCondition(ProjectCondition condition, Pageable pageable) throws CustomException {
        List<Integer> projectStatus = condition.getProjectStatus();
        Date time = condition.getCreateTime();
        Integer productStatus = condition.getProductStatus();
        String projectName = condition.getProjectName();
        String projectNo = condition.getProjectNo();

        Criteria c = new Criteria();
        if (CollectionUtils.isNotEmpty(projectStatus)) {
            c.add(Restrictions.in("projectStatus", projectStatus, true));
        }
        if (productStatus != null) {
            c.add(Restrictions.eq("productStatus", productStatus, true));
        }
        if (time != null) {
            Criterion criterion = new Criterion() {
                @Override
                public Predicate toPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                    Calendar calendar = new GregorianCalendar();
                    calendar.setTime(time);
                    //把日期往后增加一天.整数往后推,负数往前移动
                    calendar.add(Calendar.DATE, 1);
                    //这个时间就是日期往后推一天的结果
                    Date endTime = calendar.getTime();
                    Predicate p1 = builder.lessThanOrEqualTo(root.get("createTime").as(Date.class), endTime);
                    Predicate p2 = builder.greaterThanOrEqualTo(root.get("createTime").as(Date.class), time);
                    return builder.and(p1, p2);
                }
            };
            c.add(criterion);
        }
        if (projectName != null) {
            c.add(Restrictions.like("name", projectName, true));
        }
        if (projectNo != null) {
            c.add(Restrictions.like("no", projectNo, true));
        }
        Page page = projectRepository.findAll(c, pageable);
        long totalElements = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<Project> content = page.getContent();

        List<ProjectSimpleDto> projectSimpleDTOs = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(content)) {
            ProjectSimpleDto simpleDto;
            for (Project project : content) {
                simpleDto = new ProjectSimpleDto();
                BeanUtils.copyProperties(project, simpleDto);
                simpleDto.setSpeciesDesc(dataDictService.getDescById(simpleDto.getSpecies()));
                simpleDto.setProductStatusDesc(ProductStatusEnum.getNameByCode(simpleDto.getProductStatus()));
                simpleDto.setProjectStatusDesc(ProjectStatusEnum.getNameByCode(simpleDto.getProjectStatus()));
                simpleDto.setProjectTypeDesc(dataDictService.getDescById(simpleDto.getProjectType()));
                simpleDto.setSampleCategoryDesc(dataDictService.getDescById(simpleDto.getSampleCategory()));
                simpleDto.setSampleCount(countSampleByProjectId(project.getId()));
                projectSimpleDTOs.add(simpleDto);
            }
        }
        return new PageData(pageable.getPageNumber(), pageable.getPageSize(), projectSimpleDTOs, totalPages, totalElements);
    }

    @Override
    public long countSampleByProjectId(long projectId) {
        return sampleRepository.countByProjectId(projectId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deliveryProduct(List<Long> projectIds) throws CustomException {
        if (CollectionUtils.isNotEmpty(projectIds)) {
            List<TrackingDto> trackingDTOs = new ArrayList<>();
            TrackingDto trackingDto;
            Long userId = UserContext.getLoginUserID();
            Date now = new Date();
            List<Project> projects = new ArrayList<>();
            Project project;
            for (Long id : projectIds) {
                project = projectRepository.findOne(id);
                if (project == null) {
                    throw new CustomException(CustomExceptionCode.PARAM_ERROR);
                }
                if (!project.getProjectStatus().equals(ProjectStatusEnum.SAMPLE_DELIVERY.toCode())) {
                    throw new CustomException(CustomExceptionCode.STATUS_NOT_MATCH);
                }
                project.setProjectStatus(ProjectStatusEnum.DELIVERED.toCode());
                project.setUpdateBy(userId);
                project.setUpdateTime(now);
                projects.add(project);

                trackingDto = new TrackingDto();
                trackingDto.setProject(projectSimpleToDto(project));
                trackingDto.setType(TrackingTypeEnum.PROJECT.toCode());
                trackingDto.setOperate(TrackingOperateEnum.PROJECT_DELIVERY.toCode());
                trackingDto.setCreateBy(userId);
                trackingDto.setCreateTime(now);
                trackingDTOs.add(trackingDto);
                long sampleCount = countSampleByProjectId(id);
                //生成默认工作任务
                ProjectDto projectDto = projectSimpleToDto(project);
                Set<JobDto> jobs = jobService.findByProject(projectDto);
                if (CollectionUtils.isNotEmpty(jobs)) {
                    List<TaskDto> taskDTOs = new ArrayList<>();
                    TaskDto taskDto;
                    for (JobDto job : jobs) {
                        taskDto = new TaskDto();
                        taskDto.setJob(job);
                        taskDto.setProject(projectDto);
                        taskDto.setStatus(TaskStatusEnum.NOT_ALLOT.toCode());
                        taskDto.setCreateBy(userId);
                        taskDto.setCreateTime(now);
                        taskDto.setUpdateBy(userId);
                        taskDto.setUpdateTime(now);
                        taskDto.setSampleAmount((int) sampleCount);
                        taskDto.setDefaultTask(true);
                        taskDTOs.add(taskDto);
                    }
                    List<TaskDto> afterTaskDTOs = taskService.save(taskDTOs);
                    //按工作内容类型排序
                    Collections.sort(afterTaskDTOs);
                    //设置任务的前置任务ID(第一个任务没有前置任务)
                    JSONArray jsonArray;
                    for (int i = 1; i < afterTaskDTOs.size(); i++) {
                        jsonArray = new JSONArray();
                        jsonArray.add(afterTaskDTOs.get(i - 1).getId());
                        afterTaskDTOs.get(i).setPreId(jsonArray.toJSONString());
                    }
                    List<TaskDto> finalData = taskService.save(afterTaskDTOs);
                    if(CollectionUtils.isNotEmpty(finalData)){
                        for(TaskDto taskDto1 : finalData){
                            trackingDto = new TrackingDto();
                            trackingDto.setProject(projectDto);
                            trackingDto.setSampleLot(projectDto.getSampleLot());
                            trackingDto.setTask(taskDto1);
                            trackingDto.setType(TrackingTypeEnum.TASK.toCode());
                            trackingDto.setOperate(TrackingOperateEnum.TASK_GENERATE.toCode());
                            trackingDto.setCreateBy(userId);
                            trackingDto.setCreateTime(now);
                            trackingDTOs.add(trackingDto);
                        }
                    }
                } else {
                    throw new CustomException(CustomExceptionCode.PARAM_ERROR);
                }
            }
            projectRepository.save(projects);
            trackingService.addBatchTracking(trackingDTOs);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancelProduce(long projectId) {
        taskService.deleteTaskByProjectId(projectId);
        updateProjectStatus(projectId, ProjectStatusEnum.SAMPLE_DELIVERY.toCode());
        long userId = UserContext.getLoginUserID();
        Date now = new Date();
        TrackingDto trackingDto = new TrackingDto();
        ProjectDto projectDto = getProjectById(projectId);
        trackingDto.setProject(projectDto);
        trackingDto.setSampleLot(projectDto.getSampleLot());
        trackingDto.setType(TrackingTypeEnum.PROJECT.toCode());
        trackingDto.setOperate(TrackingOperateEnum.CANCEL_PRODUCE.toCode());
        trackingDto.setCreateBy(userId);
        trackingDto.setCreateTime(now);
        trackingService.addTracking(trackingDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancel(long projectId) {
        updateProjectStatus(projectId, ProjectStatusEnum.CANCEL.toCode());
        long userId = UserContext.getLoginUserID();
        Date now = new Date();
        TrackingDto trackingDto = new TrackingDto();
        ProjectDto projectDto = getProjectById(projectId);
        trackingDto.setProject(projectDto);
        trackingDto.setSampleLot(projectDto.getSampleLot());
        trackingDto.setType(TrackingTypeEnum.PROJECT.toCode());
        trackingDto.setOperate(TrackingOperateEnum.PROJECT_CANCEL.toCode());
        trackingDto.setCreateBy(userId);
        trackingDto.setCreateTime(now);
        trackingService.addTracking(trackingDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void recover(long projectId,int status) {
        updateProjectStatus(projectId, status);
        long userId = UserContext.getLoginUserID();
        Date now = new Date();
        TrackingDto trackingDto = new TrackingDto();
        ProjectDto projectDto = getProjectById(projectId);
        trackingDto.setProject(projectDto);
        trackingDto.setSampleLot(projectDto.getSampleLot());
        trackingDto.setType(TrackingTypeEnum.PROJECT.toCode());
        trackingDto.setOperate(TrackingOperateEnum.RECOVER_PROJECT.toCode());
        trackingDto.setCreateBy(userId);
        trackingDto.setCreateTime(now);
        trackingService.addTracking(trackingDto);
    }

    @Override
    public ProjectDto projectToDto(Object project) {
        ProjectDto projectDto = null;
        if (project != null) {
            Project trans = (Project) project;
            projectDto = new ProjectDto();
            BeanUtils.copyProperties(trans, projectDto);
            projectDto.setSpeciesDesc(dataDictService.getDescById(projectDto.getSpecies()));
            projectDto.setProductStatusDesc(ProductStatusEnum.getNameByCode(projectDto.getProductStatus()));
            projectDto.setProjectStatusDesc(ProjectStatusEnum.getNameByCode(projectDto.getProjectStatus()));
            projectDto.setProjectTypeDesc(dataDictService.getDescById(projectDto.getProjectType()));
            projectDto.setSampleCategoryDesc(dataDictService.getDescById(projectDto.getSampleCategory()));
            projectDto.setSampleTypeDesc(dataDictService.getDescById(projectDto.getSampleType()));
            projectDto.setPriorityDesc(dataDictService.getDescById(projectDto.getPriority()));
            Set<JobDto> jobDTOs = jobService.findByProject(projectDto);
            projectDto.setJobs(jobDTOs);
            SampleLot sampleLot = trans.getSampleLot();
            projectDto.setSampleLot(sampleLotService.sampleLotToDto(sampleLot));
        }
        return projectDto;
    }

    @Override
    public ProjectDto projectSimpleToDto(Object project) {
        ProjectDto projectDto = null;
        if (project != null) {
            Project o = (Project) project;
            projectDto = new ProjectDto();
            projectDto.setProductStatusDesc(ProjectStatusEnum.getNameByCode(projectDto.getProjectStatus()));
            BeanUtils.copyProperties(o, projectDto);
            SampleLot sampleLot = o.getSampleLot();
            if (sampleLot != null) {
                projectDto.setSampleLot(sampleLotService.sampleLotToDto(sampleLot));
            }
        }
        return projectDto;
    }

    @Override
    public Object projectDtoSimpleToPO(ProjectDto projectDto) {
        Project project = null;
        if (projectDto != null) {
            project = new Project();
            BeanUtils.copyProperties(projectDto, project);
            SampleLotDto sampleLotDto = projectDto.getSampleLot();
            if (sampleLotDto != null) {
                SampleLot sampleLot = new SampleLot();
                BeanUtils.copyProperties(sampleLotDto, sampleLot);
                project.setSampleLot(sampleLot);
            }
        }
        return project;
    }

    @Override
    public Boolean hadDelivered(long projectId) {
        Boolean flag = null;
        Project one = projectRepository.findOne(projectId);
        if (one != null) {
            Integer projectStatus = one.getProjectStatus();
            if (projectStatus >= ProjectStatusEnum.DELIVERED.toCode()) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }
}

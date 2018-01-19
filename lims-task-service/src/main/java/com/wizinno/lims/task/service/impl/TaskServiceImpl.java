package com.wizinno.lims.task.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.wizinno.lims.common.data.*;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.security.UserContext;
import com.wizinno.lims.common.util.CommonUtil;
import com.wizinno.lims.project.domain.Job;
import com.wizinno.lims.project.domain.Project;
import com.wizinno.lims.project.domain.Sample;
import com.wizinno.lims.project.service.JobService;
import com.wizinno.lims.project.service.ProjectService;
import com.wizinno.lims.project.service.SampleService;
import com.wizinno.lims.project.service.condition.SampleCondition;
import com.wizinno.lims.project.service.dto.JobDto;
import com.wizinno.lims.project.service.dto.ProjectDto;
import com.wizinno.lims.project.service.dto.SampleDto;
import com.wizinno.lims.project.service.dto.SampleLotDto;
import com.wizinno.lims.task.domain.Task;
import com.wizinno.lims.task.domain.TaskSample;
import com.wizinno.lims.task.repository.TaskRepository;
import com.wizinno.lims.task.repository.TaskSampleRepository;
import com.wizinno.lims.task.service.TaskService;
import com.wizinno.lims.task.service.condition.TaskCondition;
import com.wizinno.lims.task.service.dto.TaskDto;
import com.wizinno.lims.task.service.dto.TaskSampleDto;
import com.wizinno.lims.tracking.service.TrackingService;
import com.wizinno.lims.tracking.service.dto.TrackingDto;
import com.wizinno.lims.user.service.UserService;
import com.wizinno.lims.user.service.dto.UserSimpleDto;
import com.wizinno.lims.workflow.cfg.domain.WfCfgWf;
import com.wizinno.lims.workflow.cfg.service.WorkflowCfgService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.*;
import org.hibernate.jpa.HibernateEntityManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

/**
 * @author LiuMei on 2017-07-18.
 */
@Service
public class TaskServiceImpl<T> implements TaskService<T> {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskSampleRepository taskSampleRepository;

    @Autowired
    private JobService jobService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SampleService sampleService;

    @Autowired
    private UserService userService;

    @Autowired
    private TrackingService trackingService;

    @Autowired
    private WorkflowCfgService workflowCfgService;

    protected HibernateEntityManager hEntityManager = null;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.hEntityManager = (HibernateEntityManager) entityManager;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<TaskDto> save(List<TaskDto> taskDTOs) {
        List<Task> save = taskRepository.save(taskDTOsToPO(taskDTOs));
        return tasksToDto(save);
    }

    @Override
    public TaskDto getById(long id) {
        return taskToDto((T) taskRepository.findOne(id));
    }

    @Override
    public PageData<TaskDto> getByCondition(TaskCondition taskCondition, Pageable pageable) {
        String projectNo = taskCondition.getProjectNo();
        Long taskId = taskCondition.getTaskId();
        Long operator = taskCondition.getOperator();
        Long projectId = taskCondition.getProjectId();
        String projectName = taskCondition.getProjectName();
        Integer projectStatus = taskCondition.getProjectStatus();
        Integer taskStatus = taskCondition.getTaskStatus();
        Session session = hEntityManager.getSession();
        Transaction transaction = session.beginTransaction();
        org.hibernate.Criteria criteria = session.createCriteria(Task.class);
        if (taskId != null) {
            criteria.add(Property.forName("id").eq(taskId));
        }
        if (taskStatus != null) {
            criteria.add(Property.forName("status").eq(taskStatus));
        }
        if(operator != null){
            criteria.add(Property.forName("operator").eq(operator));
        }
        if (projectId != null || StringUtils.isNotBlank(projectNo) || StringUtils.isNotBlank(projectName) || projectStatus != null) {
            criteria.createAlias("project", "p");
            if (projectId != null) {
                criteria.add(Property.forName("p.id").eq(projectId));
            }
            if (StringUtils.isNotBlank(projectNo)) {
                criteria.add(Property.forName("p.no").eq(projectNo));
            }
            if (StringUtils.isNotBlank(projectName)) {
                criteria.add(Property.forName("p.name").like(projectName, MatchMode.ANYWHERE));
            }
            if (projectStatus != null) {
                criteria.add(Property.forName("p.projectStatus").eq(projectStatus));
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
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.createAlias("job", "j");
        criteria.addOrder(Order.asc("j.type"));
        List<Task> content = criteria.list();
        transaction.commit();
        return new PageData(pageable.getPageNumber(), pageable.getPageSize(), tasksToDto(content), totalPages, totalElements);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void dispatchTask(long projectId, List<TaskDto> taskDTOs, List<Long> deleteList) throws CustomException {
        if (CollectionUtils.isNotEmpty(deleteList)) {
            for (Long id : deleteList) {
                trackingService.deleteByTaskId(id);
                taskSampleRepository.deleteByTaskId(id);
                taskRepository.delete(id);
            }
        }
        ProjectDto projectDto = projectService.getProjectById(projectId);
        SampleLotDto sampleLotDto = projectDto.getSampleLot();
        if (projectDto != null) {
            if (CollectionUtils.isNotEmpty(taskDTOs)) {
                List<TrackingDto> trackingDTOs = new ArrayList<>();
                TrackingDto trackingDto;
                SampleCondition sampleCondition = new SampleCondition();
                sampleCondition.setSampleLotId(sampleLotDto.getId());
                List<SampleDto> sampleDTOs = sampleService.getSamplesByCondition(sampleCondition);
                if (CollectionUtils.isNotEmpty(sampleDTOs)) {
                    long userId = UserContext.getLoginUserID();
                    Date now = new Date();
                    Set<JobDto> jobs = projectDto.getJobs();
                    Map<Long, List<SampleDto>> jobSamples = new HashMap<>(16);
                    //每个工作内容维护一个样本列表
                    for (JobDto jobDto : jobs) {
                        jobSamples.put(jobDto.getId(), sampleDTOs);
                    }
                    List<TaskSample> taskSamples;
                    List<SampleDto> jobSample;
                    List<TaskDto> afterTaskDto = new ArrayList<>();
                    for (TaskDto taskDto : taskDTOs) {
                        Long id = taskDto.getId();
                        if (id == null) {
                            taskDto.setCreateBy(userId);
                            taskDto.setCreateTime(now);
                            taskDto.setDefaultTask(false);
                        } else if (id != null) {
                            taskSampleRepository.deleteByTaskId(id);
                        }
                        taskDto.setUpdateBy(userId);
                        taskDto.setUpdateTime(now);
                        taskDto.setStatus(TaskStatusEnum.ALLOTTED.toCode());
                        taskDto.setProject(projectDto);
                        taskDto.setWorkflow(workflowCfgService.getById(taskDto.getWorkflow().getId()));
                        taskDto.setTaskAllotTime(now);
                        JobDto job = taskDto.getJob();
                        Task task = taskRepository.save((Task)taskDtoToPO(taskDto));
                        taskDto = taskToDto((T) task);
                        trackingDto = new TrackingDto();
                        trackingDto.setProject(projectDto);
                        trackingDto.setSampleLot(sampleLotDto);
                        trackingDto.setTask(taskDto);
                        trackingDto.setType(TrackingTypeEnum.TASK.toCode());
                        trackingDto.setOperate(TrackingOperateEnum.DISPATCH.toCode());
                        trackingDto.setCreateTime(now);
                        trackingDto.setCreateBy(userId);
                        trackingDTOs.add(trackingDto);

                        afterTaskDto.add(taskDto);
                        jobSample = new ArrayList<>();
                        jobSample.addAll(jobSamples.get(job.getId()));
                        taskSamples = new ArrayList<>();
                        Integer sampleAmount = taskDto.getSampleAmount();
                        TaskSample taskSample;
                        //每次从对应工作内容样本列表里取第一个元素,设置好之后删除取过的元素
                        for (int i = 0; i < sampleAmount; i++) {
                            taskSample = new TaskSample();
                            taskSample.setTask(task);
                            Sample sample = new Sample();
                            BeanUtils.copyProperties(jobSample.get(0), sample);
                            taskSample.setSample(sample);
                            jobSample.remove(jobSample.get(0));
                            taskSample.setCreateBy(userId);
                            taskSample.setUpdateBy(userId);
                            taskSample.setCreateTime(now);
                            taskSample.setUpdateTime(now);
                            taskSamples.add(taskSample);
                        }
                        //将一个任务之后剩余的样本重新放回列表,供下一个任务使用
                        jobSamples.put(job.getId(), jobSample);
                        taskSampleRepository.save(taskSamples);
                    }
                    //按任务类型排序
                    Collections.sort(afterTaskDto);
                    //输入顺序和输出顺序相同
                    Map<Integer, TreeSet<TaskDto>> jobTask = new LinkedHashMap<>();
                    //按任务类型分组
                    for (TaskDto taskDto : afterTaskDto) {
                        Integer type = taskDto.getJob().getType();
                        TreeSet<TaskDto> tasks = jobTask.get(type);
                        if (tasks == null) {
                            tasks = new TreeSet<>();
                        }
                        tasks.add(taskDto);
                        jobTask.put(type, tasks);
                    }
                    List<Map.Entry> jobTaskList = new ArrayList<>();
                    Set<Map.Entry<Integer, TreeSet<TaskDto>>> entries = jobTask.entrySet();
                    for (Map.Entry entry : entries) {
                        //LinkedHashMap包装为list方便下标访问
                        jobTaskList.add(entry);
                    }
                    JSONArray jsonArray;
                    //最终数据列表
                    List<TaskDto> finalData = new ArrayList<>();
                    for (int i = 1; i < jobTaskList.size(); i++) {
                        jsonArray = new JSONArray();
                        //获取上一个工作内容任务ID列表
                        Map.Entry preEntry = jobTaskList.get(i - 1);
                        TreeSet<TaskDto> preTasks = (TreeSet<TaskDto>) preEntry.getValue();
                        for (TaskDto preTask : preTasks) {
                            jsonArray.add(preTask.getId());
                        }
                        //获取当前任务列表
                        Map.Entry currentEntry = jobTaskList.get(i);
                        TreeSet<TaskDto> currentValue = (TreeSet<TaskDto>) currentEntry.getValue();
                        for (TaskDto currentTask : currentValue) {
                            //设置当前任务前置任务ID列表为上一个工作内容任务ID列表
                            currentTask.setPreId(jsonArray.toJSONString());
                            finalData.add(currentTask);
                        }
                    }
                    save(finalData);
                    Integer status = taskRepository.selectMinStatusByProjectId(projectId);
                    if (TaskStatusEnum.ALLOTTED.toCode().equals(status)) {
                        Integer projectStatus = projectDto.getProjectStatus();
                        if (!projectStatus.equals(ProjectStatusEnum.SCHEDULED.toCode())) {
                            projectService.updateProjectStatus(projectId, ProjectStatusEnum.SCHEDULED.toCode());
                        }
                        trackingDto = new TrackingDto();
                        trackingDto.setProject(projectDto);
                        trackingDto.setSampleLot(sampleLotDto);
                        trackingDto.setType(TrackingTypeEnum.PROJECT.toCode());
                        trackingDto.setOperate(TrackingOperateEnum.DISPATCH.toCode());
                        trackingDto.setCreateTime(now);
                        trackingDto.setCreateBy(userId);
                        trackingDTOs.add(trackingDto);
                    }
                    trackingService.addBatchTracking(trackingDTOs);
                }
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTaskByProjectId(long projectId) {
        List<Task> tasks = taskRepository.getByProjectId(projectId);
        if (tasks != null && tasks.size() > 0) {
            for (Task task : tasks) {
                trackingService.deleteByTaskId(task.getId());
            }
        }
        taskRepository.deleteByProjectId(projectId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTaskSampleByProjectId(long projectId) {
        taskSampleRepository.deleteByProjectId(projectId);
    }

    private List<TaskDto> tasksToDto(List<Task> tasks) {
        List<TaskDto> taskDTOs = null;
        if (CollectionUtils.isNotEmpty(tasks)) {
            taskDTOs = new ArrayList<>();
            for (Task task : tasks) {
                taskDTOs.add(taskToDto((T) task));
            }
        }
        return taskDTOs;
    }

    @Override
    public TaskDto taskToDto(T data) {
        TaskDto taskDto = null;
        if (data != null) {
            Task task = (Task) data;
            taskDto = new TaskDto();
            BeanUtils.copyProperties(task, taskDto);
            Job job = task.getJob();
            JobDto jobDto = jobService.jobToDto(job);
            taskDto.setJob(jobDto);
            taskDto.setStatusDesc(TaskStatusEnum.getNameByCode(taskDto.getStatus()));
            Long operator = task.getOperator();
            if (operator != null) {
                taskDto.setOperator(userService.findSimpleById(operator));
            }
            Long allotOperator = task.getAllotOperator();
            if (allotOperator != null) {
                taskDto.setAllotOperator(userService.findSimpleById(allotOperator));
            }
            taskDto.setProject(projectService.projectSimpleToDto(task.getProject()));
            taskDto.setWorkflow(workflowCfgService.wfCfgWfPoToDto(task.getWorkflow()));
        }
        return taskDto;
    }

    @Override
    public T taskDtoToPO(TaskDto taskDto) {
        Task task = null;
        if (taskDto != null) {
            task = new Task();
            BeanUtils.copyProperties(taskDto, task);
            JobDto job = taskDto.getJob();
            UserSimpleDto operator = taskDto.getOperator();
            if (operator != null) {
                task.setOperator(operator.getId());
            }
            ProjectDto projectDto = taskDto.getProject();
            job.setProject(projectDto);
            task.setJob((Job) jobService.jobDtoToPO(job));
            task.setProject((Project) projectService.projectDtoSimpleToPO(projectDto));
            task.setWorkflow((WfCfgWf) workflowCfgService.wfCfgWfDtoToPo(taskDto.getWorkflow()));
            task.setAllotOperator(taskDto.getUpdateBy());
            taskSamplesDtoToPO(taskDto.getTaskSamples());
        }
        return (T) task;
    }

    private List<Task> taskDTOsToPO(List<TaskDto> taskDTOs) {
        List<Task> tasks = null;
        if (CollectionUtils.isNotEmpty(taskDTOs)) {
            tasks = new ArrayList<>();
            for (TaskDto taskDto : taskDTOs) {
                tasks.add((Task) taskDtoToPO(taskDto));
            }
        }
        return tasks;
    }

    private TaskSample taskSampleDtoToPO(TaskSampleDto taskSampleDto) {
        TaskSample taskSample = null;
        if (taskSampleDto != null) {
            taskSample = new TaskSample();
            BeanUtils.copyProperties(taskSampleDto, taskSample);
            TaskDto taskDto = taskSampleDto.getTask();
            if (taskDto != null) {
                Task task = new Task();
                BeanUtils.copyProperties(taskDto, task);
                taskSample.setTask(task);
            }
            SampleDto sampleDto = taskSampleDto.getSample();
            if (sampleDto != null) {
                Sample sample = new Sample();
                BeanUtils.copyProperties(sampleDto, sample);
                taskSample.setSample(sample);
            }
        }
        return taskSample;
    }

    private List<TaskSample> taskSamplesDtoToPO(List<TaskSampleDto> taskSampleDTOs) {
        List<TaskSample> taskSamples = null;
        if (CollectionUtils.isNotEmpty(taskSampleDTOs)) {
            taskSamples = new ArrayList<>();
            for (TaskSampleDto taskSampleDto : taskSampleDTOs) {
                taskSamples.add(taskSampleDtoToPO(taskSampleDto));
            }
        }
        return taskSamples;
    }
}

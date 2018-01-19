package com.wizinno.lims.project.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.wizinno.lims.activ.service.ActivService;
import com.wizinno.lims.activ.service.util.SpringContextUtils;
import com.wizinno.lims.common.data.*;
import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.common.security.UserContext;
import com.wizinno.lims.common.util.CommonUtil;
import com.wizinno.lims.common.util.HibernateUtil;
import com.wizinno.lims.project.domain.Job;
import com.wizinno.lims.project.domain.Project;
import com.wizinno.lims.project.domain.Task;
import com.wizinno.lims.project.repository.SubTaskSampleRepository;
import com.wizinno.lims.project.repository.TaskRepository;
import com.wizinno.lims.project.service.*;
import com.wizinno.lims.project.service.condition.TaskCondition;
import com.wizinno.lims.project.service.dto.*;
import com.wizinno.lims.tracking.service.TrackingService;
import com.wizinno.lims.tracking.service.dto.TrackingDto;
import com.wizinno.lims.user.service.UserService;
import com.wizinno.lims.user.service.dto.UserSimpleDto;
import com.wizinno.lims.workflow.cfg.domain.CfgWf;
import com.wizinno.lims.workflow.cfg.service.WorkflowCfgService;
import com.wizinno.lims.workflow.cfg.service.WorkflowTransService;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfActivDto;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfDto;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfTransDto;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author LiuMei on 2017-07-18.
 */
@Service
public class TaskServiceImpl<T> implements TaskService<T> {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private JobService jobService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private TrackingService trackingService;

    @Autowired
    private WorkflowCfgService workflowCfgService;

    @Autowired
    private WorkflowTransService workflowTransService;

    @Autowired
    private SubTaskService subTaskService;

    @Autowired
    private SubTaskSampleService subTaskSampleService;

    @Autowired
    private SubTaskSampleRepository subTaskSampleRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<TaskDto> save(List<TaskDto> taskDTOs) {
        List<Task> save = taskRepository.save(taskDTOsToPO(taskDTOs));
        return tasksToDto(save);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TaskDto save(TaskDto taskDto) {
        Task task = taskRepository.save((Task) taskDtoToPO(taskDto));
        return taskToDto((T) task);
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
        Session session = HibernateUtil.getSession();
        org.hibernate.Criteria criteria = session.createCriteria(Task.class);
        if (taskId != null) {
            criteria.add(Property.forName("id").eq(taskId));
        }
        if (taskStatus != null) {
            criteria.add(Property.forName("status").eq(taskStatus));
        }
        if (operator != null) {
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
        return new PageData(pageable.getPageNumber(), pageable.getPageSize(), tasksToDto(content), totalPages, totalElements);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void dispatchTask(long projectId, List<TaskDto> taskDTOs, List<Long> deleteList) throws CustomException {
        deleteTaskByIdList(deleteList);
        ProjectDto projectDto = projectService.getProjectById(projectId);
        SampleLotDto sampleLotDto = projectDto.getSampleLot();
        if (projectDto != null) {
            if (CollectionUtils.isNotEmpty(taskDTOs)) {
                List<TrackingDto> trackingDTOs = new ArrayList<>();
                TrackingDto trackingDto;
                long userId = UserContext.getLoginUserID();
                Date now = new Date();
                List<TaskDto> afterTaskDto = new ArrayList<>();
                for (TaskDto taskDto : taskDTOs) {
                    Long id = taskDto.getId();
                    Long workflowId = taskDto.getWorkflow().getId();
                    workflowCfgService.getById(workflowId);
                    if (id == null) {
                        taskDto.setCreateBy(userId);
                        taskDto.setCreateTime(now);
                        taskDto.setDefaultTask(false);
                        taskDto.setStatus(TaskStatusEnum.ALLOTTED.toCode());
                        taskDto.setProject(projectDto);
                        taskDto.setWorkflow(workflowCfgService.getById(workflowId));
                        taskDto.setTaskAllotTime(now);
                        taskDto.setAllotOperator(userService.findSimpleById(userId));
                        Task task = taskRepository.save((Task) taskDtoToPO(taskDto));
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
                    } else {
                        TaskDto dbTask = getById(id);
                        Integer sampleAmount = taskDto.getSampleAmount();
                        Integer dbSampleAmount = dbTask.getSampleAmount();
                        Integer planLaborHour = taskDto.getPlanLaborHour();
                        Integer dbPlanLaborHour = dbTask.getPlanLaborHour();
                        Date planStartTime = taskDto.getPlanStartTime();
                        Date dbPlanStartTime = dbTask.getPlanStartTime();
                        Date planCompleteTime = taskDto.getPlanCompleteTime();
                        Date dbPlanCompleteTime = dbTask.getPlanCompleteTime();
                        Integer status = dbTask.getStatus();
                        Long operator = taskDto.getOperator().getId();
                        String note = taskDto.getNote();
                        Long dbOperator = null;
                        Long dbWorkflowId = null;
                        String dbNote = null;
                        if (status.equals(TaskStatusEnum.ALLOTTED.toCode())) {
                            dbOperator = dbTask.getOperator().getId();
                            dbWorkflowId = dbTask.getWorkflow().getId();
                            dbNote = dbTask.getNote();
                        }
                        if (!sampleAmount.equals(dbSampleAmount) || !planLaborHour.equals(dbPlanLaborHour) || !planStartTime.equals(dbPlanStartTime)
                                || !planCompleteTime.equals(dbPlanCompleteTime) || !operator.equals(dbOperator) || !note.equals(dbNote) || !workflowId.equals(dbWorkflowId)) {
                            //原有记录有更改
                            dbTask.setSampleAmount(sampleAmount);
                            dbTask.setPlanLaborHour(planLaborHour);
                            dbTask.setPlanStartTime(planStartTime);
                            dbTask.setPlanCompleteTime(planCompleteTime);
                            dbTask.setOperator(userService.findSimpleById(operator));
                            dbTask.setNote(dbNote);
                            dbTask.setUpdateBy(userId);
                            dbTask.setUpdateTime(now);
                            dbTask.setStatus(TaskStatusEnum.ALLOTTED.toCode());
                            dbTask.setWorkflow(workflowCfgService.getById(workflowId));
                            dbTask.setTaskAllotTime(now);
                            dbTask.setAllotOperator(userService.findSimpleById(userId));
                            taskRepository.save((Task) taskDtoToPO(dbTask));
                            trackingDto = new TrackingDto();
                            trackingDto.setProject(projectDto);
                            trackingDto.setSampleLot(sampleLotDto);
                            trackingDto.setTask(dbTask);
                            trackingDto.setType(TrackingTypeEnum.TASK.toCode());
                            trackingDto.setOperate(TrackingOperateEnum.DISPATCH.toCode());
                            trackingDto.setCreateTime(now);
                            trackingDto.setCreateBy(userId);
                            trackingDTOs.add(trackingDto);
                        }
                        afterTaskDto.add(dbTask);
                    }
                }
                //按任务类型排序
                Collections.sort(afterTaskDto);
                //确保输入顺序和输出顺序相同
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
                    trackingDto.setType(TrackingTypeEnum.PROJECT.toCode());
                    trackingDto.setSampleLot(sampleLotDto);
                    trackingDto.setOperate(TrackingOperateEnum.DISPATCH.toCode());
                    trackingDto.setCreateTime(now);
                    trackingDto.setCreateBy(userId);
                    trackingDTOs.add(trackingDto);
                }
                trackingService.addBatchTracking(trackingDTOs);
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTaskByProjectId(long projectId) {
        List<Task> tasks = taskRepository.getByProjectId(projectId);
        if (CollectionUtils.isNotEmpty(tasks)) {
            for (Task task : tasks) {
                trackingService.deleteByTaskId(task.getId());
            }
        }
        taskRepository.deleteByProjectId(projectId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTaskByIdList(List<Long> deleteIds) {
        if (CollectionUtils.isNotEmpty(deleteIds)) {
            for (Long id : deleteIds) {
                trackingService.deleteByTaskId(id);
                taskRepository.delete(id);
            }
        }
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
            CfgWf workflow = task.getWorkflow();
            if (workflow != null) {
                taskDto.setWorkflow(workflowCfgService.wfCfgWfPoToDto(workflow));
                taskDto.setCurrentSubTaskId(subTaskService.getLastSubTaskByTaskId(task.getId()));
            }
        }
        return taskDto;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void startTask(TaskDto taskDto) {
        Date now = new Date();
        Long userId = UserContext.getLoginUserID();
        taskDto.setActualStartTime(now);
        taskDto.setUpdateBy(userId);
        taskDto.setUpdateTime(now);
        taskDto.setStatus(TaskStatusEnum.UNDERWAY.toCode());
        save(taskDto);
        //创建task第一个活动节点的subTask实例
        CfgWfDto workflow = taskDto.getWorkflow();
        CfgWfTransDto wfTransDto = workflowTransService.getTransByFromActiv(workflow.getId(), null);
        CfgWfActivDto toActiv = wfTransDto.getToActiv();
        SubTaskDto subTaskDto = new SubTaskDto();
        subTaskDto.setCfgWfActiv(toActiv);
        subTaskDto.setCfgWf(workflow);
        subTaskDto.setTask(taskDto);
        subTaskDto.setWfVer(workflow.getVer());
        subTaskDto.setWfName(workflow.getName());
        subTaskDto.setActivVer(toActiv.getVer());
        subTaskDto.setActivName(toActiv.getName());
        subTaskDto.setOperator(userId);
        subTaskDto.setCreateBy(userId);
        subTaskDto.setUpdateBy(userId);
        subTaskDto.setCreateTime(now);
        subTaskDto.setUpdateTime(now);
        subTaskDto.setSampleCount(taskDto.getSampleAmount());
        subTaskDto.setFinishSampleCount(0);
        subTaskService.save(subTaskDto);
        //建立subTask-sample关系
        String javaClass = toActiv.getJavaClass();
        if(StringUtils.isBlank(javaClass)){
            throw new CustomException(CustomExceptionCode.CONFIG_ERROR);
        }
        ActivService activService = (ActivService) SpringContextUtils.getBeanByName(javaClass);
        List<SampleDto> executionSample = activService.getExecutionSample(subTaskDto);
        if (CollectionUtils.isNotEmpty(executionSample)) {
            List<SubTaskSampleDto> subTaskSampleDtoList = new ArrayList<>();
            SubTaskSampleDto subTaskSampleDto;
            for (SampleDto sampleDto : executionSample) {
                subTaskSampleDto = new SubTaskSampleDto();
                subTaskSampleDto.setSample(sampleDto);
                subTaskSampleDto.setSubTask(subTaskDto);
                subTaskSampleDto.setJob(taskDto.getJob());
                subTaskSampleDtoList.add(subTaskSampleDto);
            }
            subTaskSampleService.save(subTaskSampleDtoList);
        }
    }

    @Override
    public Boolean taskCanFinish(TaskDto taskDto) {
        Boolean flag = false;
        if (taskDto != null) {
            Integer status = taskDto.getStatus();
            if (!status.equals(TaskStatusEnum.UNDERWAY.toCode())) {
                flag = false;
            } else {
                Long currentSubTaskId = taskDto.getCurrentSubTaskId();
                SubTaskDto subTaskDto = subTaskService.getById(currentSubTaskId);
                Date endTime = subTaskDto.getEndTime();
                if (endTime == null) {
                    flag = false;
                } else {
                    //查询当前subTask是否有下一个走向,如果有说明任务还没有完成
                    CfgWfTransDto trans = workflowTransService.getTransByFromActiv(subTaskDto.getCfgWf().getId(), subTaskDto.getCfgWfActiv().getId());
                    if (trans != null) {
                        flag = false;
                    } else {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void completeTask(TaskDto taskDto) {
        Date now = new Date();
        Long userId = UserContext.getLoginUserID();
        taskDto.setStatus(TaskStatusEnum.COMPLETE.toCode());
        taskDto.setUpdateBy(userId);
        taskDto.setUpdateTime(now);
        taskDto.setActualCompleteTime(now);
        save(taskDto);
        //检查项目是否所有任务都已完成
        ProjectDto project = taskDto.getProject();
        Long projectId = project.getId();
        Long totalTask = taskRepository.countByProjectId(projectId);
        Long completeTask = taskRepository.countByProjectIdAndStatus(projectId, TaskStatusEnum.COMPLETE.toCode());
        if(totalTask.equals(completeTask)){
            projectService.updateProjectStatus(projectId,ProjectStatusEnum.COMPLETE.toCode());
        }
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
            task.setWorkflow((CfgWf) workflowCfgService.wfCfgWfDtoToPo(taskDto.getWorkflow()));
            task.setAllotOperator(taskDto.getUpdateBy());
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
}

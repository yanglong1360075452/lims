package com.wizinno.lims.task.api.vo;

import com.wizinno.lims.task.service.dto.TaskDto;

import java.util.List;

/**
 * @author LiuMei on 2017-08-04.
 */
public class DispatchVO {

    private List<TaskDto>  taskList;

    private List<Long> deleteList;

    public List<TaskDto> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<TaskDto> taskList) {
        this.taskList = taskList;
    }

    public List<Long> getDeleteList() {
        return deleteList;
    }

    public void setDeleteList(List<Long> deleteList) {
        this.deleteList = deleteList;
    }
}

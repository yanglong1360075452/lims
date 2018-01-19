package com.wizinno.lims.activ.service.dto;

import com.wizinno.lims.project.service.dto.SubTaskDto;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfActivDto;
import com.wizinno.lims.workflow.cfg.service.dto.CfgWfDto;

import java.util.List;

/**
 * 开启任务输入参数
 * @author LiuMei
 * @date 2017-11-17.
 */
public class StartInputDto {

    /**
     * 样本ID列表
     */
    private List<Long> sampleIds;

    /**
     * 工作流
     */
    private CfgWfDto wfCfgWf;

    /**
     * 活动
     */
    private CfgWfActivDto wfCfgActiv;

    /**
     * subTask
     */
    private SubTaskDto subTask;

    /**
     * 备注
     */
    private String note;

    /**
     * 提取方法
     */
    private Long extractMethod;

    public Long getExtractMethod() {
        return extractMethod;
    }

    public void setExtractMethod(Long extractMethod) {
        this.extractMethod = extractMethod;
    }

    public List<Long> getSampleIds() {
        return sampleIds;
    }

    public void setSampleIds(List<Long> sampleIds) {
        this.sampleIds = sampleIds;
    }

    public CfgWfDto getWfCfgWf() {
        return wfCfgWf;
    }

    public void setWfCfgWf(CfgWfDto wfCfgWf) {
        this.wfCfgWf = wfCfgWf;
    }

    public CfgWfActivDto getWfCfgActiv() {
        return wfCfgActiv;
    }

    public void setWfCfgActiv(CfgWfActivDto wfCfgActiv) {
        this.wfCfgActiv = wfCfgActiv;
    }

    public SubTaskDto getSubTask() {
        return subTask;
    }

    public void setSubTask(SubTaskDto subTask) {
        this.subTask = subTask;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

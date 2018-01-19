package com.wizinno.lims.tracking.domain;

import com.wizinno.lims.project.domain.Project;
import com.wizinno.lims.project.domain.Sample;
import com.wizinno.lims.project.domain.SampleLot;
import com.wizinno.lims.project.domain.Task;

import javax.persistence.*;
import java.util.Date;

/**
 * @author LiuMei on 2017-08-09.
 */
@Entity
@Table(name = "tracking")
public class Tracking {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer type;

    @Column(nullable = false)
    private Integer operate;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="project_id")
    private Project project;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="sample_lot_id")
    private SampleLot sampleLot;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="sample_id")
    private Sample sample;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="task_id")
    private Task task;

    private String note;

    @Column(nullable = false,name = "create_by")
    private Long createBy;

    @Column(name = "create_time",nullable = false)
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOperate() {
        return operate;
    }

    public void setOperate(Integer operate) {
        this.operate = operate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public SampleLot getSampleLot() {
        return sampleLot;
    }

    public void setSampleLot(SampleLot sampleLot) {
        this.sampleLot = sampleLot;
    }

    public Sample getSample() {
        return sample;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

package com.wizinno.lims.project.domain;

import javax.persistence.*;

/**
 * @author LiuMei on 2017-07-21.
 */
@Entity
@Table(name = "subtask_sample_r")
public class SubTaskSampleR{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * 冗余job,便于任务执行分配关系时匹配
     */
    @ManyToOne
    @JoinColumn(name = "job_id",nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "subtask_id",nullable = false)
    private SubTask subTask;

    @ManyToOne
    @JoinColumn(name = "sample_id",nullable = false)
    private Sample sample;

    public SubTask getSubTask() {
        return subTask;
    }

    public void setSubTask(SubTask subTask) {
        this.subTask = subTask;
    }

    public Sample getSample() {
        return sample;
    }

    public void setSample(Sample sample) {
        this.sample = sample;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

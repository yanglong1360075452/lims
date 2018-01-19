package com.wizinno.lims.activ.extract.domain;

import com.wizinno.lims.common.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author LiuMei
 * @date 2017-12-01.
 */
@Entity
@Table(name = "exec_extract")
public class ExecExtract extends BaseEntity {

    /**
     * 执行ID
     */
    @Column(name = "execution_id",nullable = false)
    private Long executionId;

    /**
     * 提取方法
     */
    @Column(name = "extract_method",nullable = false)
    private Long extractMethod;

    public Long getExecutionId() {
        return executionId;
    }

    public void setExecutionId(Long executionId) {
        this.executionId = executionId;
    }

    public Long getExtractMethod() {
        return extractMethod;
    }

    public void setExtractMethod(Long extractMethod) {
        this.extractMethod = extractMethod;
    }
}

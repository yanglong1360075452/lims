package com.wizinno.lims.workflow.cfg.service.dto;

/**
 *工作流简单信息
 * @author LiuMei
 * @date 2017-11-22.
 */
public class WfSimpleDto {

    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

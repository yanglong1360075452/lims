package com.wizinno.lims.log.service.condition;

/**
 * @author LiuMei on 2017-06-19.
 */
public class DataDictCondition {

    private Long parentId;

    private Long secondParentId;

    private Integer type;

    public Long getSecondParentId() {
        return secondParentId;
    }

    public void setSecondParentId(Long secondParentId) {
        this.secondParentId = secondParentId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

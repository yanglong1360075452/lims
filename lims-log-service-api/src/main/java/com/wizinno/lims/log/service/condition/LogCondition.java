package com.wizinno.lims.log.service.condition;

import java.util.Date;

/**
 * @author LiuMei on 2017-06-15.
 */
public class LogCondition {

    private Integer operateType;

    private Integer operate;

    private String description;

    private Long operator;

    private Date operateStartTime;

    private Date operateEndTime;

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public Integer getOperate() {
        return operate;
    }

    public void setOperate(Integer operate) {
        this.operate = operate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public Date getOperateStartTime() {
        return operateStartTime;
    }

    public void setOperateStartTime(Date operateStartTime) {
        this.operateStartTime = operateStartTime;
    }

    public Date getOperateEndTime() {
        return operateEndTime;
    }

    public void setOperateEndTime(Date operateEndTime) {
        this.operateEndTime = operateEndTime;
    }
}

package com.wizinno.lims.log.service.dto;

import com.wizinno.lims.user.service.dto.UserSimpleDto;

import java.util.Date;

/**
 * @author LiuMei on 2017-06-14.
 */
public class LogDto {

    private Long id;

    private Integer operateType;
    private String operateTypeDesc;

    private Integer operate;
    private String operateDesc;

    private String description;

    private Long operateObjectId;

    private Long operator;

    private UserSimpleDto operatorUser;

    private Date operateTime;

    private String ip;

    public UserSimpleDto getOperatorUser() {
        return operatorUser;
    }

    public void setOperatorUser(UserSimpleDto operatorUser) {
        this.operatorUser = operatorUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public String getOperateTypeDesc() {
        return operateTypeDesc;
    }

    public void setOperateTypeDesc(String operateTypeDesc) {
        this.operateTypeDesc = operateTypeDesc;
    }

    public Integer getOperate() {
        return operate;
    }

    public void setOperate(Integer operate) {
        this.operate = operate;
    }

    public String getOperateDesc() {
        return operateDesc;
    }

    public void setOperateDesc(String operateDesc) {
        this.operateDesc = operateDesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOperateObjectId() {
        return operateObjectId;
    }

    public void setOperateObjectId(Long operateObjectId) {
        this.operateObjectId = operateObjectId;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

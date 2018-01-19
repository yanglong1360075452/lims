package com.wizinno.lims.log.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author LiuMei on 2017-06-13.
 */

@Entity
@Table(name = "log")
public class Log {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false,name = "operate_type")
    private Integer operateType;

    @Column(nullable = false)
    private Integer operate;

    @Column(columnDefinition="TEXT")
    private String description;

    @Column(name = "operate_object_id")
    private Long operateObjectId;

    @Column(nullable = false)
    private Long operator;

    @Column(nullable = false,name = "operate_time")
    private Date operateTime;

    @Column(nullable = false)
    private String ip;

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

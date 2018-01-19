package com.wizinno.lims.activ.extract.dto;

import com.wizinno.lims.user.service.dto.UserSimpleDto;

import java.util.Date;

/**
 * @author LiuMei
 * @date 2017-12-01.
 */
public class ExtractSampleDto {

    private Long id;

    private String no;

    private String name;

    private Long extractCategory;
    private String extractCategoryDesc;

    private Long extractType;
    private String extractTypeDesc;

    private Long extractMethod;
    private String extractMethodDesc;

    private Integer status;
    private String statusDesc;

    private Date operateTime;

    private UserSimpleDto operator;

    private String note;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtractCategoryDesc() {
        return extractCategoryDesc;
    }

    public void setExtractCategoryDesc(String extractCategoryDesc) {
        this.extractCategoryDesc = extractCategoryDesc;
    }

    public String getExtractTypeDesc() {
        return extractTypeDesc;
    }

    public void setExtractTypeDesc(String extractTypeDesc) {
        this.extractTypeDesc = extractTypeDesc;
    }

    public String getExtractMethodDesc() {
        return extractMethodDesc;
    }

    public void setExtractMethodDesc(String extractMethodDesc) {
        this.extractMethodDesc = extractMethodDesc;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public UserSimpleDto getOperator() {
        return operator;
    }

    public void setOperator(UserSimpleDto operator) {
        this.operator = operator;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getExtractCategory() {
        return extractCategory;
    }

    public void setExtractCategory(Long extractCategory) {
        this.extractCategory = extractCategory;
    }

    public Long getExtractType() {
        return extractType;
    }

    public void setExtractType(Long extractType) {
        this.extractType = extractType;
    }

    public Long getExtractMethod() {
        return extractMethod;
    }

    public void setExtractMethod(Long extractMethod) {
        this.extractMethod = extractMethod;
    }
}

package com.wizinno.lims.project.service.condition;

import java.util.Date;
import java.util.List;

/**
 * @author LiuMei on 2017-06-16.
 */
public class ProjectCondition {

    private List<Integer> projectStatus;

    private String projectNo;

    private String projectName;

    private Date createTime;

    private Integer productStatus;

    private String sampleLotNo;

    private String sampleLotDesc;

    public String getSampleLotDesc() {
        return sampleLotDesc;
    }

    public void setSampleLotDesc(String sampleLotDesc) {
        this.sampleLotDesc = sampleLotDesc;
    }

    public String getSampleLotNo() {
        return sampleLotNo;
    }

    public void setSampleLotNo(String sampleLotNo) {
        this.sampleLotNo = sampleLotNo;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public List<Integer> getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(List<Integer> projectStatus) {
        this.projectStatus = projectStatus;
    }
}

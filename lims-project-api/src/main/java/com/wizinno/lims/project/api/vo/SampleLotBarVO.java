package com.wizinno.lims.project.api.vo;

/**
 * @author LiuMei on 2017-06-30.
 */
public class SampleLotBarVO {

    private Long id;

    /**
     * 编号
     */
    private String no;

    /**
     * 样本类别
     */
    private Long sampleCategory;
    private String sampleCategoryDesc;

    /**
     * 保存形式
     */
    private Long saveWay;
    private String saveWayDesc;

    @Override
    public String toString() {
        return "SampleLotBarVO{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", sampleCategory=" + sampleCategory +
                ", sampleCategoryDesc='" + sampleCategoryDesc + '\'' +
                ", saveWay=" + saveWay +
                ", saveWayDesc='" + saveWayDesc + '\'' +
                '}';
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

    public String getSampleCategoryDesc() {
        return sampleCategoryDesc;
    }

    public void setSampleCategoryDesc(String sampleCategoryDesc) {
        this.sampleCategoryDesc = sampleCategoryDesc;
    }

    public String getSaveWayDesc() {
        return saveWayDesc;
    }

    public void setSaveWayDesc(String saveWayDesc) {
        this.saveWayDesc = saveWayDesc;
    }

    public Long getSampleCategory() {
        return sampleCategory;
    }

    public void setSampleCategory(Long sampleCategory) {
        this.sampleCategory = sampleCategory;
    }

    public Long getSaveWay() {
        return saveWay;
    }

    public void setSaveWay(Long saveWay) {
        this.saveWay = saveWay;
    }
}

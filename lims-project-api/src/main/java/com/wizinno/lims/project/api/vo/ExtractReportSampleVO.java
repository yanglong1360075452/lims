package com.wizinno.lims.project.api.vo;

/**
 * @author LiuMei
 * @date 2017-11-20.
 */
public class ExtractReportSampleVO {

    /**
     * 原始样本编号
     */
    private String no;

    /**
     * 原始样本名称
     */
    private String name;

    /**
     * 提取出的样本是否合格
     */
    private Boolean qualified;

    /**
     * 不合格原因
     */
    private String disqualifiedReason;

    @Override
    public String toString() {
        return "ExtractReportSampleVO{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", qualified=" + qualified +
                ", disqualifiedReason='" + disqualifiedReason + '\'' +
                '}';
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

    public Boolean getQualified() {
        return qualified;
    }

    public void setQualified(Boolean qualified) {
        this.qualified = qualified;
    }

    public String getDisqualifiedReason() {
        return disqualifiedReason;
    }

    public void setDisqualifiedReason(String disqualifiedReason) {
        this.disqualifiedReason = disqualifiedReason;
    }
}

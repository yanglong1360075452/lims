package com.wizinno.lims.common.data;

/**
 * @author LiuMei on 2017-06-14.
 */
public enum TrackingTypeEnum {
    /**
     * 项目
     */
    PROJECT(1,"项目"),
    /**
     * 样本批次
     */
    SAMPLE_LOT(2,"样本批次"),
    /**
     * 样本
     */
    SAMPLE(3,"样本"),
    /**
     * 任务
     */
    TASK(4,"任务"),
    ;


    private Integer nCode;

    private String name;


    TrackingTypeEnum(Integer code, String name) {
        this.nCode = code;
        this.name = name;
    }

    public Integer toCode() {
        return this.nCode;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static TrackingTypeEnum valueOf(Integer code) {
        for (TrackingTypeEnum logOperateType : TrackingTypeEnum.values()) {
            if (logOperateType.toCode().equals(code)) {
                return logOperateType;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (TrackingTypeEnum logOperateType : TrackingTypeEnum.values()) {
            if (logOperateType.toCode().equals(code)) {
                return logOperateType.toString();
            }
        }
        return null;
    }

}

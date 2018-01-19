package com.wizinno.lims.common.data;

/**
 * @author LiuMei on 2017-06-14.
 */
public enum LogOperateTypeEnum {

    /**
     * 登录
     */
    LOGIN(1, "登录"),
    /**
     * 用户
     */
    USER(2, "用户"),
    /**
     * 角色
     */
    ROLE(3, "角色"),
    /**
     * 项目
     */
    PROJECT(4,"项目"),
    /**
     * 样本批次
     */
    SAMPLE_LOT(5,"样本批次"),
    /**
     * 样本
     */
    SAMPLE(6,"样本"),
    /**
     * 任务
     */
    TASK(7,"任务"),

    /**
     * 子节点
     */
    SUB_TASK(8,"子任务"),
    ;

    private Integer nCode;

    private String name;

    LogOperateTypeEnum(Integer code, String name) {
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

    public static LogOperateTypeEnum valueOf(Integer code) {
        for (LogOperateTypeEnum logOperateTypeEnum : LogOperateTypeEnum.values()) {
            if (logOperateTypeEnum.toCode().equals(code)) {
                return logOperateTypeEnum;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (LogOperateTypeEnum logOperateTypeEnum : LogOperateTypeEnum.values()) {
            if (logOperateTypeEnum.toCode().equals(code)) {
                return logOperateTypeEnum.toString();
            }
        }
        return null;
    }

}

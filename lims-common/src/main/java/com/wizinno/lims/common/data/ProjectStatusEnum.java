package com.wizinno.lims.common.data;

/**
 * @author LiuMei on 2017-06-15.
 *
 * 项目状态
 */
public enum ProjectStatusEnum {
    /**
     * 新项目
     */
    NEW_PROJECT(1, "新项目"),
    /**
     * 样本送达
     */
    SAMPLE_DELIVERY(2, "样本送达"),
    /**
     * 已交付生产
     */
    DELIVERED(3, "已交付生产"),
    /**
     * 已调度
     */
    SCHEDULED(4, "已调度"),
    /**
     * 生产进行中
     */
    IN_THE_PRODUCTION (5, "生产进行中"),
    /**
     * 项目暂停
     */
    PAUSE(6, "项目暂停"),
    /**
     * 项目完成
     */
    COMPLETE(7, "项目完成"),
    /**
     * 项目终止
     */
    TERMINATION(8, "项目终止"),
    /**
     * 项目取消
     */
    CANCEL(9, "项目取消"),
    ;

    private Integer nCode;

    private String name;


    ProjectStatusEnum(Integer code, String name) {
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

    public static ProjectStatusEnum valueOf(Integer code) {
        for (ProjectStatusEnum projectStatusEnum : ProjectStatusEnum.values()) {
            if (projectStatusEnum.toCode().equals(code)) {
                return projectStatusEnum;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (ProjectStatusEnum projectStatusEnum : ProjectStatusEnum.values()) {
            if (projectStatusEnum.toCode().equals(code)) {
                return projectStatusEnum.toString();
            }
        }
        return null;
    }
    
}

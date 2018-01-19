package com.wizinno.lims.common.data;

/**
 * @author LiuMei on 2017-07-24.
 */
public enum TaskStatusEnum {

    /**
     * 未分配
     */
    NOT_ALLOT(1, "未分配"),
    /**
     * 已分配
     */
    ALLOTTED(2, "已分配"),
    /**
     * 进行中
     */
    UNDERWAY(3, "进行中"),
    /**
     * 完成
     */
    COMPLETE(4, "完成"),
    /**
     * 暂停
     */
    PAUSE(5, "暂停"),
    /**
     * 终止
     */
    TERMINATION(6, "终止"),
            ;

    private Integer code;

    private String name;


    TaskStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer toCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static TaskStatusEnum valueOf(Integer code) {
        for (TaskStatusEnum taskStatusEnum : TaskStatusEnum.values()) {
            if (taskStatusEnum.toCode().equals(code)) {
                return taskStatusEnum;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (TaskStatusEnum taskStatusEnum : TaskStatusEnum.values()) {
            if (taskStatusEnum.toCode().equals(code)) {
                return taskStatusEnum.toString();
            }
        }
        return null;
    }

}

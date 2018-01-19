package com.wizinno.lims.common.data;

/**
 * @author LiuMei on 2017-06-14.
 */
public enum LogOperateEnum {

    /**
     * 登录成功
     */
    LOGIN_SUCCESS(1, "登录成功"),
    /**
     * 登录失败
     */
    LOGIN_FAIL(2, "登录失败"),
    /**
     * 登出
     */
    LOGOUT(3, "登出"),
    /**
     * 新建用户
     */
    USER_CREATE(4, "新建用户"),
    /**
     * 修改用户信息
     */
    USER_UPDATE(5, "修改用户信息"),
    /**
     * 修改用户状态
     */
    USER_STATUS(6, "修改用户状态"),
    /**
     * 重置密码
     */
    RESET_PASSWORD(7, "重置密码"),
    /**
     * 新建角色
     */
    ROLE_CREATE(8, "新建角色"),
    /**
     * 修改角色
     */
    ROLE_UPDATE(9, "修改角色"),
    /**
     * 删除角色
     */
    ROLE_DELETE(10, "删除角色"),
    /**
     * 新建项目
     */
    PROJECT_CREATE(11, "新建项目"),
    /**
     * 修改项目
     */
    PROJECT_UPDATE(12, "修改项目"),
    /**
     * 添加样本批次
     */
    SAMPLE_LOT_ADD(13, "添加样本批次"),
    /**
     * 修改样本批次
     */
    SAMPLE_LOT_UPDATE(14, "修改样本批次"),
    /**
     * 添加样本
     */
    SAMPLE_ADD(15, "添加样本"),
    /**
     * 编辑样本
     */
    SAMPLE_UPDATE(16, "编辑样本"),
    /**
     * 删除样本
     */
    SAMPLE_DELETE(17, "删除样本"),
    /**
     * 接收样本
     */
    SAMPLE_RECEIVE(18, "接收样本"),
    /**
     * 退回样本
     */
    SAMPLE_REJECT(19, "退回样本"),
    /**
     * 交付生产
     */
    PROJECT_DELIVERY(20, "交付生产"),
    /**
     * 任务调度
     */
    TASK_DISPATCH(21, "任务调度"),
    /**
     * 取消项目
     */
    PROJECT_CANCEL(22, "取消项目"),
    /**
     * 恢复项目
     */
    PROJECT_RECOVER(23, "恢复项目"),
    /**
     * 取消生产
     */
    CANCEL_PRODUCE(24, "取消生产"),
    /**
     * 开始任务
     */
    TASK_START(25, "开始任务"),
    /**
     *任务完成
     */
    TASK_FINISH(26, "任务完成"),
    /**
     *任务暂停
     */
    TASK_PAUSE(27, "任务暂停"),
    /**
     *任务继续
     */
    TASK_GOON(28, "任务继续"),
    /**
     *任务终止
     */
    TASK_TERMINATION(29, "任务终止"),
    /**
     * 开始子任务
     */
    SUB_TASK_START(30, "开始子任务"),
    /**
     * 结束子任务
     */
    SUB_TASK_END(31, "结束子任务"),
    ;
    private Integer nCode;

    private String name;

    LogOperateEnum(Integer code, String name) {
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

    public static LogOperateEnum valueOf(Integer code) {
        for (LogOperateEnum logOperateEnum : LogOperateEnum.values()) {
            if (logOperateEnum.toCode().equals(code)) {
                return logOperateEnum;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (LogOperateEnum logOperateEnum : LogOperateEnum.values()) {
            if (logOperateEnum.toCode().equals(code)) {
                return logOperateEnum.toString();
            }
        }
        return null;
    }

}

package com.wizinno.lims.common.data;

/**
 * @author LiuMei on 2017-06-14.
 */
public enum TrackingOperateEnum {
    /**
     * 新建项目
     */
    PROJECT_CREATE(1,"新建项目"),
    /**
     * 修改项目信息
     */
    PROJECT_UPDATE(2,"修改项目信息"),
    /**
     * 取消项目
     */
    PROJECT_CANCEL(3,"取消项目"),
    /**
     * 恢复项目
     */
    RECOVER_PROJECT(4,"恢复项目"),
    /**
     * 样本接收
     */
    SAMPLE_RECEIVE(5,"样本接收"),
    /**
     * 样本退回
     */
    SAMPLE_REJECTION(6,"样本退回"),
    /**
     * 交付生产
     */
    PROJECT_DELIVERY(7,"交付生产"),
    /**
     * 取消生产
     */
    CANCEL_PRODUCE(8,"取消生产"),
    /**
     * 调度
     */
    DISPATCH(9,"调度"),
    /**
     * 样本入库
     */
    SAMPLE_IN_STORAGE(10,"样本入库"),
    /**
     * 样本出库
     */
    SAMPLE_OUT_STORAGE(11,"样本出库"),
    /**
     * 样本销毁
     */
    SAMPLE_DESTROY(12,"样本销毁"),
    /**
     * 开始生产
     */
    START_PRODUCE(13,"开始生产"),
    /**
     * 暂停生产
     */
    PAUSE_PRODUCE(14,"暂停生产"),
    /**
     * 恢复生产
     */
    RECOVER_PRODUCE(15,"恢复生产"),
    /**
     * 终止生产
     */
    TERMINATION_PRODUCE(16,"终止生产"),
    /**
     * 添加样本批次
     */
    SAMPLE_LOT_ADD(17,"添加样本批次"),
    /**
     * 修改样本批次信息
     */
    SAMPLE_LOT_UPDATE(18,"修改样本批次信息"),
    /**
     * 添加样本
     */
    SAMPLE_ADD(19,"添加样本"),
    /**
     * 修改样本信息
     */
    SAMPLE_UPDATE(20,"修改样本信息"),
    /**
     * 生成任务
     */
    TASK_GENERATE(21,"生成任务"),
    /**
     * 删除样本
     */
    SAMPLE_DELETE(22,"删除样本"),
    ;

    private Integer nCode;

    private String name;


    TrackingOperateEnum(Integer code, String name) {
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

    public static TrackingOperateEnum valueOf(Integer code) {
        for (TrackingOperateEnum logOperate : TrackingOperateEnum.values()) {
            if (logOperate.toCode().equals(code)) {
                return logOperate;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (TrackingOperateEnum logOperate : TrackingOperateEnum.values()) {
            if (logOperate.toCode().equals(code)) {
                return logOperate.toString();
            }
        }
        return null;
    }
    
}

package com.wizinno.lims.common.data;

/**
 * @author LiuMei on 2017-07-21.
 *
 * 样本状态
 */
public enum SampleStatusEnum {

    /**
     * 已建档
     */
    BOOK_BUILDING(1, "已建档"),
    /**
     * 已接收
     */
    RECEIVED(2, "已接收"),
    /**
     * 已退回
     */
    REJECTION(3, "已退回"),
    /**
     * 库存中
     */
    HAD_STORAGE(4, "库存中"),
    /**
     * 使用中
     */
    USING(5, "使用中"),
    /**
     * 已生产
     */
    PRODUCED(6,"已生产"),
    /**
     * 已销毁
     */
    DESTROYED(7, "已销毁"),
    ;

    private Integer nCode;

    private String name;


    SampleStatusEnum(Integer code, String name) {
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

    public static SampleStatusEnum valueOf(Integer code) {
        for (SampleStatusEnum sampleStatusEnum : SampleStatusEnum.values()) {
            if (sampleStatusEnum.toCode().equals(code)) {
                return sampleStatusEnum;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (SampleStatusEnum sampleStatusEnum : SampleStatusEnum.values()) {
            if (sampleStatusEnum.toCode().equals(code)) {
                return sampleStatusEnum.toString();
            }
        }
        return null;
    }

}

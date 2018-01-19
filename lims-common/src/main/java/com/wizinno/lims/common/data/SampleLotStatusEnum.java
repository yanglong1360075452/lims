package com.wizinno.lims.common.data;

/**
 * @author LiuMei on 2017-06-20.
 */
public enum SampleLotStatusEnum {

    /**
     * 有效
     */
    VALID(1, "有效"),
    /**
     * 删除
     */
    DELETE(2, "删除"),
            ;

    private Integer nCode;

    private String name;


    SampleLotStatusEnum(Integer code, String name) {
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

    public static SampleLotStatusEnum valueOf(Integer code) {
        for (SampleLotStatusEnum sampleLotStatusEnum : SampleLotStatusEnum.values()) {
            if (sampleLotStatusEnum.toCode().equals(code)) {
                return sampleLotStatusEnum;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (SampleLotStatusEnum sampleLotStatusEnum : SampleLotStatusEnum.values()) {
            if (sampleLotStatusEnum.toCode().equals(code)) {
                return sampleLotStatusEnum.toString();
            }
        }
        return null;
    }
    
}

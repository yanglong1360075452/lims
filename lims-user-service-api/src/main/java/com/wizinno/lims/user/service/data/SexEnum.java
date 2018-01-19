package com.wizinno.lims.user.service.data;

/**
 * @author LiuMei on 2017-06-02.
 */
public enum SexEnum {

    /**
     * 男
     */
    MALE(1, "男"),
    /**
     * 女
     */
    FEMALE(2, "女"),
    /**
     * 未知
     */
    UNKNOWN(0, "未知");

    private Integer nCode;

    private String name;


    SexEnum(Integer code, String name) {
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

    public static SexEnum valueOf(Integer code) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.toCode().equals(code)) {
                return sexEnum;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.toCode().equals(code)) {
                return sexEnum.toString();
            }
        }
        return null;
    }
}

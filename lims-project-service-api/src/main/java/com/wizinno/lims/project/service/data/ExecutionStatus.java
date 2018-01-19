package com.wizinno.lims.project.service.data;

/**
 * @author LiuMei
 * @date 2017-11-17.
 */
public enum ExecutionStatus {

    /**
     * 成功
     */
    SUCCESS(1, "成功"),
    /**
     * 失败
     */
    FAIL(2, "失败"),
    ;

    private Integer code;

    private String name;


    ExecutionStatus(Integer code, String name) {
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

    public static ExecutionStatus valueOf(Integer code) {
        for (ExecutionStatus data : ExecutionStatus.values()) {
            if (data.toCode().equals(code)) {
                return data;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (ExecutionStatus data : ExecutionStatus.values()) {
            if (data.toCode().equals(code)) {
                return data.toString();
            }
        }
        return null;
    }
    
}

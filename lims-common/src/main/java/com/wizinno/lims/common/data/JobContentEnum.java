package com.wizinno.lims.common.data;

/**
 * 工作内容
 * 同时也是工作流类型
 * @author LiuMei on 2017-06-15.
 */
public enum JobContentEnum {

    /**
     * 样本提取
     */
    SAMPLE_EXTRACT(1, "样本提取"),

    /**
     * 样本检测
     */
    SAMPLE_CHECK(2, "样本检测"),

    /**
     * 文库构建
     */
    LIBRARY_BUILD(3, "文库构建"),

    /**
     * 文库检测
     */
    LIBRARY_CHECK(4, "文库检测"),

    /**
     * 文库定量
     */
    LIBRARY_RATION(5, "文库定量"),

    /**
     * 测序
     */
    SEQUENCING(6, "测序"),

    /**
     * 测序结果QC
     */
    SEQUENCING_QC(7, "测序结果QC"),

    /**
     * 生信分析
     */
    LETTER_ANALYSIS(8, "生信分析"),

    /**
     * 其他
     */
    OTHER(9, "其他"),
    ;

    private Integer nCode;

    private String name;

    JobContentEnum(Integer code, String name) {
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

    public static JobContentEnum valueOf(Integer code) {
        for (JobContentEnum jobContentEnum : JobContentEnum.values()) {
            if (jobContentEnum.toCode().equals(code)) {
                return jobContentEnum;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (JobContentEnum jobContentEnum : JobContentEnum.values()) {
            if (jobContentEnum.toCode().equals(code)) {
                return jobContentEnum.toString();
            }
        }
        return null;
    }

}

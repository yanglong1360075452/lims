package com.wizinno.lims.workflow.cfg.service.data;

/**
 * 工作流节点类别枚举
 * 
 * @author LiuMei
 * @date 2017-10-26.
 */
public enum ActivCategoryEnum {
    /**
     * 样本提取
     */
    SAMPLE_Extract(1, "样本提取"),

    /**
     * 样本稀释
     */
    SAMPLE_ATTENUATION(2,"样本稀释"),

    /**
     * Qubit检测
     */
    QUBIT_CHECK(3, "Qubit检测"),

    /**
     * 电泳测试
     */
    ELECTROPHORESIS(4, "电泳测试"),

    /**
     * A2100测试
     */
    A2100_CHECK(5, "A2100测试"),

    /**
     * 质量分类
     */
    QUALITY_CLASSIFY(6, "质量分类"),

    /**
     * 出报告
     */
    REPORT(7, "出报告"),
    ;
    private Integer code;

    private String name;


    ActivCategoryEnum(Integer code, String name) {
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

    public static ActivCategoryEnum valueOf(Integer code) {
        for (ActivCategoryEnum activCategoryEnum : ActivCategoryEnum.values()) {
            if (activCategoryEnum.toCode().equals(code)) {
                return activCategoryEnum;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (ActivCategoryEnum activCategoryEnum : ActivCategoryEnum.values()) {
            if (activCategoryEnum.toCode().equals(code)) {
                return activCategoryEnum.toString();
            }
        }
        return null;
    }
    
}

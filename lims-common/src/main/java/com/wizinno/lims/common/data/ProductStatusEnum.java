package com.wizinno.lims.common.data;

/**
 * @author LiuMei on 2017-06-19.
 *
 * 生产状态
 */
public enum ProductStatusEnum {

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
     * 测序QC结果
     */
    SEQUENCING_QC(7, "测序QC结果"),
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


    ProductStatusEnum(Integer code, String name) {
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

    public static ProductStatusEnum valueOf(Integer code) {
        for (ProductStatusEnum productStatusEnum : ProductStatusEnum.values()) {
            if (productStatusEnum.toCode().equals(code)) {
                return productStatusEnum;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (ProductStatusEnum productStatusEnum : ProductStatusEnum.values()) {
            if (productStatusEnum.toCode().equals(code)) {
                return productStatusEnum.toString();
            }
        }
        return null;
    }
    
}

package com.wizinno.lims.log.service.data;

/**
 * @author LiuMei on 2017-06-19.
 */
public enum DataDictTypeEnum {

    /**
     * 项目类型
     */
    PROJECT_TYPE(1, "项目类型"),

    /**
     * 项目优先级
     */
    PROJECT_PRIORITY(2, "项目优先级"),

    /**
     * 物种分类
     */
    SPECIES(3, "物种分类"),

    /**
     * 样本类别
     */
    SAMPLE_CATEGORY(4, "样本类别"),

    /**
     * 样本类型
     */
    SAMPLE_TYPE(5, "样本类型"),

    /**
     * 样本保存形式
     */
    SAMPLE_SAVE_WAY(6, "样本保存形式"),

    /**
     * 样本提取内容
     */
    SAMPLE_EXTRACT_CONTENT(7, "样本提取内容"),

    /**
     * 样本提取方法
     */
    SAMPLE_EXTRACT_METHOD(8, "样本提取方法"),

    /**
     * 样本检测方法
     */
    SAMPLE_CHECK_METHOD(9, "样本检测方法"),

    /**
     * 文库检测方法
     */
    LIBRARY_CHECK_METHOD(10, "文库检测方法"),

    /**
     * 文库INDEX位置
     */
    LIBRARY_INDEX(11, "文库INDEX位置"),

    /**
     * 文库片段大小
     */
    LIBRARY_SIZE(12, "文库片段大小"),

    /**
     * 测序平台
     */
    SEQ_PLATFORM(13, "测序平台"),

    /**
     * 测序策略
     */
    SEQ_STRATEGY(14, "测序策略"),

    /**
     * 数据量单位
     */
    DATA_AMOUNT_UNIT(15, "数据量单位"),

    /**
     * 文库类型
     */
    LIBRARY_TYPE(16, "文库类型"),
    ;

    private Integer nCode;

    private String name;

    DataDictTypeEnum(Integer code, String name) {
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

    public static DataDictTypeEnum valueOf(Integer code) {
        for (DataDictTypeEnum dataDictTypeEnum : DataDictTypeEnum.values()) {
            if (dataDictTypeEnum.toCode().equals(code)) {
                return dataDictTypeEnum;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (DataDictTypeEnum dataDictTypeEnum : DataDictTypeEnum.values()) {
            if (dataDictTypeEnum.toCode().equals(code)) {
                return dataDictTypeEnum.toString();
            }
        }
        return null;
    }
    
}

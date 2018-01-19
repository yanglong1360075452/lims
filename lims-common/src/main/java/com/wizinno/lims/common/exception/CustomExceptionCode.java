package com.wizinno.lims.common.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuMei
 */
public class CustomExceptionCode {
    public static final Integer ACCESS_DENIED = 1;
    public static final Integer USERNAME_OR_PASSWORD_ERROR = 2;
    public static final Integer PARAM_ERROR = 3;
    public static final Integer RECORD_NOT_EXIST = 4;
    public static final Integer RECORD_EXIST = 5;
    public static final Integer CANNOT_UPDATE = 6;
    public static final Integer PASSWORD_ERROR = 7;
    public static final Integer CAPTCHA = 8;
    public static final Integer CAPTCHA_ERROR = 9;
    public static final Integer NO_SAMPLE = 10;
    public static final Integer STATUS_NOT_MATCH = 11;
    public static final Integer CANNOT_OPERATE = 12;
    public static final Integer CONFIG_ERROR = 13;
    private final static Map<Integer, String> ERROR_MAP = new HashMap<>();

    static {
        ERROR_MAP.put(ACCESS_DENIED, "权限不足");
        ERROR_MAP.put(USERNAME_OR_PASSWORD_ERROR, "用户名或密码错误");
        ERROR_MAP.put(PARAM_ERROR, "参数错误");
        ERROR_MAP.put(RECORD_NOT_EXIST, "记录不存在");
        ERROR_MAP.put(RECORD_EXIST, "记录已存在");
        ERROR_MAP.put(CANNOT_UPDATE, "该记录不能编辑");
        ERROR_MAP.put(PASSWORD_ERROR, "密码验证失败");
        ERROR_MAP.put(CAPTCHA, "请求验证码");
        ERROR_MAP.put(CAPTCHA_ERROR, "验证码错误");
        ERROR_MAP.put(NO_SAMPLE, "该项目没有样本信息");
        ERROR_MAP.put(STATUS_NOT_MATCH, "状态不匹配");
        ERROR_MAP.put(CANNOT_OPERATE, "不能进行此操作");
        ERROR_MAP.put(CONFIG_ERROR, "配置有误");
    }

    public static String getReasonByCode(Integer code, String defaultReason){
        if(ERROR_MAP.containsKey(code)){
            return ERROR_MAP.get(code);
        }else{
            return defaultReason;
        }
    }
}

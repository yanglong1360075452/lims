package com.wizinno.lims.log.service.aspect;

import com.wizinno.lims.common.data.LogOperateEnum;
import com.wizinno.lims.common.data.LogOperateTypeEnum;

import java.lang.annotation.*;

/**
 * 日志注解类
 *
 * @author LiuMei on 2017-06-14.
 */

@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public  @interface SystemControllerLog {

     String description() default "";

     LogOperateEnum operate();

     LogOperateTypeEnum operateType();

     long objectId() default 1;

}
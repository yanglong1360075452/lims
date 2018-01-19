package com.wizinno.lims.log.service.aspect;

import com.google.gson.Gson;
import com.wizinno.lims.common.security.UserContext;
import com.wizinno.lims.common.util.CommonUtil;
import com.wizinno.lims.log.service.LogService;
import com.wizinno.lims.log.service.dto.LogDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 日志处理
 *
 * @author LiuMei on 2017-06-14.
 */
@Aspect
@Component
public class SystemLogAspect {

    //注入Service用于把日志保存数据库
    @Resource
    private LogService logService;
    /**
     * 本地异常日志记录对象
     */
    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    private Gson gson = new Gson();

    //Controller层切点
    @Pointcut("@annotation(com.wizinno.lims.log.service.aspect.SystemControllerLog)")
    public void controllerAspect() {
    }

    /**
     * 后置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @After("controllerAspect()")
    public void doAfter(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        long userId = UserContext.getLoginUserID();
        //请求的IP
        String ip = request.getRemoteAddr();
        logger.debug("request.getRemoteAddr()" + ip);
        ip = CommonUtil.getIpAddress(request);
        try {
            LogDto log = getControllerMethodDescription(joinPoint);
            log.setIp(ip);
            log.setOperator(userId);
            log.setOperateTime(new Date());
            Object[] args = joinPoint.getArgs();
            log.setDescription(gson.toJson(args));
            logService.addLog(log);
        } catch (Exception e) {
            //记录本地异常日志
            logger.error("==后置通知异常==");
            logger.error("异常信息:{}", e.getMessage());
        }
    }


    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static LogDto getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        LogDto logDto = new LogDto();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazz = method.getParameterTypes();
                if (clazz.length == arguments.length) {
                    String description = method.getAnnotation(SystemControllerLog.class).description();
                    int operate = method.getAnnotation(SystemControllerLog.class).operate().toCode();
                    int operateType = method.getAnnotation(SystemControllerLog.class).operateType().toCode();
                    long objectId = method.getAnnotation(SystemControllerLog.class).objectId();
                    logDto.setOperateType(operateType);
                    logDto.setOperate(operate);
                    logDto.setDescription(description);
                    logDto.setOperateObjectId(objectId);
                    break;
                }
            }
        }
        return logDto;
    }
}

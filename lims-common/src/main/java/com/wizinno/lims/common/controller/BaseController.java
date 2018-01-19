package com.wizinno.lims.common.controller;

import com.wizinno.lims.common.exception.CustomException;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuMei on 2017-05-27.
 */
public class BaseController {
    private Logger logger = Logger.getLogger(BaseController.class);

    @ExceptionHandler(CustomException.class)
    public Map exception(HttpServletRequest request, Exception e) {
        Map response = new HashMap(3);
        if (e instanceof CustomException) {
            CustomException exception= (CustomException) e;
            response.put("code", exception.getCode());
            String reason = exception.getReason();
            if(reason == null){
                response.put("reason", CustomExceptionCode.getReasonByCode(exception.getCode(), "错误码未定义"));
            }else {
                response.put("reason", reason);
            }
            logger.debug(e.getMessage(), e);
        }else if(e instanceof AccessDeniedException){
            response.put("code", 1);
            response.put("reason", "权限不足");
            logger.warn(e.getMessage(), e);
        }else if(e instanceof HttpClientErrorException){
            logger.warn(e.getMessage(), e);
        }else{
            response.put("code", -1);
            response.put("reason", "服务器内部错误");
            response.put("errorMessage",e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return response;
    }
}

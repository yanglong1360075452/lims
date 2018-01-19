package com.wizinno.lims.security;

import com.google.gson.Gson;
import com.wizinno.lims.common.data.LogOperateEnum;
import com.wizinno.lims.common.data.LogOperateTypeEnum;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.common.util.CommonUtil;
import com.wizinno.lims.common.util.ListUtil;
import com.wizinno.lims.log.service.LogService;
import com.wizinno.lims.log.service.condition.LogCondition;
import com.wizinno.lims.log.service.dto.LogDto;
import com.wizinno.lims.user.service.UserService;
import com.wizinno.lims.user.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LiuMei
 */
public class MyAjaxAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private String defaultFailureUrl;
    private boolean forwardToDestination;
    
    private int faultCount = 3;

    private Gson gson = new Gson();

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        //AJAX
        if (CommonUtil.ajaxRequest(request)) {
            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-cache, no-store");
            response.setHeader("Pragma", "no-cache");
            long time = System.currentTimeMillis();
            response.setDateHeader("Last-Modified", time);
            response.setDateHeader("Date", time);
            response.setDateHeader("Expires", time);

            ResponseVO responseVO = null;
            if (exception instanceof AuthenticationServiceException) {
                String message = exception.getMessage();
                if (CustomExceptionCode.CAPTCHA_ERROR.toString().equals(message)) {
                    responseVO = new ResponseVO(CustomExceptionCode.CAPTCHA_ERROR,
                            CustomExceptionCode.CAPTCHA_ERROR.toString());
                }
            } else {
                String username = request.getParameter("username");
                UserDto user = userService.findUserByName(username);
                if (user != null) {
                    LogDto logDto = new LogDto();
                    logDto.setOperateType(LogOperateTypeEnum.LOGIN.toCode());
                    logDto.setOperate(LogOperateEnum.LOGIN_FAIL.toCode());
                    logDto.setOperator(user.getId());
                    logDto.setOperateObjectId(user.getId());
                    logDto.setIp(CommonUtil.getIpAddress(request));
                    logDto.setOperateTime(new Date());
                    logService.addLog(logDto);

                    String captcha = request.getParameter("captcha");
                    if(captcha != null && !"".equals(captcha)){
                        responseVO = new ResponseVO(CustomExceptionCode.USERNAME_OR_PASSWORD_ERROR, "用户名或密码错误");
                    }else {
                        LogCondition con = new LogCondition();
                        con.setOperateType(LogOperateTypeEnum.LOGIN.toCode());
                        con.setOperator(user.getId());
                        //最近五分钟
                        con.setOperateStartTime(new Date(System.currentTimeMillis() - 5 * 60 * 1000L));

                        List<LogDto> logDtoList = logService.getLogByCondition(con);
                        List<Integer> fail = new ArrayList<>();
                        if (logDto != null && logDtoList.size() > faultCount-1) {
                            for (LogDto log : logDtoList) {
                                fail.add(log.getOperate());
                            }
                            if (fail.get(0).equals(LogOperateEnum.LOGIN_FAIL.toCode())) {
                                List<List<Integer>> lists = ListUtil.splitSame(fail);
                                //连续输错3次
                                if (lists.get(0).size() >= faultCount) {
                                    responseVO = new ResponseVO(CustomExceptionCode.CAPTCHA, "请求验证码");
                                } else {
                                    responseVO = new ResponseVO(CustomExceptionCode.USERNAME_OR_PASSWORD_ERROR, "用户名或密码错误");
                                }
                            }else {
                                responseVO = new ResponseVO(CustomExceptionCode.USERNAME_OR_PASSWORD_ERROR, "用户名或密码错误");
                            }
                        } else {
                            responseVO = new ResponseVO(CustomExceptionCode.USERNAME_OR_PASSWORD_ERROR, "用户名或密码错误");
                        }
                    }
                } else {
                    responseVO = new ResponseVO(CustomExceptionCode.USERNAME_OR_PASSWORD_ERROR, "用户名或密码错误");
                }
            }


            try {
                response.getOutputStream().write(gson.toJson(responseVO).toString().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                logger.error(e.getMessage(), e);
            }
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } else if (this.defaultFailureUrl == null) {
            this.logger.debug("No failure URL set, sending 401 Unauthorized error");
            response.sendError(401, "Authentication Failed: " + exception.getMessage());
        } else {
            this.saveException(request, exception);
            if (this.forwardToDestination) {
                this.logger.debug("Forwarding to " + this.defaultFailureUrl);
                request.getRequestDispatcher(this.defaultFailureUrl).forward(request, response);
            } else {
                this.logger.debug("Redirecting to " + this.defaultFailureUrl);
                super.getRedirectStrategy().sendRedirect(request, response, this.defaultFailureUrl);
            }
        }

    }

    public String getDefaultFailureUrl() {
        return defaultFailureUrl;
    }

    @Override
    public void setDefaultFailureUrl(String defaultFailureUrl) {
        this.defaultFailureUrl = defaultFailureUrl;
    }

    public boolean isForwardToDestination() {
        return forwardToDestination;
    }

    public void setForwardToDestination(boolean forwardToDestination) {
        this.forwardToDestination = forwardToDestination;
    }
}

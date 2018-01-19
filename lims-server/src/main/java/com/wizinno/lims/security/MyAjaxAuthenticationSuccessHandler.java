package com.wizinno.lims.security;

import com.google.gson.Gson;
import com.wizinno.lims.common.data.LogOperateEnum;
import com.wizinno.lims.common.data.LogOperateTypeEnum;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.security.SecurityUserDetails;
import com.wizinno.lims.common.security.UserContext;
import com.wizinno.lims.common.util.CommonUtil;
import com.wizinno.lims.log.service.LogService;
import com.wizinno.lims.log.service.dto.LogDto;
import com.wizinno.lims.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LiuMei
 */
public class MyAjaxAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    private Gson gson = new Gson();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        if(CommonUtil.ajaxRequest(request)){
            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-cache, no-store");
            response.setHeader("Pragma", "no-cache");
            long time = System.currentTimeMillis();
            response.setDateHeader("Last-Modified", time);
            response.setDateHeader("Date", time);
            response.setDateHeader("Expires", time);

            SecurityUserDetails user = UserContext.getUserDetails();

            Map<String, Object> data = new HashMap<>(4);
            long id = user.getId();
            data.put("id", id);
            data.put("username", user.getUsername());
            data.put("nickname", userService.findById(user.getId()).getNickname());
            data.put("permissions",userService.getUserPermissionsCode(id));

            LogDto logDto = new LogDto();
            logDto.setOperateType(LogOperateTypeEnum.LOGIN.toCode());
            logDto.setOperate(LogOperateEnum.LOGIN_SUCCESS.toCode());
            logDto.setOperator(user.getId());
            logDto.setOperateObjectId(user.getId());
            logDto.setIp(CommonUtil.getIpAddress(request));
            logDto.setOperateTime(new Date());
            logService.addLog(logDto);

            try {
                response.getOutputStream().write(gson.toJson(new ResponseVO(data)).toString().getBytes("UTF-8"));
            }catch (UnsupportedEncodingException e){
                logger.error(e.getMessage(), e);
            }
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }else if (!response.isCommitted()) {
            handle(request, response, authentication);
        }

        clearAuthenticationAttributes(request);
    }

}

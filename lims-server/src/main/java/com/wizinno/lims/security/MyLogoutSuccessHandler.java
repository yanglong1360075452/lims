package com.wizinno.lims.security;

import com.google.gson.Gson;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.util.CommonUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author LiuMei
 */
public class MyLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
    private String defaultTargetUrl = "/login";

    private Gson gson = new Gson();

    @PostConstruct
    public void init() {
        super.setDefaultTargetUrl(defaultTargetUrl);
    }

    public MyLogoutSuccessHandler() {

    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (CommonUtil.ajaxRequest(request)) {
            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-cache, no-store");
            response.setHeader("Pragma", "no-cache");
            long time = System.currentTimeMillis();
            response.setDateHeader("Last-Modified", time);
            response.setDateHeader("Date", time);
            response.setDateHeader("Expires", time);

            try {
                response.getOutputStream().write(gson.toJson(new ResponseVO("success")).toString().getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                logger.error(e.getMessage(), e);
            }
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } else if (!response.isCommitted()) {
            handle(request, response, authentication);
        }
    }

    @Override
    public void setDefaultTargetUrl(String defaultTargetUrl) {
        this.defaultTargetUrl = defaultTargetUrl;
    }
}

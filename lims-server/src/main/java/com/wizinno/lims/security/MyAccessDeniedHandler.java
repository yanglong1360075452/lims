package com.wizinno.lims.security;

import com.google.gson.Gson;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.common.util.CommonUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author LiuMei
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    protected static final Log log = LogFactory.getLog(MyAccessDeniedHandler.class);
    private Gson gson = new Gson();
    private String errorPage;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
    	if(CommonUtil.ajaxRequest(request)){
            response.setContentType("application/json");
            response.setHeader("Cache-Control", "no-cache, no-store");
            response.setHeader("Pragma", "no-cache");
            long time = System.currentTimeMillis();
            response.setDateHeader("Last-Modified", time);
            response.setDateHeader("Date", time);
            response.setDateHeader("Expires", time);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);

            try{
                response.getOutputStream().write(gson.toJson(new ResponseVO(CustomExceptionCode.ACCESS_DENIED, "权限不足")).toString().getBytes("UTF-8"));
            }catch (UnsupportedEncodingException e){
                log.error(e.getMessage(), e);
            }
            response.setCharacterEncoding("UTF-8");
            response.getOutputStream().flush();
            response.getOutputStream().close();
    	}else if (!response.isCommitted()) {
            if (errorPage != null) {
                // Put exception into request scope (perhaps of use to a view)
                request.setAttribute(WebAttributes.ACCESS_DENIED_403, accessDeniedException);

                // Set the 403 status code.
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);

                // forward to error page.
                RequestDispatcher dispatcher = request.getRequestDispatcher(errorPage);
                dispatcher.forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
            }
        }
    }

    /**
     * The error page to use. Must begin with a "/" and is interpreted relative to the current context root.
     *
     * @param errorPage the dispatcher path to display
     *
     * @throws IllegalArgumentException if the argument doesn't comply with the above limitations
     */
    public void setErrorPage(String errorPage) {
        String split = "/";
        if ((errorPage != null) && !errorPage.startsWith(split)) {
            throw new IllegalArgumentException("errorPage must begin with '/'");
        }

        this.errorPage = errorPage;
    }
}

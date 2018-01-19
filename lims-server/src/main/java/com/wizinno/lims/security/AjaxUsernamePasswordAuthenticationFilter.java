package com.wizinno.lims.security;

import com.wizinno.lims.common.data.LogOperateEnum;
import com.wizinno.lims.common.data.LogOperateTypeEnum;
import com.wizinno.lims.common.exception.CustomExceptionCode;
import com.wizinno.lims.common.util.ListUtil;
import com.wizinno.lims.log.service.LogService;
import com.wizinno.lims.log.service.condition.LogCondition;
import com.wizinno.lims.log.service.dto.LogDto;
import com.wizinno.lims.user.service.UserService;
import com.wizinno.lims.user.service.dto.UserDto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LiuMei on 2017-05-22.
 */
public class AjaxUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static Logger log = LoggerFactory.getLogger(AjaxUsernamePasswordAuthenticationFilter.class);

    private String username = "username";

    private String password = "password";

    /**
     * 连续输错3次返回验证码
     */
    private Integer faultCount = 3;

    /**
     * 是否只接收POST方式提交的验证数据
     */
    private boolean postOnly = true;

    /**
     * 是否需要验证码
     */
    private boolean checkValidateCode = false;

    /**
     * 验证码对应的表单参数名称
     */
    private String validateCodeParameter = "captcha";

    /**
     * 验证码保存在session中的名称
     */
    private String validateCodeSessionName = "captcha";

    /**
     * 验证成功，跳转的页面
     * 注意：地址必须是 / 或 http 开头的URL地址
     */
    private AuthenticationSuccessHandler successHandler;
    /**
     *
     */
    private AuthenticationFailureHandler failureHandler;

    private MyRequestMatcher myRequestMatcher;

    /**
     * 记住用户的实现
     */
    private RememberMeServices rememberMeServices;

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    public void init() {
        //配置接收参数的表单名称，默认是 j_username 和 j_password
        //可以在这里手工指定，也可以在Spring配置中注入属性
        this.setUsername(username);
        this.setPassword(password);

        super.setRememberMeServices(rememberMeServices);
        super.setRequiresAuthenticationRequestMatcher(myRequestMatcher);

        //验证成功，跳转的页面
        this.setAuthenticationSuccessHandler(successHandler);

        this.setAuthenticationFailureHandler(failureHandler);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        if (postOnly && !HttpMethod.POST.toString().equals(request.getMethod())) {
            //这里可以直接抛出异常，也可以直接跳转
            log.error("Authentication method not supported: " + request.getMethod());

            throw new AuthenticationServiceException
                    ("Authentication method not supported: " + request.getMethod());
        }
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        String captcha = obtainValidateCodeParameter(request);
        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();

        if(captcha != null && !"".equals(captcha) && captcha.length() > 0){
            checkValidateCode = true;
        }else {
            UserDto user = userService.findUserByName(username);
            if (user != null) {
                LogCondition con = new LogCondition();
                con.setOperateType(LogOperateTypeEnum.LOGIN.toCode());
                con.setOperator(user.getId());
                //最近五分钟
                con.setOperateStartTime(new Date(System.currentTimeMillis() - 5 * 60 * 1000L));

                List<LogDto> logDtoList = logService.getLogByCondition(con);
                List<Integer> fail = new ArrayList<>();
                if (logDtoList != null && logDtoList.size() > faultCount-1) {
                    for (LogDto log : logDtoList) {
                        fail.add(log.getOperate());
                    }
                    if (fail.get(0).equals(LogOperateEnum.LOGIN_FAIL.toCode())) {
                        List<List<Integer>> lists = ListUtil.splitSame(fail);
                        //连续输错3次
                        if (lists.get(0).size() > faultCount) {
                            checkValidateCode = true;
                        }
                    }
                }
            }
        }

        //是否需要校验验证码
        if (checkValidateCode) {
            checkValidateCode(request);
        }

        UsernamePasswordAuthenticationToken authRequest
                = new UsernamePasswordAuthenticationToken(username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }

    protected void checkValidateCode(HttpServletRequest request) {
        checkValidateCode = false;
        String sessionValidateCode = obtainSessionValidateCode(request);
        String validateCodeParameter = obtainValidateCodeParameter(request);
        //验证码输入不能为空，不区分大小写
        if (StringUtils.isBlank(sessionValidateCode) || StringUtils.isBlank(validateCodeParameter) ||
                !sessionValidateCode.equalsIgnoreCase(validateCodeParameter)) {
            throw new AuthenticationServiceException(CustomExceptionCode.CAPTCHA_ERROR.toString());
        }
    }

    public boolean isPostOnly() {
        return postOnly;
    }

    @Override
    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        return request.getParameter(username);
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        return request.getParameter(password);
    }

    private String obtainValidateCodeParameter(HttpServletRequest request) {
        return request.getParameter(validateCodeParameter);
    }

    protected String obtainSessionValidateCode(HttpServletRequest request) {
        Object sessionCode = request.getSession().getAttribute(validateCodeSessionName);
        return null == sessionCode ? "" : sessionCode.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usernameParameter) {
        this.username = usernameParameter;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordParameter) {
        this.password = passwordParameter;
    }

    public boolean isCheckValidateCode() {
        return checkValidateCode;
    }

    public void setCheckValidateCode(boolean checkValidateCode) {
        this.checkValidateCode = checkValidateCode;
    }

    public String getValidateCodeParameter() {
        return validateCodeParameter;
    }

    public void setValidateCodeParameter(String validateCodeParameter) {
        this.validateCodeParameter = validateCodeParameter;
    }

    public String getValidateCodeSessionName() {
        return validateCodeSessionName;
    }

    public void setValidateCodeSessionName(String validateCodeSessionName) {
        this.validateCodeSessionName = validateCodeSessionName;
    }

    @Override
    public AuthenticationSuccessHandler getSuccessHandler() {
        return successHandler;
    }

    public void setSuccessHandler(AuthenticationSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }

    @Override
    public AuthenticationFailureHandler getFailureHandler() {
        return failureHandler;
    }

    public void setFailureHandler(AuthenticationFailureHandler failureHandler) {
        this.failureHandler = failureHandler;
    }

    @Override
    public RememberMeServices getRememberMeServices() {
        return rememberMeServices;
    }

    @Override
    public void setRememberMeServices(RememberMeServices rememberMeServices) {
        this.rememberMeServices = rememberMeServices;
    }

    public MyRequestMatcher getMyRequestMatcher() {
        return myRequestMatcher;
    }

    public void setMyRequestMatcher(MyRequestMatcher myRequestMatcher) {
        this.myRequestMatcher = myRequestMatcher;
    }

}

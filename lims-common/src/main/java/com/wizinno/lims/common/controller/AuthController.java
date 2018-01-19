package com.wizinno.lims.common.controller;


import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.common.util.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiuMei on 2017-06-12.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController extends BaseController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @RequestMapping(value = "/captcha",method = RequestMethod.GET)
    public @ResponseBody
    ResponseVO captcha() throws ServletException, IOException {
        CaptchaUtil.outputCaptcha(request, response);
        return null;
    }

}

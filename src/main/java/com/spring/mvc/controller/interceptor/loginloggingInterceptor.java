package com.spring.mvc.controller.interceptor;

import com.spring.mvc.service.LoginLoggingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class loginloggingInterceptor implements HandlerInterceptor {


    @Override

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        System.out.println("preHandle........");



        return true;
    }

    @Autowired
    private LoginLoggingsService loginLoggingUtils;
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle........");
        String username = request.getParameter("username");
        String date = String.valueOf(new Date());
        System.out.println("日志创建打印结果:");
        loginLoggingUtils.OutputStream(username,date);

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion........");

    }
}


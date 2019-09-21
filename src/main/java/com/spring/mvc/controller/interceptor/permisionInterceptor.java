package com.spring.mvc.controller.interceptor;



import com.spring.mvc.service.LoginAndUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class permisionInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginAndUserService loginAndUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*目标方法之前  考虑做权限  日志  事务*/
        System.out.println("preHandle");
        String username= request.getParameter("username");
        int id=5;

        System.out.println(loginAndUserService.permision(username));


        if(loginAndUserService.permision(username)<id){
            System.out.println("permisionpreHandle....");
            return true;
        }
        else {

            System.out.println("请求路径--->"+request.getContextPath());
            response.sendRedirect("/tologin");
            System.out.println("permisionpreHandle....");
            return false;
        }
    }

    @Override
    /*调用方法之后，渲染视图之前
    * 可以对请求域的属性或视图做出修改*/
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("permisionpostHandle");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("permisionafterCompletion");
    }
}

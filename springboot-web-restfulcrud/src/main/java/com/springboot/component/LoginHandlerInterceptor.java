package com.springboot.component;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author swy
 * @description: 登录拦截器
 * @date 2020/10/13 9:31
 */
public class LoginHandlerInterceptor implements HandlerInterceptor  {

    /**
     * 方法执行之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         Object username = request.getSession().getAttribute("username");
         if (username==null){
             request.setAttribute("msg","没有权限请先登录");
             request.getRequestDispatcher("/").forward(request,response);
             return false;
         }else{
             return true;
         }
    }

    public  void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public  void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}

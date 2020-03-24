package com.xza.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 拾柒
 * @create 2020/3/21
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user==null){
            request.setAttribute("msg","未登录，请先登录！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        return true;
    }
}

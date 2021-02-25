package com.km.inteceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Wh
 * @title 拦截器
 * @description
 * @createTime 2021年02月05日 14:18:00
 * @modifier：Wh
 * @modification_time：2021-02-05 14:18
 */
public class Inteceptor implements HandlerInterceptor {

    //在目标方法执行之前  执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//       String par = request.getParameter("name");
//        System.out.println("preHandle");
//        if(par.equals("yes")){
//            return true;
//        }
        return true;
          //返回true代表放下  返回false代表不放行
    }

    //在目标方法执行之后   视图对象返回之前执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //在流程都执行完毕后    执行
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

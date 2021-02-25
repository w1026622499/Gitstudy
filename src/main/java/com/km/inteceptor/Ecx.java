package com.km.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Wh
 * @title 自定义异常
 * @description
 * @createTime 2021年02月05日 17:17:00
 * @modifier：Wh
 * @modification_time：2021-02-05 17:17
 */
public class Ecx implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
       //if(e instanceof myexce){
       //
       //}else if(e instanceof ClassCastException){
       //
       //}

        return null;
    }

}

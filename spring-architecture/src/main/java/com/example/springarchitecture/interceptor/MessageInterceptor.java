package com.example.springarchitecture.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Interceptor 範例
 * 
 * For several reasons it will be necessary to intercept requests made to the routes of an API, some of them may be:
 *  - authentication
 *  - log input data
 *  - generate some information for the request response
 *  - and many other things
 * 
 * TODO: add authentication example.
 * 
 * The HandlerInterceptor contains three main methods:
 *  - prehandle() – called before the execution of the actual handler
 *  - postHandle() – called after the handler is executed
 *  - afterCompletion() – called after the complete request is finished and the view is generated
 * 
 * 
 * References:
 *  - https://medium.com/javarevisited/using-interceptor-in-a-spring-boot-api-9d7a0781dd19
 *  - https://matthung0807.blogspot.com/2019/08/spring-boot-interceptor.html
 *  - https://zh.wikipedia.org/wiki/Java_Servlet
 *  - https://www.baeldung.com/spring-mvc-handlerinterceptor
 *  - https://ithelp.ithome.com.tw/articles/10278220?sc=hot
 */
@Component
public class MessageInterceptor implements HandlerInterceptor {

    // TODO: HttpServletRequest, HttpServletResponse.

    // ! 可運用在 authentication、log input data、generate some information for the request response ...等

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("呼叫 preHandle().");
        System.out.println("request: " + request.getRequestURI());
        System.out.println("response: " + response);
        System.out.println("handler: " + handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("call postHandle().");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("call afterCompletion().");
    }
}

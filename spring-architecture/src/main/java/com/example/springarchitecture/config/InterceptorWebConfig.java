package com.example.springarchitecture.config;

import com.example.springarchitecture.interceptor.MessageInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 要將此攔截器註冊到Web MVC的配置，定義一個類別InterceptorWebMvcConfig並實作WebMvcConfigurer介面
 * 
 * References:
 *  - https://matthung0807.blogspot.com/2019/08/spring-boot-interceptor.html
 */
@Configuration
@EnableWebMvc
public class InterceptorWebConfig implements WebMvcConfigurer {
    @Autowired
    private MessageInterceptor messageInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(messageInterceptor).addPathPatterns("/message/**");
    }
}

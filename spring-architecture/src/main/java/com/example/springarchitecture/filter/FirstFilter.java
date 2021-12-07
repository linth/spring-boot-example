package com.example.springarchitecture.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Fliter
 * 
 * Reference:
 *  - https://examples.javacodegeeks.com/spring-boot-add-filter-example/
 */
public class FirstFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter() method is invoked");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        System.out.println("Context path is  " + httpServletRequest.getContextPath());
        chain.doFilter(httpServletRequest, httpServletResponse);
        System.out.println("doFilter() method is ended");
    }

    public void destroy() {

    }
}
package com.sestar.bootmultiple.servlet;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Bean 注册方式 Filter
 * @author zhangxinxin
 * @date 2019/5/20 14:51
 **/
public class SpringBootFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 服务上下文打印日志, 提示 urlPatterns 已被过滤
        ServletContext servletContext = request.getServletContext();

        servletContext.log(request.getRequestURI() + " was filter");

        filterChain.doFilter(request, response);
    }
}

package com.sestar.bootmultiple.servlet;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注解方式 Filter
 * @author zhangxinxin
 * @date 2019/5/15 16:42
 **/
@WebFilter(urlPatterns = "/springServletUrl")
public class MyFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 服务上下文打印日志, 提示 urlPatterns 已被过滤
        ServletContext servletContext = request.getServletContext();

        servletContext.log(request.getRequestURI() + " was filter");

        filterChain.doFilter(request, response);
    }
}

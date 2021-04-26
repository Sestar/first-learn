package com.sestar.bootmultiple.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * 注解方式 Servlet
 * @author zhangxinxin
 * @date 2019/5/15 16:24
 **/
@WebServlet(name = "springServlet", urlPatterns = "/springServletUrl",
        initParams = {@WebInitParam(name = "param", value = "initValue")})
public class MyServlet extends HttpServlet {

    private String param;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        param = config.getInitParameter("param");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 服务上下文打印日志, 提示进入 doGet 方法中
        ServletContext servletContext = getServletContext();

        servletContext.log(req.getRequestURI() + " doGet...");

        // 返回 WebInitParam 注解中的 param
        Writer writer = resp.getWriter();

        writer.write("<html><body>Run Into Spring Servlet Demo, param is " + param + "</body></html>");

    }
}

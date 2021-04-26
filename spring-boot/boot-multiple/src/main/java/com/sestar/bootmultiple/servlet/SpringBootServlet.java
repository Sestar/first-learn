package com.sestar.bootmultiple.servlet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Bean 注册方式 Servlet
 * @author zhangxinxin
 * @date 2019/5/20 14:54
 **/
public class SpringBootServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // 服务上下文打印日志, 提示进入 doGet 方法中
        ServletContext servletContext = getServletContext();

        servletContext.log(req.getRequestURI() + " doGet...");

        // 返回 WebInitParam 注解中的 param
        Writer writer = resp.getWriter();

        writer.write("<html><body>Run Into Spring Boot Servlet Demo</body></html>");

    }
}

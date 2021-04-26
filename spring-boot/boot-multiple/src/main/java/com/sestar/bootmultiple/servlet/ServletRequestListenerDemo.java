package com.sestar.bootmultiple.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Servlet Request Listener
 * @author zhangxinxin
 * @date 2019/5/20 14:02
 **/
@WebListener
public class ServletRequestListenerDemo implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        ServletRequest request = sre.getServletRequest();

        ServletContext servletContext = request.getServletContext();

        servletContext.log("spring request was initialized...");

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

        ServletRequest request = sre.getServletRequest();

        ServletContext servletContext = request.getServletContext();

        servletContext.log("spring request was destroyed...");

    }

}

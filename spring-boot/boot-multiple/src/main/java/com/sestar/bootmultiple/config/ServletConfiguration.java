package com.sestar.bootmultiple.config;

import com.sestar.bootmultiple.servlet.ServletRequestListenerDemo;
import com.sestar.bootmultiple.servlet.SpringBootFilter;
import com.sestar.bootmultiple.servlet.SpringBootServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean 注册方式 Servlet 配置
 *
 * @author zhangxinxin
 * @date 2019/5/21 15:08
 **/
@Configuration
public class ServletConfiguration {

    /**
     * Bean 注册方式 Servlet
     *
     * @author zhangxinxin
     * @date 2019/5/20 17:13
     * @return org.springframework.boot.web.servlet.ServletRegistrationBean
     */
    @Bean
    public static ServletRegistrationBean servletRegistrationBean() {

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();

        servletRegistrationBean.setServlet(new SpringBootServlet());
        servletRegistrationBean.setName("springBootServlet");
        servletRegistrationBean.addUrlMappings("/springBootServletUrl");
        servletRegistrationBean.addInitParameter("param", "spring-boot");

        return servletRegistrationBean;
    }

    /**
     * Bean 注册方式 Filter
     *
     * @author zhangxinxin
     * @date 2019/5/20 17:14
     * @return org.springframework.boot.web.servlet.FilterRegistrationBean
     */
    @Bean
    public static FilterRegistrationBean filterRegistrationBean() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setFilter(new SpringBootFilter());
        filterRegistrationBean.addServletNames("springBootServlet");

        return filterRegistrationBean;
    }

    /**
     * Bean 注册方式 Servlet Listener
     *
     * @author zhangxinxin
     * @date 2019/5/20 17:14
     * @return org.springframework.boot.web.servlet.ServletListenerRegistrationBean
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public static ServletListenerRegistrationBean servletListenerRegistrationBean() {

        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();

        servletListenerRegistrationBean.setListener(new ServletRequestListenerDemo());

        return servletListenerRegistrationBean;
    }

}

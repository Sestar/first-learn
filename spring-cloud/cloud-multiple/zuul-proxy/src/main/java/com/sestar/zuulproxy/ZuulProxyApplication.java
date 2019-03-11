package com.sestar.zuulproxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @description Zuul 路由代理启动类
 * @author zhangxinxin
 * @date 2019/2/27 9:36
 **/
@EnableZuulProxy    // 注册Zuul路由代理
@SpringBootApplication
public class ZuulProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulProxyApplication.class, args);
    }

}

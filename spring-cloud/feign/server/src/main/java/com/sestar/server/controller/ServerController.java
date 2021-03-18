package com.sestar.server.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Server-API
 *
 * @author zhangxinxin
 * @date 2021/03/11 16:25
 */
@RestController
public class ServerController {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String port;

    @ApiOperation("用来调用用户服务端的测试服务")
    @GetMapping("greet")
    public String greet() {
        return String.format("访问对象, appName:%s, port:%s", appName, port);
    }

    @ApiOperation("测试 hystrix 熔断功能-超时")
    @GetMapping("hystrix/timeOut")
    public String hystrixTimeOut() {
        // 生成一个3000之内的随机数
        long ms = (long)(3000L*Math.random());
        try {
            // 程序延迟，有一定的概率超过2000 ms
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return String.format("访问对象, appName:%s, port:%s", appName, port);
    }

}

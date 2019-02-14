package com.sestar.cloudserverprovider.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sestar.cloudserverprovider.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @description Server Provider Controller
 * @author zhangxinxin
 * @date 2019/1/10 14:30
 **/
@RestController
public class ServerProviderController {

    @Value("${server.port}")
    private String port;

    /**
     * 随机数工具类
     **/
    private static final Random random = new Random();

    @PostMapping("/greeting")
    public String greeting(@RequestBody User user) {
        return "greeting:" + user.toString() + " port:" + port;
    }

    /**
     * @description 测试Hystrix的超时
     * @author zhangxinxin
     * @date 2019/2/12 17:11
     * @return java.lang.String
     **/
    @HystrixCommand(
        commandProperties = {   // command 配置
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100") // 设置最大执行时间
        },
        fallbackMethod = "cuttingOutFallBack" // 设置熔断后执行回滚方法
    )
    @PostMapping("/operaHystrix")
    public String operaHystrix() throws InterruptedException {
        int randomNbr = random.nextInt(200);
        System.out.println("Execution Time: " + randomNbr);
        Thread.sleep(randomNbr);
        return "randomNbr:" + randomNbr + ", port:" + port;
    }

    /**
     * @description operaHystrix熔断后执行回滚方法
     * @author zhangxinxin
     * @date 2019/2/12 14:57
     * @return java.lang.String
     **/
    private String cuttingOutFallBack() {
        return "operaHystrix Method Execution is cutting out!";
    }

}

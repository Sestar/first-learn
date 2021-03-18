package com.sestar.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sestar.client.server.IFeignService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * API
 *
 * @author zhangxinxin
 * @date 2021/03/11 11:16
 */
@RestController
public class ClientController {

    /**
     * 能够实现负载均衡的 Rest 调用对象
     */
    @Autowired
    @Qualifier("ribbonRestTemplate")
    private RestTemplate ribbonRestTemplate;

    /**
     * feign 服务
     */
    @Autowired
    private IFeignService feignService;

    @Value("${server.app.name}")
    private String serverAppName;

    @ApiOperation("测试负载均衡")
    @GetMapping("ribbon")
    public String ribbon() {
        String url = String.format("http://%s/greet", serverAppName);

        return ribbonRestTemplate.getForObject(url, String.class);
    }

    @ApiOperation("测试 Feign, 不暴露负载均衡调用")
    @GetMapping("feign")
    public String feign() {
        return feignService.greet();
    }

    @ApiOperation("测试 Hystrix 超时熔断")
    @GetMapping("hystrix/timeOut")
    @HystrixCommand(fallbackMethod = "hystrixError")
    public String hystrixTimeOut() {
        return feignService.hystrixTimeOut();
    }

    /**
     * Hystrix 熔断后处理内容
     *
     * @author zhangxinxin
     * @date 2021/03/11 17:47
     * @return java.lang.String
     */
    private String hystrixError() {
        return "被熔断了";
    }

}

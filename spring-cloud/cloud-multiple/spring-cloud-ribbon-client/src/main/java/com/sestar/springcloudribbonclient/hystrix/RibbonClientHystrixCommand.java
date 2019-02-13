package com.sestar.springcloudribbonclient.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

/**
 * @description Ribbon Client 的熔断器
 * @author zhangxinxin
 * @date 2019/2/12 22:07
 **/
public class RibbonClientHystrixCommand extends HystrixCommand<Object> {

    /**
     * 服务提供方的服务名称
     **/
    private String applicationName;

    /**
     * 具有负载均衡的RestTemplate
     **/
    private RestTemplate restTemplate;

    public RibbonClientHystrixCommand(String applicationName, RestTemplate restTemplate) {
        // 设置超时时间, name可以随便定义
        super(HystrixCommandGroupKey.Factory.asKey("Ribbon-Client-Hystrix"),
                100);
        this.restTemplate = restTemplate;
        this.applicationName = applicationName;
    }

    @Override
    protected Object run() {
        String url = "http://" + applicationName + "/operaHystrix";
        return restTemplate.postForObject(url, null, String.class);
    }

    @Override
    protected Object getFallback() {
        return "RibbonClientHystrixCommand run Method Execution has be cutted out!";
    }
}

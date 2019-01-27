package com.sestar.springcloudribbonclient.web.controller;

import com.sestar.springcloudribbonclient.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @description 访问服务提供端Controller的服务
 * @author zhangxinxin
 * @date 2019/1/10 14:39
 **/
@RestController
public class RibbonClientController {

    @Autowired
    @Qualifier("loadBalanceRestTemplate")
    private RestTemplate restTemplate;

    @Value("${service-provider.server.host}")
    private String serverHost;

    @Value("${service-provider.server.context-path")
    private String serverContextPath;

    @Value("${service-provider.application.name}")
    private String applicationName;

    @Value("${service-provider1.port}")
    private String port;

    @Value("${service-provider.application.name}" + "${service-provider.server.context-path}")
    private String urlTogether;

    @GetMapping("/greeting")
    public String greeting() {
        User user = new User();
        user.setId(123L);
        user.setName("sestar");

        // 使用拼接方式(非Eureka Client)
//        String url = "http://" + host + ":" + port + contextPath + "/greeting";
        // 使用ribbon.listOfServers方式, 解析url(非Eureka Client)
//        String url = "http://" + urlTogether + "/greeting";
        // 使用 Eureka 服务发现访问 server-provider
        String url = "http://" + urlTogether + "/greeting";

        return restTemplate.postForObject(url, user, String.class);
    }

}

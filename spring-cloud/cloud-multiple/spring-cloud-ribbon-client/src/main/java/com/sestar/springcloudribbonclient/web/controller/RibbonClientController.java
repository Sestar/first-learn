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

    @Value("${service-provider.application.name}")
    private String applicationName;

    @GetMapping("/greeting")
    public String greeting() {
        User user = new User();
        user.setId(123L);
        user.setName("sestar");

        String url = "http://" + applicationName + "/greeting";

        return restTemplate.postForObject(url, user, String.class);
    }

}

package com.sestar.springconsulclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @description Consul Client Controller
 * @author zhangxinxin
 * @date 2019/1/9 15:04
 **/
@RestController
public class DiscoveryClientController {

    /**
     * Consul Client
     **/
    private DiscoveryClient discovertyClient;

    /**
     * 当前应用名称
     **/
    private String currentApplicationName;

    @Autowired
    public DiscoveryClientController(DiscoveryClient discovertyClient,
                                     @Value("spring.application.name") String currentApplicationName) {
        this.discovertyClient = discovertyClient;
        this.currentApplicationName = currentApplicationName;
    }

    // 获取当前应用信息
    @GetMapping("/current/serviceInstance")
    public ServiceInstance getCurrentService() {
        // 只能获取本地启动的Client
        return discovertyClient.getLocalServiceInstance();
    }

    // 获取所有的服务名
    @GetMapping("/all/serviceNames")
    public List<String> getAllServiceNames() {
        return discovertyClient.getServices();
    }

    // 获取所有的服务实例信息
    @GetMapping("/all/serviceInstances")
    public List<ServiceInstance> getAllServiceInstances() {
        List<String> allServiceNames = getAllServiceNames();
        List<ServiceInstance> serviceInstances = new ArrayList<>();
        allServiceNames.forEach(serviceName -> {
            serviceInstances.addAll(discovertyClient.getInstances(serviceName));
        });
        return serviceInstances;
    }

}

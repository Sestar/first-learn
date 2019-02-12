package com.sestar.cloudserverprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // 使用Eureka服务发现方式发现服务提供端
public class CloudServerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServerProviderApplication.class, args);
    }

}


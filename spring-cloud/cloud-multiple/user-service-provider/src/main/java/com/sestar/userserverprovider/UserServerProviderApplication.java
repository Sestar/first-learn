package com.sestar.userserverprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient // 使用Eureka服务发现方式发现服务提供端
@EnableHystrix // Netflix Hystrix 熔断器
public class UserServerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServerProviderApplication.class, args);
    }

}

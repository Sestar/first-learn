package com.sestar.userserverprovider;

import com.sestar.userserverprovider.stream.ConsumerChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableDiscoveryClient // 注册为 Eureka-Client
//@EnableHystrix // Netflix Hystrix 熔断器
@EnableBinding({ConsumerChannel.class}) // 订阅管道绑定
public class UserServerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServerProviderApplication.class, args);
    }

}


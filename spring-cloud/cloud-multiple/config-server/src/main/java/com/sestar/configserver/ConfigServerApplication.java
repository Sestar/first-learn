package com.sestar.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @description Config Server
 * @author zhangxinxin
 * @date 2019/2/18 14:15
 **/
@SpringBootApplication
@EnableDiscoveryClient  // 能够Eureka发现
@EnableConfigServer     // Cloud Server
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}

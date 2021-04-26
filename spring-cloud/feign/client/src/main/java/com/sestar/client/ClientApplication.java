package com.sestar.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 客户端启动类
 *
 * {@link EnableFeignClients} 开启 Feign
 * {@link EnableCircuitBreaker} 开启 Hystrix 熔断器
 *
 * @author zhangxinxin
 * @date 2021/03/11 11:13
 */
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    /**
     * 注册能够负载均衡的 Rest 调用对象
     *
     * {@link LoadBalanced} 开启负载均衡
     *
     * @author zhangxinxin
     * @date 2021/03/11 11:22
     * @return org.springframework.web.client.RestTemplate
     */
    @LoadBalanced
    @Bean(name = "ribbonRestTemplate")
    public RestTemplate ribbonRestTemplate() {
        return new RestTemplate();
    }

}

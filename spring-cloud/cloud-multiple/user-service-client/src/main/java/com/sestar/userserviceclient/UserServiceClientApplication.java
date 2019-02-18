package com.sestar.userserviceclient;

import com.sestar.userapi.api.IUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClient(name = "user-service-provider-application")
@EnableDiscoveryClient // 使用Eureka服务发现方式发现服务提供端
@EnableCircuitBreaker  // Netflix Hystrix 熔断器
@EnableFeignClients(clients = IUserService.class) // 申明 UserService 接口作为 Feign Client 调用
public class UserServiceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceClientApplication.class, args);
    }

    /**
     * @description 获取用以负载均衡的RestTemplate的Bean对象,
     *          注释@LoadBalanced将会把RestTemplate也注册为 LoadBalancerClient,
     *          所以如果自动注入LoadBalancerClient对象也是本方法返回对象
     *          而且使用该RestTemplate.execute调用的也是LoadBalancerClient#execute
     * @author zhangxinxin
     * @date 2019/1/10 14:43
     * @return org.springframework.web.client.RestTemplate
     **/
    @Bean(name = "loadBalanceRestTemplate")
    @LoadBalanced
    public RestTemplate getLoadBalanceRestTemplate() {
        return new RestTemplate();
    }

    /**
     * @description 获取简单访问url的RestTemplate的Bean对象
     * @author zhangxinxin
     * @date 2019/1/27 16:21
     * @return org.springframework.web.client.RestTemplate
     **/
    @Bean(name = "simpleRestTemplate")
    public RestTemplate getSimplateRestTemplate() {
        return new RestTemplate();
    }


    /**
     * @description 使用自定义负载均衡规则(永远选择可达服务器的最后一台), 已使用配置方法绑定规则
     * @author zhangxinxin
     * @date 2019/1/16 13:46
     * @return com.netflix.loadbalancer.IRule
     **/
//    @Bean
//    public IRule getRule() {
//        return new MyRule();
//    }

    /**
     * @description 使用自定义负载均衡Ping(通过安全监测判断是否存活)，已使用配置方法绑定IPing
     * @author zhangxinxin
     * @date 2019/1/23 13:58
     * @return com.netflix.loadbalancer.IPing
     **/
//    @Bean
//    public IPing getPing() {
//        return new MyPing();
//    }

}


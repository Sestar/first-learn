package com.sestar.userserviceclient;

import com.sestar.userserviceclient.stream.ProducerChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
//@RibbonClient(name = "user-service-provider-application")
@EnableDiscoveryClient // 使用Eureka服务发现方式发现服务提供端
//@EnableCircuitBreaker  // Netflix Hystrix 熔断器
//@EnableFeignClients(clients = IUserService.class) // 申明 UserService 接口作为 Feign Client 调用
@EnableBinding({ProducerChannel.class}) // 绑定消息生产者接口
public class UserServiceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceClientApplication.class, args);
    }

//    /**
//     * @description 获取用以负载均衡的RestTemplate的Bean对象,
//     *          注释@LoadBalanced将会把RestTemplate也注册为 LoadBalancerClient,
//     *          所以如果自动注入LoadBalancerClient对象也是本方法返回对象
//     *          而且使用该RestTemplate.execute调用的也是LoadBalancerClient#execute
//     * @author zhangxinxin
//     * @date 2019/1/10 14:43
//     * @return org.springframework.web.client.RestTemplate
//     **/
//    @Bean(name = "loadBalanceRestTemplate")
//    @LoadBalanced
//    public RestTemplate getLoadBalanceRestTemplate() {
//        return new RestTemplate();
//    }
//
//    /**
//     * @description 获取简单访问url的RestTemplate的Bean对象
//     * @author zhangxinxin
//     * @date 2019/1/27 16:21
//     * @return org.springframework.web.client.RestTemplate
//     **/
//    @Bean(name = "simpleRestTemplate")
//    public RestTemplate getSimplateRestTemplate() {
//        return new RestTemplate();
//    }

}


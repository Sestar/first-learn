package com.sestar.userserviceclient.web.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxinxin
 * @description 访问服务提供端Controller的服务
 * @date 2019/1/10 14:39
 **/
@RestController
public class RibbonClientController {

//    /**
//     * 具有负载均衡的RestTemplate
//     **/
//    private RestTemplate restTemplate;
//
//    /**
//     * 服务提供端的服务名称
//     **/
//    private String applicationName;
//
//    /**
//     * HystrixCommand只能执行一次, 所以servlet必须每次执行前先 new HystrixCommand对象, 否则IllegalStateException
//     * 所以HystrixCommand不适用于作为属性变量
//     **/
//    @SuppressWarnings("all")
//    private RibbonClientHystrixCommand hystrixCommand;
//
//    /**
//     * PostConstruct注释使得该方法在初始化之前执行, 配合上面hystrixCommand变量属性使用, 当使用hystrixCommand执行两次之后会爆
//     * “This instance can only be executed once. Please instantiate a new instance.” 错误
//     * 所以HystrixCommand不适用于作为属性变量
//     **/
//    @PostConstruct
//    public void init() {
//        this.hystrixCommand = new RibbonClientHystrixCommand(applicationName, restTemplate);
//    }
//
//    public RibbonClientController(@Autowired @Qualifier("loadBalanceRestTemplate") RestTemplate restTemplate,
//                                  @Value("${provider.server.application.name}") String applicationName) {
//        this.restTemplate = restTemplate;
//        this.applicationName = applicationName;
//    }
//
//    /**
//     * @description 测试Hystrix熔断器(RibbonClient和ServerProvider都有Hystrix熔断器)
//     * @author zhangxinxin
//     * @date 2019/2/12 18:01
//     * @return java.lang.String
//     **/
//    @GetMapping("/timeoutHystrixOfProvider")
//    public String timeoutHystrixOfProvider() {
//        /*
//         * 该方法执行两次之后会爆
//         *“This instance can only be executed once. Please instantiate a new instance.” 错误
//         * 是由于HystrixCommand一个实例只能执行一次, 所以每次执行需要一个新的HystrixCommand
//         **/
//        // return hystrixCommand.execute().toString();
//        return new RibbonClientHystrixCommand(applicationName, restTemplate).execute().toString();
//    }

}

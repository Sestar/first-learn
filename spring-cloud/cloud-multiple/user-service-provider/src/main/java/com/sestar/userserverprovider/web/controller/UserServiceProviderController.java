package com.sestar.userserverprovider.web.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sestar.userapi.api.IUserService;
import com.sestar.userapi.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @description Server Provider Controller
 * @author zhangxinxin
 * @date 2019/1/10 14:30
 **/
@RestController
public class UserServiceProviderController implements IUserService {

    /**
     * 用户服务中心
     **/
    private final IUserService userServer;

    /**
     * 随机数工具类
     **/
    private static final Random random = new Random();

    @Value("${server.port}")
    private String port;

    @Autowired
    public UserServiceProviderController(@Qualifier("inMemoryUserService") IUserService userServer) {
        this.userServer = userServer;
    }

    // 通过方法继承，URL 映射 ："/user/save"
    @Override
    public boolean saveUser(@RequestBody User user) {
        return userServer.saveUser(user);
    }

    // 通过方法继承，URL 映射 ："/user/find/all"
    @Override
    public List<User> findAll() {
        return userServer.findAll();
    }

    // 通过反复集成， URL 映射 : "/timeoutHystrix"
    @HystrixCommand(
            commandProperties = {   // command 配置
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100") // 设置最大执行时间
            },
            fallbackMethod = "cuttingOutFallBack" // 设置熔断后执行回滚方法
    )
    @Override
    public String timeoutHystrix() throws Exception {
        return userServer.timeoutHystrix();
    }

    /**
     * @description 测试Hystrix的超时
     * @author zhangxinxin
     * @date 2019/2/12 17:11
     * @return java.lang.String
     **/
    @HystrixCommand(
        commandProperties = {   // command 配置
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100") // 设置最大执行时间
        },
        fallbackMethod = "cuttingOutFallBack" // 设置熔断后执行回滚方法
    )
    @PostMapping("/operaHystrix")
    public String operaHystrix() throws InterruptedException {
        int randomNbr = random.nextInt(200);
        System.out.println("Execution Time: " + randomNbr);
        Thread.sleep(randomNbr);
        return "randomNbr:" + randomNbr + ", port:" + port;
    }

    /**
     * @description operaHystrix熔断后执行回滚方法
     * @author zhangxinxin
     * @date 2019/2/12 14:57
     * @return java.lang.String
     **/
    private String cuttingOutFallBack() {
        return "operaHystrix Method Execution is cutting out!";
    }

}

package com.sestar.client.server;

import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign 接口
 *
 * @author zhangxinxin
 * @date 2021/03/11 17:00
 */
@FeignClient("${server.app.name}")
public interface IFeignService {

    @ApiOperation("访问用户服务端的API")
    @GetMapping("greet")
    String greet();

    @ApiOperation("测试 Feign 的超时功能")
    @GetMapping("hystrix/timeOut")
    String hystrixTimeOut();

}

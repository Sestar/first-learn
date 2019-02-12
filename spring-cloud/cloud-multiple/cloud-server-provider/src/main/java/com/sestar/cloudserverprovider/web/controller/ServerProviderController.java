package com.sestar.cloudserverprovider.web.controller;

import com.sestar.cloudserverprovider.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description Server Provider Controller
 * @author zhangxinxin
 * @date 2019/1/10 14:30
 **/
@RestController
public class ServerProviderController {

    @Value("${server.port}")
    private String port;

    @PostMapping("/greeting")
    public String greeting(@RequestBody User user) {
        return "greeting:" + user.toString() + " port:" + port;
    }

}

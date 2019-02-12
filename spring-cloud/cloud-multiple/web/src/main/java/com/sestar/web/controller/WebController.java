package com.sestar.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeoutException;

/**
 * @description web 控制层
 * @author zhangxinxin
 * @date 2019/1/29 14:31
 **/
@RestController
public class WebController {

    /**
     * 随机数工具类
     **/
    private static final Random random = new Random();

    @GetMapping("")
    public String index() throws TimeoutException {
        int randomNbr = random.nextInt(200);
        if (randomNbr > 100) {
            throw new TimeoutException("Demo Execution is timeout!");
        }

        return "Hello, World";
    }

}

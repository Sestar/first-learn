package com.sestar.zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

/**
 * @description Zipkin 服务器应用
 * @author zhangxinxin
 * @date 2019/4/8 20:52
 **/
@SpringBootApplication
//@EnableZipkinServer // 激活 Zipkin 服务
@EnableZipkinStreamServer // 激活 Zipkin Stream 服务
public class ZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class, args);
    }

}

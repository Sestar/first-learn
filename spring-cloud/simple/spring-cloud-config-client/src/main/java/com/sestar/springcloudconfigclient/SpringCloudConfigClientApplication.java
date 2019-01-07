package com.sestar.springcloudconfigclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

@SpringBootApplication
public class SpringCloudConfigClientApplication {

    /**
     * 用以定时更新服务器端的配置
     **/
//    private final ContextRefresher contextRefresher;
//
//    @Autowired
//    public SpringCloudConfigClientApplication(ContextRefresher contextRefresher) {
//        this.contextRefresher = contextRefresher;
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }

    /**
     * @description 定时更新服务端的配置(1秒)
     * @author zhangxinxin
     * @date 2018/12/28 15:05
     **/
//    @Scheduled(fixedRate = 1000L)
//    private void refresh() {
//        Set<String> changeProp = contextRefresher.refresh();
//        if (null != changeProp && changeProp.size() > 0) {
//            System.out.println("=================change prop start====================");
//            for (String prop : changeProp) {
//                System.out.println(prop);
//            }
//            System.out.println("=================end prop start=======================");
//        }
//    }

}


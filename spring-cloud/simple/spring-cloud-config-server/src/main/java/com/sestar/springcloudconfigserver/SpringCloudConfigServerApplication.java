package com.sestar.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerApplication {

    public static void main(String[] args) {
//		SpringApplication application = new SpringApplication(SpringCloudFirstLearnApplication.class);
//		application.setBannerMode(Banner.Mode.OFF); // 关闭Banner
//		application.run(args);
        SpringApplication.run(SpringCloudConfigServerApplication.class, args);
    }
}

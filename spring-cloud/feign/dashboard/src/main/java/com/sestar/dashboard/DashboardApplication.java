package com.sestar.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hystrix 仪表盘
 *
 * {@link EnableHystrixDashboard} 开启 Hystrix 仪表盘
 *
 * @author zhangxinxin
 * @date 2021/03/11 22:32
 */
@EnableHystrixDashboard
@SpringBootApplication
public class DashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class, args);
    }

}

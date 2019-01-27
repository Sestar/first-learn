package com.sestar.springcloudribbonclient.ribbon;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @description 自定义负载均衡的Ping
 * @author zhangxinxin
 * @date 2019/1/23 10:12
 **/
public class MyPing implements IPing {

    @Autowired
    @Qualifier("simpleRestTemplate")
    private RestTemplate restTemplate;

    @Value("${service-provider.manager.context-path}")
    private String managerContextPath;

    /**
     * @description 通过判断Server的health情况来决定Server是否存活,
     * @author zhangxinxin
     * @date 2019/1/23 10:13
     * @param server 服务对象
     * @return boolean
     **/
    @Override
    public boolean isAlive(Server server) {
        int port = server.getPort() + 10;
        URI uri = UriComponentsBuilder.newInstance().scheme("http").host(server.getHost())
                .port(port).path(managerContextPath + "/health").build().toUri();

        ResponseEntity entity = restTemplate.getForEntity(uri, String.class);
        return HttpStatus.OK.equals(entity.getStatusCode());
    }

}

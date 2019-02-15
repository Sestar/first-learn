package com.sestar.userserviceclient.loadbalanced;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @description 自定义负载均衡规则，永远返回可达服务器的最后一台
 * @author zhangxinxin
 * @date 2019/1/16 11:04
 **/
public class MyRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    /**
     * 永远返回可达服务器的最后一台
     **/
    @Override
    public Server choose(Object key) {
        List<Server> reachableServers = getLoadBalancer().getReachableServers();
        if (reachableServers.isEmpty()) {
            return null;
        }
        return reachableServers.get(reachableServers.size() - 1);
    }
}

package com.sestar.userserviceclient.bus.config;

import org.springframework.context.annotation.Configuration;

/**
 * @description 消息总线配置类
 * @author zhangxinxin
 * @date 2019/4/2 10:27
 **/
@Configuration
//@RemoteApplicationEventScan(basePackageClasses = UserRemoteApplicationEvent.class) // 激活 UserRemoteApplicationEvent 监听
public class BusConfiguration {

//    /**
//     * @description 监听 RefreshRemoteApplicationEvent
//     *    POST 访问 http://localhost:3721/bus/refresh?destination=user-service-client:**
//     *    发现日志：o.s.cloud.bus.event.RefreshListener      : Received remote refresh request. Keys refreshed []
//     *    可见, bus/refresh 的 EndPoint 是由 RefreshListener 监听, 查看 RefreshListener 源码,
//     *    监听的是 RefreshRemoteApplicationEvent 事件
//     * @author zhangxinxin
//     * @date 2019/4/2 10:29
//     */
//    @EventListener
//    public void onRefreshRemoteApplicationEvent(RefreshRemoteApplicationEvent event) {
//        System.out.printf(BusConfiguration.class.getName() + "#onRefreshRemoteApplicationEvent\r\n" +
//                "监听事件 ->  Source: %s, OriginService: %s, DestinationService: %s\r\n",
//                event.getSource(), event.getOriginService(), event.getDestinationService());
//    }
//
//    /**
//     * @description 监听 EnvironmentChangeRemoteApplicationEvent
//     *    POST 访问 http://localhost:3721/bus/env
//     *    发现日志：o.s.c.b.event.EnvironmentChangeListener  : Received remote environment change request. Keys/values to update {}
//     *    可见, bus/env 的 EndPoint是由 EnvironmentChangeListener 监听, 查看 EnvironmentChangeListener 源码,
//     *    监听的是 EnvironmentChangeRemoteApplicationEvent 事件
//     * @author zhangxinxin
//     * @date 2019/4/2 10:29
//     */
//    @EventListener
//    public void onEnvironmentChangeRemoteApplicationEvent(EnvironmentChangeRemoteApplicationEvent event) {
//        System.out.printf(BusConfiguration.class.getName() + "#onEnvironmentChangeRemoteApplicationEvent\r\n" +
//                        "监听事件 ->  Source: %s, OriginService: %s, DestinationService: %s\r\n",
//                event.getSource(), event.getOriginService(), event.getDestinationService());
//    }
//
//    /**
//     * @description 监听 SpringCloudBusClient.OUTPUT 管道的 AckRemoteApplicationEvent
//     * BusAutoConfiguration#acceptRemote 源码中 this.applicationEventPublisher.publishEvent(ack); 触发
//     * 会和 #onEnvironmentChangeRemoteApplicationEvent 事件一起触发
//     * 源码: this.cloudBusOutboundChannel.send(MessageBuilder.withPayload(ack).build()); 可以得知
//     * 最后 ack(即AckRemoteApplicationEvent) 会生产消息到 cloudBusOutboundChannel 中,
//     * 等 BusAutoConfiguration 生产消息后再查看其中事件发生源和目的源生
//     * @author zhangxinxin
//     * @date 2019/4/2 16:23
//     */
//    @StreamListener(SpringCloudBusClient.OUTPUT)
//    public void onAckRemoteApplicationEvent(AckRemoteApplicationEvent event) {
//        System.out.printf(BusConfiguration.class.getName() + "#onAckRemoteApplicationEvent\r\n" +
//                        "监听事件 ->  Source: %s, OriginService: %s, DestinationService: %s\r\n",
//                event.getSource(), event.getOriginService(), event.getDestinationService());
//    }
//
//    /**
//     * @description 监听 {@link UserRemoteApplicationEvent}
//     * POST 访问自定义接口 BusEventController#publishUserRemoteApplication
//     * POST 访问 http://localhost:8080/bus/event/publish/user?destination=user-service-client-application:8080
//     * json 入参 {"id": 1, "name": "sestar", "desc": "hahaha"}
//     * @author zhangxinxin
//     * @date 2019/4/2 10:29
//     */
//    @EventListener
//    public void onUserRemoteApplicationEvent(UserRemoteApplicationEvent event) {
//        System.out.printf(BusConfiguration.class.getName() + "#onUserRemoteApplicationEvent\r\n" +
//                        "监听事件 ->  Source: %s, OriginService: %s, DestinationService: %s\r\n",
//                event.getSource(), event.getOriginService(), event.getDestinationService());
//    }

}

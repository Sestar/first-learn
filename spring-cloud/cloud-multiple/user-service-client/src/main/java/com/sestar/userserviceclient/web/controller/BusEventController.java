package com.sestar.userserviceclient.web.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * @description 生成 {@link com.sestar.userapi.bus.applicationEvent.UserRemoteApplicationEvent} 事件,
 * 触发 {@link com.sestar.userserviceclient.bus.config.BusConfiguration}#onUserRemoteApplicationEvent
 * @author zhangxinxin
 * @date 2019/4/2 16:36
 **/
@RestController
public class BusEventController {
//public class BusEventController implements ApplicationContextAware, ApplicationEventPublisherAware {

//    private ApplicationContext applicationContext;
//
//    private ApplicationEventPublisher applicationEventPublisher;
//
//    /**
//     * @description applicationEventPublisher 发布自定义 RemoteApplicationEvent
//     * @author zhangxinxin
//     * @date 2019/4/8 17:32
//     * @param user 消息内容
//     * @param destination 消息目的
//     */
//    @PostMapping("/bus/event/publish/user")
//    public void publishUserRemoteApplication(@RequestBody User user,
//                                             @RequestParam(value = "destination", required = false) String destination) {
//        String originService = applicationContext.getId();
//        UserRemoteApplicationEvent userRemoteApplicationEvent = new UserRemoteApplicationEvent(user, originService, destination);
//        applicationEventPublisher.publishEvent(userRemoteApplicationEvent);
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        this.applicationContext = applicationContext;
//    }
//
//    @Override
//    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
//        this.applicationEventPublisher = applicationEventPublisher;
//    }
}

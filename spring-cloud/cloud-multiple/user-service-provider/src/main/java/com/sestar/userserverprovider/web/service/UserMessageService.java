package com.sestar.userserverprovider.web.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sestar.userapi.api.IUserService;
import com.sestar.userapi.domain.User;
import com.sestar.userserverprovider.stream.ConsumerChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/**
 * @description 用户消息订阅服务
 * @author zhangxinxin
 * @date 2019/3/12 16:34
 **/
@Service
public class UserMessageService {

    /**
     * 接收消息 stream 接口定义
     */
    private ConsumerChannel consumerChannel;

    /**
     * 用户服务接口
     */
    private IUserService userService;

    /**
     * Object -> String 工具类
     */
    private ObjectMapper objectMapper;

    /**
     * ConsumerChannel Bean会通过 @EnableBinding 生成，但是一直爆红，使用SuppressWarnings去除错误
     */
    @SuppressWarnings("all")
    @Autowired
    public UserMessageService(ConsumerChannel consumerChannel, @Qualifier("inMemoryUserService") IUserService userService,
                              ObjectMapper objectMapper) {
        this.consumerChannel = consumerChannel;
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    /**
     * @description @StreamListener 方式接收消息, 和@ServiceActivator, SubscribableChannel功能一样,
     *                  应用场景: Spring-Cloud
     * @author zhangxinxin
     * @date 2019/3/12 16:59
     */
    @StreamListener(ConsumerChannel.INPUT)
    public void onMessage(String data) {
        System.out.println(this.getClass().getName() + "#onMessage -> Subscribe by @StreamListener");
        saveUser(data);
    }

    /**
     * @description @ServiceActivator 方式接收消息, 和@StreamListener, SubscribableChannel功能一样,
     *                  应用场景: integration
     * @author zhangxinxin
     * @date 2019/3/12 16:59
     */
    @ServiceActivator(inputChannel = ConsumerChannel.INPUT)
    public void listen(String data) {
        System.out.println(this.getClass().getName() + "#listen -> Subscribe by @ServiceActivator");
        saveUser(data);
    }

    /**
     * @description SubscribableChannel 管道方式接收消息, 和@ServiceActivator, SubscribableChannel功能一样,
     *                  应用场景: messaging
     * @author zhangxinxin
     * @date 2019/3/12 16:59
     */
    @PostConstruct
    public void init() {
        // 获取管道
        SubscribableChannel channel = consumerChannel.input();
        channel.subscribe(message -> {
            System.out.println(this.getClass().getName() + "#init -> Subscribe by SubscribableChannel");
            String contentType = message.getHeaders().get("contentType", String.class);
            if ("text/plain".equals(contentType)) {
                saveUser((String) message.getPayload());
            } else {
                saveUser((byte[]) message.getPayload());
            }
        });

//        channel.subscribe(message -> {
//            if (message instanceof GenericMessage) {
//                GenericMessage genericMessage = (GenericMessage) message;
//                User user = (User) genericMessage.getPayload();
//                userService.saveUser(user);
//            }
//        });
    }

    /**
     * @description 处理MQ字节流数据
     * @author zhangxinxin
     * @date 2019/3/12 16:57
     * @param data 管道字节消息
     */
    private void saveUser(byte[] data) {
        try {
            // 将字节流数据封装成对象
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            // 反序列化 User 对象
            User user = (User) objectInputStream.readObject();
            System.out.println(this.getClass().getName() + "#saveUser -> 订阅消息内容如下: " + user);
            // 调用服务
            userService.saveUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @description 处理MQ字符串数据
     * @author zhangxinxin
     * @date 2019/3/12 16:57
     * @param data 管道字节消息
     */
    private void saveUser(String data) {
        try {
            User user = objectMapper.readValue(data, User.class);
            System.out.println(this.getClass().getName() + "#saveUser -> 订阅消息内容如下: " + user);
            userService.saveUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

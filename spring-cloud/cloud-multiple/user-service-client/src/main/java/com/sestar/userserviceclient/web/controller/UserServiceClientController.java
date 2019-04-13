package com.sestar.userserviceclient.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sestar.userapi.domain.User;
import com.sestar.userserviceclient.stream.ProducerChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description Server Client Controller
 * @author zhangxinxin
 * @date 2019/2/15 21:30
 **/
@RestController
public class UserServiceClientController {

//    /**
//     * 用户服务中心
//     **/
//    private IUserService userServer;
//
//    /**
//     * Kafka Template
//     */
//    @SuppressWarnings("all")
//    @Autowired
//    private KafkaTemplate<String, Object> kafkaTemplate;
//
    /**
     * 发送消息 stream 接口定义
     */
    private ProducerChannel producerChannel;

    /**
     * Object -> String 工具类
     */
    private ObjectMapper objectMapper;
//
//    /**
//     * JMS Template
//     */
//    private JmsTemplate jmsTemplate;
//
//    /**
//     * producerChannel Bean会通过 @EnableBinding 生成，但是一直爆红，不影响功能
//     */
    @SuppressWarnings("all")
    @Autowired
    public UserServiceClientController(ProducerChannel producerChannel, ObjectMapper objectMapper) {
        this.producerChannel = producerChannel;
        this.objectMapper = objectMapper;
    }
//
//    @PostMapping("/user/save")
//    public boolean saveUser(@RequestBody User user) {
//        return userServer.saveUser(user);
//    }
//
//    @GetMapping("/user/find/all")
//    public List<User> findAll() {
//        return userServer.findAll();
//    }
//
//    /**
//     * 测试 Hystrix 超时熔断
//     */
//    @GetMapping("/timeoutHystrix")
//    public String timeoutHystrix() throws Exception {
//        return userServer.timeoutHystrix();
//    }
//
//    /**
//     * 测试 KafkaTemplate 发送消息
//     */
//    @PostMapping("/mq/send/user")
//    public boolean sendUserByMQ(@RequestBody User user) {
//        System.out.println(this.getClass().getName() + "#sendUserByMQ 生产消息: " + user);
//        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send("replicated-topic", user);
//        return future.isDone();
//    }
//
    /**
     * 测试 Rabbit Binder 发送消息
     */
    @PostMapping("/rabbit/send/user")
    public boolean sendUserByRibbon(@RequestBody User user) throws JsonProcessingException {
        System.out.println(this.getClass().getName() + "#sendUserByRibbon 生产消息: " + user);
        MessageChannel output1 = producerChannel.output();
        // User 序列化 JSON
        String payload1 = objectMapper.writeValueAsString(user);
        GenericMessage<String> msg = new GenericMessage<>(payload1);
        // 发送消息
        return output1.send(msg);
    }
//
//    /**
//     * 测试 ActiveMQ 发送消息
//     */
//    @PostMapping("/activemq/send/user")
//    public boolean sendUserByActiveMQ(@RequestBody User user) {
//        System.out.println(this.getClass().getName() + "#sendUserByActiveMQ 生产消息: " + user);
//        jmsTemplate.convertAndSend(user);
//        return true;
//    }
//
//    /**
//     * 测试 ActiveMQ 发送消息
//     */
//    @PostMapping("/activemq/send/user/myBinder")
//    public boolean sendUserByMyBinder(@RequestBody User user) {
//        System.out.println(this.getClass().getName() + "#sendUserByMyBinder 生产消息: " + user);
//        MessageChannel messageChannel = producerChannel.output();
//        GenericMessage<User> message = new GenericMessage<>(user);
//        return messageChannel.send(message);
//    }

}

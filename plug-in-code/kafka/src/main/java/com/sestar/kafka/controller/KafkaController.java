package com.sestar.kafka.controller;

import com.sestar.kafka.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxinxin
 * @description Kafka RestController
 * @date 2019/3/11 11:08
 **/
@RestController
public class KafkaController {

    /**
     * KafkaTemplate
     */
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaController(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/mq/send/{message}")
    public String sendMq(@PathVariable String message) {
        kafkaTemplate.send("replicated-topic", message);
        return message;
    }

    @PostMapping("/mq/save/user")
    public User saveUser(@RequestBody User user) {
        kafkaTemplate.send("replicated-topic", user);
        return user;
    }

}

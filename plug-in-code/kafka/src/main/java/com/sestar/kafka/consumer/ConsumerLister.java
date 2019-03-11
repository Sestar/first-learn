package com.sestar.kafka.consumer;

import com.sestar.kafka.domain.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @description 消费者客户端(kafka-console-consumer)
 * @author zhangxinxin
 * @date 2019/3/11 16:40
 **/
@Component
public class ConsumerLister {

    @KafkaListener(topics = "replicated-topic")
    public void get(Object data) {
        System.out.println(data);
    }

}

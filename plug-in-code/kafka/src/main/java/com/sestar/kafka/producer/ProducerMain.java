package com.sestar.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @author zhangxinxin
 * @description Producer生成者发送消息
 * @date 2019/3/10 14:28
 **/
public class ProducerMain {

    public static void main(String[] args) throws Exception {
        // 1. 生成Producer对象
        // 1.1 设置Producer属性： 服务地址, key-value序列化规则
        // 参考http://kafka.apache.org/documentation.html#producerconfigs
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", StringSerializer.class);
        properties.put("value.serializer", StringSerializer.class);

        KafkaProducer<String, Object> producer = new KafkaProducer<>(properties);
        // 2. 编辑消息内容
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>("replicated-topic", "second message");
        // 3. Producer发送消息
        Future<RecordMetadata> future = producer.send(producerRecord);
        // 4. Console显示任务
        System.out.println(future.get());
    }

}

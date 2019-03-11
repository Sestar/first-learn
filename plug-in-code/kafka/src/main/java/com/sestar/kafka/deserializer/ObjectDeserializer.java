package com.sestar.kafka.deserializer;

import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 * @description 消费者接受信息反序列化
 * @author zhangxinxin
 * @date 2019/3/11 16:23
 **/
public class ObjectDeserializer implements Deserializer<Object> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        try {
            // 用 stream 解析数据
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(data);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
            Object content = objectInputStream.readObject();

            System.out.println("topic:" + topic + " -- data:" + content);
            return content;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {

    }
}

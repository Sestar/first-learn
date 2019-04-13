package com.sestar.userserviceclient.serializer;

//import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * @description 生产者发送消息序列化(Producer)
 * @author zhangxinxin
 * @date 2019/3/11 20:46
 **/
public class ObjectSerializer {
//public class ObjectSerializer implements Serializer {

//    @Override
//    public void configure(Map configs, boolean isKey) {
//
//    }
//
//    @Override
//    public byte[] serialize(String topic, Object data) {
//        try {
//            System.out.println(this.getClass().getName() + "#serialize -> 输出生产者发送的内容：\r\n" + data);
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//            objectOutputStream.writeObject(data);
//
//            return byteArrayOutputStream.toByteArray();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void close() {
//
//    }
}

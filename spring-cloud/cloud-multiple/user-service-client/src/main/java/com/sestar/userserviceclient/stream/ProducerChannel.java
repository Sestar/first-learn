package com.sestar.userserviceclient.stream;

import com.sestar.userapi.domain.User;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @description {@link User} 发送消息 stream 接口定义
 * @author zhangxinxin
 * @date 2019/3/13 16:19
 **/
public interface ProducerChannel {

    String OUTPUT = "producer-channel-1";

    @Output(OUTPUT)
    MessageChannel output();

}

package com.sestar.userserverprovider.stream;

import com.sestar.userapi.domain.User;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @description {@link User} 接收消息 stream 接口定义
 * @author zhangxinxin
 * @date 2019/3/12 16:07
 **/
public interface ConsumerChannel {

    String INPUT = "consumer-channel-1";

    // 管道
    @Input(INPUT)
    SubscribableChannel input();

}

package com.sestar.streambinderactivemq;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.stream.binder.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description Active MQ Stream Binder 自动装配
 * @author zhangxinxin
 * @date 2019/3/29 15:11
 **/
@Configuration
@ConditionalOnMissingBean(Binder.class)
public class ActiveMQStreamBinderAutoConfiguration {

    @Bean
    public ActiveMQMessageChannelBinder getActiveMQMessageChannelBinder() {
        return new ActiveMQMessageChannelBinder();
    }

}

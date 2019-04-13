package com.sestar.userapi.bus.applicationEvent;

import com.sestar.userapi.domain.User;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * @description 自定义 RemoteApplicationEvent, 实现监听 publishEvent 自定义事件
 * @author zhangxinxin
 * @date 2019/4/2 16:31
 **/
public class UserRemoteApplicationEvent extends RemoteApplicationEvent {

    /**
     * @description 必须要有一个无参数构造函数, 否则监听事件会报错
     * @author zhangxinxin
     * @date 2019/4/3 17:05
     */
    public UserRemoteApplicationEvent() {}

    public UserRemoteApplicationEvent(User user, String originService, String destinationService) {
        super(user, originService, destinationService);
    }

}

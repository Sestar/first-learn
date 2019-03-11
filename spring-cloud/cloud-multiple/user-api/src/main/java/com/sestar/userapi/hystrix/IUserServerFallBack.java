package com.sestar.userapi.hystrix;

import com.sestar.userapi.api.IUserService;
import com.sestar.userapi.domain.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @description IUserService FallBack Interface
 * @author zhangxinxin
 * @date 2019/2/18 9:55
 **/
@Component
public class IUserServerFallBack implements IUserService {

    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return Collections.emptyList();
    }

    @Override
    public String timeoutHystrix() throws Exception {
        return "user-api#UserServerFallBack time out!!!";
    }
}

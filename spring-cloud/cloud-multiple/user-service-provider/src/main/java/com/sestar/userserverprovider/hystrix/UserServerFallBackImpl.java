package com.sestar.userserverprovider.hystrix;

import com.sestar.userapi.domain.User;
import com.sestar.userapi.hystrix.IUserServerFallBack;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @description IUserService FallBack
 * @author zhangxinxin
 * @date 2019/2/19 14:23
 **/
@Component
public class UserServerFallBackImpl extends IUserServerFallBack {

    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return Collections.emptyList();
    }

    @Override
    public String timeoutHystrix() {
        return "timeoutHystrix Method Execution is cutting out!";
    }
}
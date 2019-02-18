package com.sestar.userapi.hystrix;

import com.sestar.userapi.api.IUserService;
import com.sestar.userapi.domain.User;

import java.util.Collections;
import java.util.List;

/**
 * @description IUserService FallBack
 * @author zhangxinxin
 * @date 2019/2/18 9:55
 **/
public class UserServerFallBack implements IUserService {

    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return Collections.emptyList();
    }
}

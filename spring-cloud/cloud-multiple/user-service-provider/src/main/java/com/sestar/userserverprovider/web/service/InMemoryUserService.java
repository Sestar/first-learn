package com.sestar.userserverprovider.web.service;

import com.sestar.userapi.api.IUserService;
import com.sestar.userapi.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description 用户服务
 * @author zhangxinxin
 * @date 2019/2/15 20:42
 **/
@Service("inMemoryUserService")
public class InMemoryUserService implements IUserService {

    private Map<Long, User> repository = new ConcurrentHashMap<>();

    @Override
    public boolean saveUser(User user) {
        return repository.put(user.getId(), user) == null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList(repository.values());
    }

}

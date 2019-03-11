package com.sestar.userserverprovider.web.service;

import com.sestar.userapi.api.IUserService;
import com.sestar.userapi.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description 用户服务
 * @author zhangxinxin
 * @date 2019/2/15 20:42
 **/
@Service("inMemoryUserService")
public class InMemoryUserService implements IUserService {

    /**
     * User缓存
     */
    private Map<Long, User> repository = new ConcurrentHashMap<>();

    /**
     * 随机数工具类
     **/
    private static final Random random = new Random();

    @Override
    public boolean saveUser(User user) {
        return repository.put(user.getId(), user) == null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList(repository.values());
    }

    @Override
    public String timeoutHystrix() throws Exception {
        int randomNbr = random.nextInt(200);
        System.out.println("Execution Time: " + randomNbr);
        Thread.sleep(randomNbr);
        return "randomNbr:" + randomNbr;
    }

}

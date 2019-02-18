package com.sestar.userserviceclient.web.controller;

import com.sestar.userapi.api.IUserService;
import com.sestar.userapi.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description Server Client Controller
 * @author zhangxinxin
 * @date 2019/2/15 21:30
 **/
@RestController
public class UserServiceClientController implements IUserService {

    /**
     * 用户服务中心
     **/
    @SuppressWarnings("all")
    @Autowired
    private IUserService userServer;

    @PostMapping("/user/save")
    public boolean saveUser(@RequestBody User user) {
        return userServer.saveUser(user);
    }

    @GetMapping("/user/find/all")
    public List<User> findAll() {
        return userServer.findAll();
    }

}

package com.sestar.userapi.api;

import com.sestar.userapi.domain.User;

import java.util.List;

/**
 * @description 用户服务API
 * @author zhangxinxin
 * @date 2019/2/15 18:00
 */
public interface UserServer {

    /**
     * @description 保存用户
     * @author zhangxinxin
     * @date 2019/2/15 17:59
     * @param user 用户信息
     * @return boolean
     */
    boolean saveUser(User user);

    /**
     * @description 查询所有的用户列表
     * @author zhangxinxin
     * @date 2019/2/15 17:59
     * @return java.util.List<com.sestar.userapi.domain.User>
     */
    List<User> findAll();

}
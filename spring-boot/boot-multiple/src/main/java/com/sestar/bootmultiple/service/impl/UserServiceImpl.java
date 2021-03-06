package com.sestar.bootmultiple.service.impl;

import com.sestar.bootmultiple.dao.UserDAO;
import com.sestar.bootmultiple.mapstrut.ObjectConvertMapper;
import com.sestar.bootmultiple.service.IUserService;
import com.sestar.bootmultiple.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description 用户服务实现类
 * @author zhangxinxin
 * @date 2019/5/6 19:35
 **/
@Service("userService")
public class UserServiceImpl implements IUserService {

    /**
     * 用户信息(超媒体API)
     */
    private UserVO userVO;

    @Autowired
    public UserServiceImpl(UserVO userVO) {
        this.userVO = userVO;
    }

    @Override
    public UserDAO simpleInfoOfUser() {
        return ObjectConvertMapper.INSTANCE.toDao(userVO);
    }

    @Override
    public UserVO userInfoWithLink() {
        return userVO;
    }

    @Override
    public UserVO changeUserName(String name) {
        userVO.setName(name);

        return userVO;
    }

    @Override
    public UserVO changeUserAge(Integer age) {
        userVO.setAge(age);

        return userVO;
    }
}

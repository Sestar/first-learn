package com.sestar.bootmultiple.service;

import com.sestar.bootmultiple.dao.UserDAO;
import com.sestar.bootmultiple.vo.UserVO;
import org.mapstruct.Mapping;

import java.util.Map;

/**
 * @description 用户服务接口 API
 * @author zhangxinxin
 * @date 2019/5/6 19:39
 **/
public interface IUserService {

    /**
     * 获取 UserDAO (简单的用户信息)
     */
    UserDAO simpleInfoOfUser();

    /**
     * 获取 UserVO (有超媒体API)
     */
    UserVO userInfoWithLink();

}

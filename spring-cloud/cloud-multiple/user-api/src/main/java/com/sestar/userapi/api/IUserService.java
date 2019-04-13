package com.sestar.userapi.api;

import com.sestar.userapi.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @description 用户服务API
 * @author zhangxinxin
 * @date 2019/2/15 18:00
 */
//@FeignClient(name = "${user.server.name}", fallback = IUserServerFallBack.class) // 利用占位符避免未来整合硬编码
public interface IUserService {

    /**
     * @description 保存用户
     * @author zhangxinxin
     * @date 2019/2/15 17:59
     * @param user 用户信息
     * @return boolean
     */
    @PostMapping("/user/save")
    boolean saveUser(User user);

    /**
     * @description 查询所有的用户列表
     * @author zhangxinxin
     * @date 2019/2/15 17:59
     * @return java.util.List<com.sestar.userapi.domain.User>
     */
    @GetMapping("/user/find/all")
    List<User> findAll();
//
//    /**
//     * @description 测试Hystrix超时熔断
//     * @author zhangxinxin
//     * @date 2019/2/19 13:51
//     * @return java.lang.String
//     */
//    @GetMapping("/timeoutHystrix")
//    String timeoutHystrix() throws Exception;

}
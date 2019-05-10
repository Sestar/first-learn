package com.sestar.bootmultiple.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

/**
 * @description 用户实体类
 * @author zhangxinxin
 * @date 2019/4/29 16:53
 **/
@Data
@NoArgsConstructor
public class UserDAO {

    /**
     * 账户名
     */
    private String name;

    /**
     * 用户年龄
     */
    private Integer age;

}

package com.sestar.bootmultiple.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.hateoas.ResourceSupport;

/**
 * @description 用户实体类 + Link
 * @author zhangxinxin
 * @date 2019/4/29 16:53
 **/
@Data
@NoArgsConstructor
public class UserVO extends ResourceSupport {

    /**
     * 账户名
     */
    private String name;

    /**
     * 用户年龄
     */
    private Integer age;

}

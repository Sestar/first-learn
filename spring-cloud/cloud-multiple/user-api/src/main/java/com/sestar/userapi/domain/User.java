package com.sestar.userapi.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description 实体类
 * @author zhangxinxin
 * @date 2019/1/10 14:19
 **/
@Data
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = -4961274264021393330L;

    /**
     * 账户姓名
     */
    private String name;

    /**
     * 账户标识
     */
    private Long id;

    /**
     * 账户简介, 该字段无需序列化
     */
    private transient String desc;

}

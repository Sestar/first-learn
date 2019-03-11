package com.sestar.userapi.domain;

import java.io.Serializable;

/**
 * @description 实体类
 * @author zhangxinxin
 * @date 2019/1/10 14:19
 **/
public class User implements Serializable {

    private static final long serialVersionUID = -4961274264021393330L;

    private String name;

    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

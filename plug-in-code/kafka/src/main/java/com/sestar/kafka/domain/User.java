package com.sestar.kafka.domain;

import java.io.Serializable;

/**
 * @description User Entity
 * @author zhangxinxin
 * @date 2019/3/11 10:41
 **/
public class User implements Serializable {

    /**
     * 标识
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 个人简介(无需序列化字段)
     */
    private transient String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

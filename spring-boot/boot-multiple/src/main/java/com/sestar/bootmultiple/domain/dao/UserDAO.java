package com.sestar.bootmultiple.domain.dao;

/**
 * 用户实体类
 *
 * @author zhangxinxin
 * @date 2019/4/29 16:53
 **/
public class UserDAO {

    /**
     * 账户名
     */
    private String name;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 生日
     */
    private String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}

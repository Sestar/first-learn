package com.sestar.bootmultiple.domain.vo;

import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * 用户实体类 + Link
 *
 * @author zhangxinxin
 * @date 2019/4/29 16:53
 **/
public class UserVO extends ResourceSupport {

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
    private Date birthday;

    /**
     * Ali规范:
     * 返回对存储在对象某个字段中的可变对象值的引用会暴露对象的内部表示。
     * 如果实例是由不受信任的代码访问的，并且对可变对象未经检查的更改将危及安全性或其他重要属性，则需要o做些不同的事情。
     * 在许多情况下，返回对象的新副本是更好的方法。
     *
     * @author zhangxinxin
     * @date 2020/3/14 16:24
     * @return java.util.Date
     */
    public Date getBirthday() {
        if (null == this.birthday) {
            return null;
        }
        return (Date) this.birthday.clone();
    }

    /**
     * Ali规范:
     * 此代码将对外部可变对象的引用存储到对象的内部表示中。
     * 如果实例是由不受信任的代码访问的，并且对可变对象未经检查的更改将危及安全性或其他重要属性，则需要执行其他操作。
     * 在许多情况下，存储对象的副本是更好的方法。
     *
     * @author zhangxinxin
     * @date 2020/3/14 16:24
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        if (null == birthday) {
            this.birthday = null;
        } else {
            this.birthday = (Date) birthday.clone();
        }
    }

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
}

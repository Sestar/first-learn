package com.sestar.bootmultiple.domain.entity.id;

import lombok.Data;

import javax.persistence.IdClass;
import java.io.Serializable;
import java.util.Objects;

/**
 * 测试 @IdClass 注解的复合主键类
 * 复合主键关联 CustomerNameIdClass
 * CustomerNameIdClass 以非嵌入式方式作为 CustomerNameIdClass 的复合主键类
 * 复合主键类必须实现序列化, 否则无法持久化, 就无法和数据库进行交互
 * 复合主键类必须实现 equals 和 hasCode 方法, 实现逻辑与数据库相等性一致
 *
 * @see CustomerNameIdClass
 * @see IdClass
 *
 * @author zhangxinxin
 * @date 2020/3/15 23:42
 **/
@Data
class CustomerNameIdClass implements Serializable {

    /**
     * 姓
     */
    private String firstName;

    /**
     * 名
     */
    private String secondName;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerNameIdClass that = (CustomerNameIdClass) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }

}

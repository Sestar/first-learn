package com.sestar.bootmultiple.domain.entity.id;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * 测试 @IdClass 注解的实体类
 * 复合主键关联 CustomerNameIdClass
 * CustomerNameIdClass 以非嵌入式方式作为 CustomerNameIdClass 的复合主键类
 *
 * @see CustomerNameIdClass
 * @see IdClass
 *
 * @author zhangxinxin
 * @date 2020/3/15 23:32
 **/
@Data
@Entity
@Table(name = "customer_id_class")
@IdClass(CustomerNameIdClass.class)
public class CustomerIdClass {

    /**
     * 姓
     */
    @Id
    @Column(name = "first_name")
    private String firstName;

    /**
     * 名
     */
    @Column(name = "second_name")
    private String secondName;

    /**
     * 中间名
     * 复合主键以 @IdClass 的复合主键类为主, 即使 Entity 多加 @Id, 或者少加 @Id
     */
    @Id
    @Column(name = "third_name")
    private String thirdName;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

}

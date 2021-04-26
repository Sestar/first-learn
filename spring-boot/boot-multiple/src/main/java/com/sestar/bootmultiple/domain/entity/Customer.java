package com.sestar.bootmultiple.domain.entity;

import lombok.Data;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 客户实体类
 *
 * {@link Access} 决定 {@link Column} 注解位置
 *
 * @author zhangxinxin
 * @date 2020/3/14 16:20
 **/
@Data
@Entity
@Table(name = "customer")
@Access(AccessType.FIELD)
public class Customer implements Serializable {

    /**
     * 身份证号: 自增长
     */
    @Id
    @Column(name = "id_num")
    @GeneratedValue
    private Long idNum;

    /**
     * 名
     */
    @Column(name = "second_name")
    private String secondName;

    /**
     * 姓
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * 信用卡, 一对一关联
     *
     * {@link CreditCard} 是被拥有者, 用mapperBy指定 {@link Customer} 是关联对象
     * {@link JoinColumn} 指定 {@link Customer} 与 {@link CreditCard} 关联的具体外键字段
     */
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "credit_id", referencedColumnName = "nationality")
    private CreditCard creditCard;

    /**
     * 书店
     */
    @ManyToOne
    private Store store;

}

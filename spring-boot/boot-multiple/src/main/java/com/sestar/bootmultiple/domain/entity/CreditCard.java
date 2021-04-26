package com.sestar.bootmultiple.domain.entity;

import lombok.Data;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 信用卡实体类, 和 {@link Customer} 形成一对一关系
 *
 * {@link Access} 决定 {@link Column} 注解位置
 *
 * @see javax.persistence.OneToOne
 *
 * @author zhangxinxin
 * @date 2020/3/22 20:44
 **/
@Data
@Entity
@Table(name = "credit_card")
@Access(AccessType.FIELD)
public class CreditCard implements Serializable {

    /**
     * 信用卡号
     */
    @Id
    @Column(name = "cert_num")
    @GeneratedValue
    private Long certNum;

    /**
     * 证件国籍
     */
    @Column(name = "nationality")
    private String nationality;

    /**
     * 关联客户实体, 信用卡实体处于【被拥有方】, 所以 @OneToOne 注解在信用卡中
     * 级联关系是只要发生变化都级联进行改变, mappedBy = 客户对应的属性名, 客户的信用卡外键自动设置为信用卡主键
     *
     * {@link OneToOne#mappedBy()} 和 {@link JoinColumn}冲突, {@link OneToOne#mappedBy()}有效, {@link JoinColumn}注解无效
     */
    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "creditCard")
    @JoinColumn(name = "cust_id", referencedColumnName = "secondName")
    private Customer customer;

}

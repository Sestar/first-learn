package com.sestar.bootmultiple.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * 店铺实体类
 * {@link Customer} 形成 一对多双向关系
 *
 * @author zhangxinxin
 * @date 2020/3/29 23:29
 **/
@Data
@Entity
@Table(name = "store")
public class Store implements Serializable {

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 客户
     */
    @OneToMany(mappedBy = "store")
    private List<Customer> customers;

}

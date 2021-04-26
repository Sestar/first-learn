package com.sestar.bootmultiple.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * 酒店实体
 * {@link Customer} 形成 一对多单向关系
 *
 * @author zhangxinxin
 * @date 2020/3/29 23:40
 **/
@Data
@Entity
@Table(name = "clothes")
public class Hotel implements Serializable {

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
    @OneToMany
    private List<Customer> customers;

}

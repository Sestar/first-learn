package com.sestar.bootmultiple.domain.entity;

import com.sestar.bootmultiple.domain.entity.listener.BookListener;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * 图书实体
 *
 * {@link Customer} 形成单向多对多关系
 * {@link BookListener} 图书实体监听器
 *
 * @author zhangxinxin
 * @date 2020/3/30 0:16
 **/
@Data
@Entity
@Table(name = "book")
@EntityListeners({BookListener.class})
public class Book implements Serializable {

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
    @ManyToMany
    private List<Customer> customers;

}

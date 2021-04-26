package com.sestar.bootmultiple.domain.entity.id;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 测试 @EmbeddedId 注解的实体类
 * 复合主键关联 CustomerNameIdClass
 * CustomerNameEmbeddedId 以嵌入式方式作为 CustomerEmbeddedId 的复合主键类
 *
 * @see CustomerNameEmbeddedId
 * @see EmbeddedId
 *
 * @author zhangxinxin
 * @date 2020/3/16 0:01
 **/
@Data
@Entity
@Table(name = "customer_embedded_id")
class CustomerEmbeddedId {

    /**
     * 嵌入式复合主键类
     */
    @EmbeddedId
    private CustomerNameEmbeddedId customerNameEmbeddedId;

    /**
     * 小名
     */
    @Column(name = "pet_name")
    private String petName;

}

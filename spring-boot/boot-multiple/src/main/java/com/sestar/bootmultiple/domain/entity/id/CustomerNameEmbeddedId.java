package com.sestar.bootmultiple.domain.entity.id;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

/**
 * 测试 @EmbeddedId 注解的实体类
 * 复合主键关联 CustomerNameIdClass
 * CustomerNameEmbeddedId 以嵌入式方式作为 CustomerEmbeddedId 的复合主键类
 *
 * @see CustomerEmbeddedId
 * @see EmbeddedId
 *
 * @author zhangxinxin
 * @date 2020/3/16 0:01
 **/
@Data
class CustomerNameEmbeddedId implements Serializable {

    /**
     * 姓
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * 名
     */
    @Column(name = "second_name")
    private String secondName;

}

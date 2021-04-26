package com.sestar.bootmultiple.domain.entity.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;

import com.sestar.bootmultiple.domain.entity.Book;

/**
 * 图书实体监听器
 *
 * {@link Book}
 *
 * @author zhangxinxin
 * @date 2020/3/30 0:29
 **/
public class BookListener {

    /**
     * 保存对象前操作
     *
     * @author zhangxinxin
     * @date 2020/3/30 0:32
     * @param obj 实体对象
     */
    @PrePersist
    public void prePersist(Object obj) {
        System.out.println("@PrePersist: " + obj);
    }

    /**
     * 保存对象后操作
     *
     * @author zhangxinxin
     * @date 2020/3/30 0:32
     * @param obj 实体对象
     */
    @PostPersist
    public void postPersist(Object obj) {
        System.out.println("@PostPersist: " + obj);
    }

    /**
     * 删除对象前操作
     *
     * @author zhangxinxin
     * @date 2020/3/30 0:32
     * @param obj 实体对象
     */
    @PreRemove
    public void preRemove(Object obj) {
        System.out.println("@PreRemove: " + obj);
    }

    /**
     * 删除对象后操作
     *
     * @author zhangxinxin
     * @date 2020/3/30 0:32
     * @param obj 实体对象
     */
    @PostRemove
    public void postRemove(Object obj) {
        System.out.println("@PostRemove: " + obj);
    }

    /**
     * 更新对象前操作
     *
     * @author zhangxinxin
     * @date 2020/3/30 0:32
     * @param obj 实体对象
     */
    @PostLoad
    public void postLoad(Object obj) {
        System.out.println("@PostLoad: " + obj);
    }

}

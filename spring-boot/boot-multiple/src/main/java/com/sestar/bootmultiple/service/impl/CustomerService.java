package com.sestar.bootmultiple.service.impl;

import com.sestar.bootmultiple.domain.entity.CreditCard;
import com.sestar.bootmultiple.domain.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 客户-Service
 *
 * @author zhangxinxin
 * @date 2020/3/26 23:48
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomerService {

    @PersistenceContext(name = "account")
    private EntityManager entityManager;

    /**
     * 保存客户实例
     *
     * @author zhangxinxin
     * @date 2020/3/26 23:53
     * @param customer 客户实例
     */
    public void save(Customer customer) {
        if (null != customer && null != customer.getCreditCard()) {
            entityManager.persist(customer.getCreditCard());
        }
        entityManager.persist(customer);
    }

    /**
     * 通过客户标识查找客户
     *
     * @author zhangxinxin
     * @date 2020/3/26 23:54
     * @param id 客户标识
     * @return com.sestar.bootmultiple.domain.entity.Customer
     */
    public Customer findCustomerById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    /**
     * 删除客户
     *
     * {@link EntityManager#remove(Object)} 删除首先得先通过主键获取数据, 再进行删除
     * 如果不传主键, 主键会是自动生成的内容, 导致 {@link EntityManager#remove(Object)} 没有删除任何内容,
     * 因为数据中不会有主键会和新的自动生成得到的主键相同
     *
     * @author zhangxinxin
     * @date 2020/3/26 23:54
     * @param customer) 客户
     */
    public void remove(Customer customer) {
        entityManager.remove(entityManager.find(CreditCard.class, customer.getCreditCard().getCertNum()));
        entityManager.remove(entityManager.merge(customer));
    }

}

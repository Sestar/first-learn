package com.sestar.bootmultiple.service.impl;

import com.sestar.bootmultiple.domain.entity.CreditCard;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 信用卡服务
 *
 * {@link com.sestar.bootmultiple.domain.entity.CreditCard}
 *
 * @author zhangxinxin
 * @date 2020/3/29 14:19
 **/
@Service("creditCardService")
@Transactional(rollbackFor = Exception.class)
public class CreditCardService {

    @PersistenceContext(name = "account")
    private EntityManager entityManager;

    /**
     * 新增信用卡
     *
     * @author zhangxinxin
     * @date 2020/3/29 16:03
     * @param creditCard 信用卡对象
     */
    public void save(CreditCard creditCard) {
        if (null != creditCard && null != creditCard.getCustomer()) {
            entityManager.persist(creditCard.getCustomer());
        }
        entityManager.persist(creditCard);
    }

    /**
     * 通过主键查询信用卡
     *
     * @author zhangxinxin
     * @date 2020/3/29 16:03
     * @param certNum 信用卡主键
     */
    public CreditCard findById(Long certNum) {
        return entityManager.find(CreditCard.class, certNum);
    }

    /**
     * 删除信用卡
     *
     * @author zhangxinxin
     * @date 2020/3/29 16:03
     * @param creditCard 信用卡
     */
    public void remove(CreditCard creditCard) {
        entityManager.remove(entityManager.merge(creditCard));
    }

}

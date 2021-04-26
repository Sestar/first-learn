package com.sestar.bootmultiple.repository;

import com.sestar.bootmultiple.domain.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * 图书仓储
 *
 * {@link Book}
 *
 * @author zhangxinxin
 * @date 2020/3/30 0:42
 **/
@Repository
public class BookReposity extends SimpleJpaRepository<Book, Long> {

    @Autowired
    public BookReposity(EntityManager em) {
        super(Book.class, em);
    }

}

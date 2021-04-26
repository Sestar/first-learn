package com.sestar.bootmultiple.service.impl;

import com.sestar.bootmultiple.domain.entity.Book;
import com.sestar.bootmultiple.repository.BookReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图书服务
 *
 * @author zhangxinxin
 * @date 2020/3/30 0:40
 **/
@Service("bookService")
public class BookService {

    /**
     * 图书仓储
     */
    private final BookReposity bookRepo;

    @Autowired
    public BookService(BookReposity bookRepo) {
        this.bookRepo = bookRepo;
    }

    /**
     * 保存
     *
     * @author zhangxinxin
     * @date 2020/3/30 0:46
     * @param book 实体对象
     */
    public void save(Book book) {
        bookRepo.save(book);
    }

    /**
     * 删除
     *
     * @author zhangxinxin
     * @date 2020/3/30 0:46
     * @param book 实体对象
     */
    public void remove(Book book) {
        bookRepo.delete(book);
    }

    /**
     * 获取所有
     *
     * @author zhangxinxin
     * @date 2020/3/30 0:46
     * @return java.util.List<com.sestar.bootmultiple.domain.entity.Book>
     */
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

}

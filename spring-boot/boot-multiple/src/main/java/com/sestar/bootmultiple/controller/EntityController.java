package com.sestar.bootmultiple.controller;

import com.sestar.bootmultiple.domain.entity.Book;
import com.sestar.bootmultiple.domain.entity.CreditCard;
import com.sestar.bootmultiple.domain.entity.Customer;
import com.sestar.bootmultiple.service.impl.BookService;
import com.sestar.bootmultiple.service.impl.CreditCardService;
import com.sestar.bootmultiple.service.impl.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户-Controller
 *
 * @author zhangxinxin
 * @date 2020/3/26 23:47
 **/
@RestController
@RequestMapping("entity")
public class EntityController {

    /**
     * 客户服务
     */
    private final CustomerService customerService;

    /**
     * 信用卡服务
     */
    private final CreditCardService creditCardService;

    /**
     * 图书服务
     */
    private final BookService bookService;

    @Autowired
    public EntityController(CustomerService customerService, CreditCardService creditCardService, BookService bookService) {
        this.customerService = customerService;
        this.creditCardService = creditCardService;
        this.bookService = bookService;
    }

    @PostMapping("customer/save")
    @ApiOperation("保存客户")
    public Customer save(@RequestBody Customer customer) {
        customerService.save(customer);

        return customerService.findCustomerById(customer.getIdNum());
    }

    @PostMapping("customer/remove")
    @ApiOperation("删除客户")
    public void remove(@RequestBody Customer customer) {
        customerService.remove(customer);
    }

    @PostMapping("creditCard/save")
    @ApiOperation("保存信用卡")
    public CreditCard save(@RequestBody CreditCard creditCard) {
        creditCardService.save(creditCard);

        return creditCardService.findById(creditCard.getCertNum());
    }

    @PostMapping("creditCard/remove")
    @ApiOperation("删除客户")
    public void remove(@RequestBody CreditCard creditCard) {
        creditCardService.remove(creditCard);
    }

    @PostMapping("book/save")
    @ApiOperation("保存图书")
    public void save(@RequestBody Book book) {
        bookService.save(book);
    }

    @PostMapping("book/remove")
    @ApiOperation("删除图书")
    public void remove(@RequestBody Book book) {
        bookService.remove(book);
    }

    @PostMapping("book/findAll")
    @ApiOperation("获取所有图书")
    public List<Book> findAll() {
        return bookService.findAll();
    }

}

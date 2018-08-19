package com.cloud.controller;

import com.cloud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2018/8/16
 */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String home() {
        return "Hello book";
    }


    @RequestMapping("/queryBookFeign")
    public String queryBookFeign() {
        return "query book feign";
    }


    @RequestMapping("/queryBookA")
    public String queryBookA() {
        return "query book A";
    }


    @RequestMapping("/queryHystrixBook")
    public String queryHystrixBook() throws InterruptedException {
        Thread.sleep(1000*10);
        System.out.println("---hystrix-----");
        return "query book hystrix";
    }




}

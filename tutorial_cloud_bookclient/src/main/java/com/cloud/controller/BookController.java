package com.cloud.controller;

import com.cloud.feign.BookFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2018/8/16
 */
@RestController
public class BookController {

    @Autowired
    BookFeignService bookFeignService;

    @RequestMapping("/")
    public String home() {
        return "Hello book";
    }


    @GetMapping("/feignTest")
    public String feignTest() {
        return bookFeignService.book();
    }
}

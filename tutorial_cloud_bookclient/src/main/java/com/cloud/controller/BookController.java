package com.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2018/8/16
 */
@RestController
public class BookController {

    @RequestMapping("/")
    public String home() {
        return "Hello book";
    }


    @RequestMapping("/queryBookFeign")
    public String queryBookFeign() {
        return "query book feign";
    }


}

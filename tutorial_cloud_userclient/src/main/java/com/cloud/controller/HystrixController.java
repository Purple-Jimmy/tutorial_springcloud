package com.cloud.controller;

import com.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimmy
 * @date 2018/8/1922:10
 */
@RestController
public class HystrixController {
    @Autowired
    UserService userService;

    @RequestMapping("/queryHystrixA")
    public String queryHystrixA(){
        return userService.hystrix_a();
    }
}

package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2018/8/10
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class AppStart {

    public static void main(String[] args) {
        SpringApplication.run(AppStart.class,args);
    }

    @RequestMapping("/")
    public String home() {
        return "Hello app";
    }
}

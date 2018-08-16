package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * book 服务
 * @Author: jimmy
 * @Date: 2018/8/10
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BookServerStart {

    public static void main(String[] args) {
        SpringApplication.run(BookServerStart.class,args);
    }


}

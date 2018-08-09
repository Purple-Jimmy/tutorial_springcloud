package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: jimmy
 * @Date: 2018/8/9
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RegisterCenterStart {
    public static void main(String[] args) {
        SpringApplication.run(RegisterCenterStart.class,args);
    }
}

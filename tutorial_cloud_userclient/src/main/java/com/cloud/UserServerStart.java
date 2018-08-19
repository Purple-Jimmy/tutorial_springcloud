package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jimmy
 * @Date: 2018/8/10
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
@EnableCircuitBreaker
public class UserServerStart {

    public static void main(String[] args) {
        SpringApplication.run(UserServerStart.class,args);
    }

    @RequestMapping("/")
    public String home() {
        return "Hello user";
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

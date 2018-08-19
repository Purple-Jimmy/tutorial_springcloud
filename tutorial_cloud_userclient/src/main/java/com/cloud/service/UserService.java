package com.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author jimmy
 * @date 2018/8/1922:04
 */
@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackHystrix_a")
    public String hystrix_a(){
        return restTemplate.getForObject("http://localhost:1111/queryHystrixBook", String.class);
    }


    public String fallbackHystrix_a() {
        return "fallback hystrix a";
    }
}

package com.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jimmy
 * @date 2018/8/1622:48
 */
@RestController
public class UserController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/dc")
    public String dc() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("book-server");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/queryBookFeign";
      //  String url = "http://localhost:1111/queryBookFeign";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

}

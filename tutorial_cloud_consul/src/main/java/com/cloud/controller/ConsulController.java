package com.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimmy
 * @date 2018/8/1622:08
 */
@RestController
public class ConsulController {
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * 查询注册中心中的服务
     * @return
     */
    @GetMapping("/showServers")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        //Services: [book-client, consul, consul-server]
        ServiceInstance serviceInstance = loadBalancerClient.choose("server-book");
        System.out.println(serviceInstance);
        return services;
    }

}

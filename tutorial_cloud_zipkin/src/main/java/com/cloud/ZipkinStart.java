package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author jimmy
 * @date 2018/8/2022:13
 * https://blog.csdn.net/hxpjava1/article/details/80953056
 * https://www.jianshu.com/p/9bfe103418e2
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZipkinServer
@RestController
public class ZipkinStart {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinStart.class,args);
    }

    @RequestMapping("/health")
    public void healthCheck(){

    }
}

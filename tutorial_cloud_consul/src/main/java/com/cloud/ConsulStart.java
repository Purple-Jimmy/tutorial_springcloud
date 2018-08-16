package com.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: jimmy
 * @Date: 2018/8/9
 * https://blog.csdn.net/zjcjava/article/details/78608892
 * https://yq.aliyun.com/articles/334533
 * https://blog.csdn.net/xp_lx1/article/details/81195768
 * https://blog.csdn.net/valada/article/details/80878737
 * http://soft.dog/2016/03/19/consul-cluster/
 * https://blog.csdn.net/ityouknow/article/details/81125446
 * http://www.cnblogs.com/sunsky303/p/9209024.html
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Slf4j
public class ConsulStart {
    public static void main(String[] args) {
        log.info("hhhhhh");
        SpringApplication.run(ConsulStart.class,args);
    }

    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    @RequestMapping("/health")
    public String health() {
        return "hello health ";
    }
}

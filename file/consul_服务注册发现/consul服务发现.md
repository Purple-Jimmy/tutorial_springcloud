### consul 服务发现
* 引入依赖
```
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-consul-discovery</artifactId>
</dependency>
```

* 添加注解 服务A的启动类添加:@EnableDiscoveryClient
```
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulStart {
    public static void main(String[] args) {
        SpringApplication.run(ConsulStart.class,args);
    }
}
```

* 配置文件 
```
spring:
  cloud:
    consul:
      host: xxx
      port: xxx
      discovery:
        enabled: true
        service-name: consul-server #注册中心注册的服务名字
       # health-check-path: /health
        health-check-interval: 10s
        instance-id: consul-server-id
        tags: dev,hello
```

* 访问consul ip查看注册上的服务

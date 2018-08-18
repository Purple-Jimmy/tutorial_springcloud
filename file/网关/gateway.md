### gateway 
http://www.spring4all.com/article/1296

> 访问网关服务gateway-server 8080 路由到book-server服务

* 引入依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
```

* 配置文件 gateway-server 
```
spring:
   cloud:
     gateway:
       routes:
       - id: host_route
         uri: http://localhost:1111
         predicates:
         - Path=/book/**
         filters:
         - StripPrefix=1
       - id: host_route
         uri: http://localhost:2222
         predicates:
         - Path=/user/**
         filters:
         - StripPrefix=1
```
* 访问 http://ip:port/book/queryBookA

> 配置详解
* id:固定,不同 id 对应不同的功能
* uri:目标服务地址
* predicates:路由条件
* filters:过滤规则

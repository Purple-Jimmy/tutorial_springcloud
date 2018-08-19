### hystrix 服务降级

> user-server 调用 book-server 的queryHystrixBook方法

* 引入依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
```

* 添加注解 user-server启动类添加:@EnableCircuitBreaker或者@EnableHystrix

* @HystrixCommand 声明user-server调用book-server服务提供的方法queryHystrixBook失败后调用的方法
```
@HystrixCommand(fallbackMethod = "fallbackHystrix_a")
public String hystrix_a(){
    return restTemplate.getForObject("http://localhost:1111/queryHystrixBook", String.class);
}


public String fallbackHystrix_a() {
    return "fallback hystrix a";
}
```

访问user-server提供的方法queryHystrixA,会调用book-server的queryHystrixBook方法.  
queryHystrixBook方法延迟10s返回结果,fallbackHystrix_a就会被触发
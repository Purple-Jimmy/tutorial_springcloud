### feign 负载均衡
> user-server 调用 book-server

* 引入依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-feign</artifactId>
</dependency>
```

* 添加注解 user-server启动类添加:@EnableFeignClients
```
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class UserServerStart {
    public static void main(String[] args) {
        SpringApplication.run(UserServerStart.class,args);
    }
}
```

* 配置文件 user-server和book-server分别向注册中心注册

* user-server声明feign接口 server-book为book服务中yml配置的server.application.name
```
@FeignClient("server-book")
@Service
public interface BookServerFeign {

    @GetMapping("/queryBookFeign")
    String queryBookFeign();
}
```

* user-server调用
```
@RestController
public class FeignController {
    @Autowired
    BookServerFeign bookServerFeign;
    
    @RequestMapping("/queryBook")
    public void queryBook(){
        String str = bookServerFeign.queryBookFeign();
        System.out.println(str);
    }
}
```

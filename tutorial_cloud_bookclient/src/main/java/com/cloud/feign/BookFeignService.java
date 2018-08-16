package com.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: jimmy
 * @Date: 2018/8/16
 */
@FeignClient(name="book-server")
@Service
public interface BookFeignService {
    @GetMapping("/book")
    String book();
}

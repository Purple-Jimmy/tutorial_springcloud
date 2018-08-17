package com.cloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author jimmy
 * @date 2018/8/1622:58
 */
@FeignClient("book-server")
@Service
public interface BookServerFeign {

    @GetMapping("/queryBookFeign")
    String queryBookFeign();
}

package com.cloud.controller;

import com.cloud.feign.BookServerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jimmy
 * @date 2018/8/1623:02
 */
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

package com.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置中心
 * @Author: jimmy
 * @Date: 2018/8/9
 */
@SpringBootApplication
@EnableConfigServer
@Slf4j
public class ConfigurerCenterStart {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigurerCenterStart.class).run(args);
        log.info("-=========hahah");
    }
}

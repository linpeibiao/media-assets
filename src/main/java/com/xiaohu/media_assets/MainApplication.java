package com.xiaohu.media_assets;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiaohu
 * @date 2023/03/04/ 23:15
 * @description
 */
@SpringBootApplication
@MapperScan("com.xiaohu.media_assets.mapper")
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}

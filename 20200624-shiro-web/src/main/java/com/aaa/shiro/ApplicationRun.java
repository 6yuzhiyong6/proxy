package com.aaa.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: Mr.Yu
 * @Date: 2020/6/24 11:32
 * @description
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.aaa.shiro.mapper")
public class ApplicationRun {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class, args);
    }
}


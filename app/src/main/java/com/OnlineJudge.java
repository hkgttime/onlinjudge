package com;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("org.oj.mapper")
public class OnlineJudge {
    public static void main(String[] args) {
        SpringApplication.run(OnlineJudge.class);
    }
}

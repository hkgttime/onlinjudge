package com;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.oj.mapper")
public class OnlineJudge {
    public static void main(String[] args) {
        SpringApplication.run(OnlineJudge.class);
    }
}

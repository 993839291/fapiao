package com.example.demonew;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.demonew.dao")
@SpringBootApplication
public class DemoNewApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoNewApplication.class, args);
    }

}

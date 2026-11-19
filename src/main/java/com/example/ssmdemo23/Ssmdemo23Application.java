 package com.example.ssmdemo23;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.ssmdemo23.demos.mapper")

@SpringBootApplication
public class Ssmdemo23Application {

    public static void main(String[] args) {
        SpringApplication.run(Ssmdemo23Application.class, args);
    }

}

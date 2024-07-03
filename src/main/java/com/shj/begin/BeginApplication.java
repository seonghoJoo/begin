package com.shj.begin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BeginApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeginApplication.class, args);
    }

}

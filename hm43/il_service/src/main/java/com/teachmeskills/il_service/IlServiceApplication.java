package com.teachmeskills.il_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IlServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IlServiceApplication.class, args);
    }

}

package com.lts.outworld_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.lts")
public class OutWorldAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(OutWorldAuthApplication.class, args);
    }

}

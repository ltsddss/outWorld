package com.lts.outworld_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OutWorldEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(OutWorldEurekaApplication.class, args);
    }
}

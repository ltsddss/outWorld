package com.lts.outworld_getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OutWorldGetwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(OutWorldGetwayApplication.class, args);
    }

}

package com.lts.outworld_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OutWorldSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(OutWorldSystemApplication.class, args);
        System.out.println("**********系统模块启动成功*************");
    }
}

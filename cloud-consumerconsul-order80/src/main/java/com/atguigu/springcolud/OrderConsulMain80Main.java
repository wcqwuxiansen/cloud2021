package com.atguigu.springcolud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80Main {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80Main.class,args);
    }
}
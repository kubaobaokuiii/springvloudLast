package com.zgd.springcloud.eurekaClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * eureka client 客户端
 */
@EnableEurekaClient
@SpringBootApplication
public class Client02App {

    public static void main(String[] args) {
        SpringApplication.run(Client02App.class, args);
    }
}

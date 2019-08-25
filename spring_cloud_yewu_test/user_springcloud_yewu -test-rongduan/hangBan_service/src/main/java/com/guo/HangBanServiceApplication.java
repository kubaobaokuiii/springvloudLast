package com.guo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HangBanServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HangBanServiceApplication.class, args);
    }

}

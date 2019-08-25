package com.zgd.springcloud.eureka.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * eureka client 客户端
 */
@SpringBootApplication
@EnableEurekaServer
public class ConfigEureka {

    public static void main(String[] args) {
        SpringApplication.run(ConfigEureka.class, args);
    }

}

package com.zgd.springcloud.eurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka server 服务器
 * @author zgd
 */
@EnableEurekaServer
@SpringBootApplication
public class ServerApp {

    public static void main(String[] args) {
        SpringApplication.run(ServerApp.class);
    }
}

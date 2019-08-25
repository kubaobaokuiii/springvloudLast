package com.zgd.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;


/**
 * service-gateway 客户端
 * @author zgd
 */
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.zgd.springcloud.gateway"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}

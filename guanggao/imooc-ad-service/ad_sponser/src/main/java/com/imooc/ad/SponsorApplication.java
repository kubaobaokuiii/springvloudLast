package com.imooc.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 发起者的启动类
 */
@SpringBootApplication
@EnableFeignClients  //启动此注解是为了实现监控（也有可以进行调用其他服务的意思，在此没有）
@EnableEurekaClient
@EnableCircuitBreaker
public class SponsorApplication {

    public static void main(String[] args){

        SpringApplication.run(SponsorApplication.class,args);

    }


}

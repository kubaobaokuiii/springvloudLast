package com.zgd.springcloud.eurekaClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * eureka client 客户端
 */
@EnableDiscoveryClient
@EnableEurekaClient
//开启hystrix熔断
@EnableHystrix
@SpringBootApplication
public class RibbonApp {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApp.class, args);
    }

    /**
     * 使用restTemplate消费方法
     * @return
     *  @LoadBalanced 负载均衡
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

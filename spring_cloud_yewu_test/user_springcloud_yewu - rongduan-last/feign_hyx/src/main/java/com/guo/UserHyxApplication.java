package com.guo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 熔断监控启动类
 */
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class UserHyxApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserHyxApplication.class, args);
    }

    /**
     *
     * @return在使用springcloud ribbon客户端负载均衡的时候，
     * 可以给RestTemplate bean 加一个@LoadBalanced注解，
     * 就能让这个RestTemplate在请求时拥有客户端负载均衡的能力：
     * 我采用的是feign客户端，故不需要此，因为feign自带熔断功能
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {

        return new RestTemplate();
    }

}

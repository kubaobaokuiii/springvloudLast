package com.guo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 是spring cloud启动注解
 */
@SpringCloudApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ZuulServiceApplication {

    public static void main(String[] args){

        SpringApplication.run(ZuulServiceApplication.class,args);
    }
}

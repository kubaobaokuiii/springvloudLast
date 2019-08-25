package com.zgd.springcloud.eurekaClient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者
 * @author zgd
 */
@RestController
@RequestMapping("/client1")
public class ProducerController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name){
        return "hi "+name+",i am from port:" + port;
    }

}

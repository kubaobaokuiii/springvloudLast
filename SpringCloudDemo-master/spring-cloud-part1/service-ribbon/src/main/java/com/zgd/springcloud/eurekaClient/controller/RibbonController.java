package com.zgd.springcloud.eurekaClient.controller;

import com.zgd.springcloud.eurekaClient.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RibbonController {

    @Autowired
    HelloService helloService;

    /**
     * 通过service层,用restTemplate访问Client01路由,间接调用了Client01工程的方法
     * @param name
     * @return
     */
    @GetMapping(value = "/getHello")
    public String getHello(@RequestParam String name) {
        return helloService.hiService( name );
    }

}

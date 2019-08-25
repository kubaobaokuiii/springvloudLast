package com.zgd.springcloud.eurekaClient.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {


    /**
     * 用来访问其他mvc路由,获得远程方法执行后的值
     */
    @Autowired
    RestTemplate restTemplate;


    public String hiService(String name) {
        //eureka-client-01工程的applicationName
        String client01Name = "client01";
        //eureka-client-01工程的ProducerController的路由
        String prefix1 = "client1" ;
        //eureka-client-01工程的ProducerController的hello方法的路由
        String prefix2 = "hello";

        //访问eureka-client-01的路由,远程调用eureka-client-01的方法
        return restTemplate.getForObject("http://"+client01Name+"/"+prefix1+"/"+prefix2+"?name="+name,String.class);
    }
}

package com.zgd.springcloud.eurekaClient.interf;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @FeignClient value是指定的服务提供者在eurekaServer中的服务名,eureka-client-01的applicationName就是client01
 */
@FeignClient(value = "client01")
@Component
public interface FeignService{

    /**
     * 这里还是访问的eureka-client-01的
     *      com.zgd.springcloud.eurekaClient.controller.ProducerController
     *      的hello方法的路由
     * @param name
     * @return
     */
    @RequestMapping(value = "/client1/hello",method = RequestMethod.GET)
    String hiService(@RequestParam(value = "name") String name);
}

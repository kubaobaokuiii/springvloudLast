package com.zgd.springcloud.eurekaClient.controller.service;

import com.zgd.springcloud.eurekaClient.controller.service.hystrix.FeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @FeignClient value是指定的服务提供者在eurekaServer中的服务名,eureka-client-01的applicationName就是client01
 */
@FeignClient(name = "client01",fallback = FeignServiceImpl.class)
public interface FeignService{

    /**
     * 这里还是访问的eureka-client-01的
     *      com.zgd.springcloud.eurekaClient.controller.ProducerController
     *      的hello方法的路由
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hiService(@RequestParam(value = "name") String name);

    /**
     * 测试springcloud的超时机制
     * @param mills
     * @return
     */
    @RequestMapping(value = "/timeOut",method = RequestMethod.GET)
    String timeOut(@RequestParam(value = "mills") int mills);
}

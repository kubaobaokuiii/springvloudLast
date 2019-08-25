package com.zgd.springcloud.eurekaClient.controller;

import com.zgd.springcloud.eurekaClient.interf.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FeignController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

    @Autowired
    FeignService feignService;
    /**
     * 通过service层,用restTemplate访问Client01路由,间接调用了Client01工程的方法
     * @param name
     * @return
     */
    @RequestMapping(value = "/getHi",method = RequestMethod.GET)
    public String getHi(@RequestParam String name) {
        return feignService.hiService( name );
    }

}

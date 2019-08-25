package com.zgd.springcloud.eurekaClient.controller;

import com.zgd.springcloud.eurekaClient.controller.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
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


    /**
     * 测试重试时间
     * @return
     */
    @RequestMapping("/timeOut")
    public String timeOut(@RequestParam int mills){
        log.info("开始调用");
        return feignService.timeOut( mills );
    }

}

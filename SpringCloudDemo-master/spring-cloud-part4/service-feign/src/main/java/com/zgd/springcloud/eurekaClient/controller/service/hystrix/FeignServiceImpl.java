package com.zgd.springcloud.eurekaClient.controller.service.hystrix;

import com.zgd.springcloud.eurekaClient.controller.service.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {

    @Override
    public String hiService(String name) {
        return name+",这里被熔断了";
    }

    @Override
    public String timeOut(int mills) {
        System.out.println("熔断");
        return "熔断了";
    }
}

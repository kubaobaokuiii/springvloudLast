package com.zgd.springcloud.eurekaClient.imp;

import com.zgd.springcloud.eurekaClient.interf.FeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {

    @Override
    public String hiService(String name) {
        return name+",这里被熔断了";
    }
}

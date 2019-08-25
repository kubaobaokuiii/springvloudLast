package com.zgd.springcloud.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zgd
 * @Date: 2019/1/10 10:25
 * @Description:
 */
@RestController
public class GatewayController {

  @RequestMapping("/fallback")
  public String fallback(){
    return "fallback";
  }

}

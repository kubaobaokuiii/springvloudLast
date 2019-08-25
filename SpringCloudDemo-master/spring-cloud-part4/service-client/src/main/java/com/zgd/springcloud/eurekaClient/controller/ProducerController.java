package com.zgd.springcloud.eurekaClient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者
 *
 * @author zgd
 */
@RestController
@Slf4j
public class ProducerController {

  @Value("${server.port}")
  String port;

  @RequestMapping("/hello")
  public String hello(@RequestParam String name) {
    log.info("[client服务-{}] [hello方法]收到请求", port);
    return "hi " + name + ",i am from port:" + port;
  }


  @RequestMapping("/hi")
  public String hi(@RequestParam String name) {
    log.info("[client服务] [hi方法]收到请求");
    return "hi " + name + ",i am from service-client";
  }


  /**
   * 测试重试时间
   *
   * @return
   */
  @RequestMapping("/timeOut")
  public String timeOut(@RequestParam int mills) {
    log.info("[client服务-{}] [timeOut方法]收到请求,阻塞{}ms", port, mills);
    try {
      Thread.sleep(mills);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    log.info("[client服务-{}] [timeOut]返回请求",port);
    return String.format("client服务-%s 请求ok!!!", port);
  }

}

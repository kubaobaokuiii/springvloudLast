package com.zgd.springcloud.config.eurekaclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务提供者
 *
 * @author zgd
 */
@RestController
@Slf4j
@RefreshScope
public class ConfigController {

  @Value("${file.name}")
  private String name;

  @RequestMapping(value = "/get_config_name")
  public String getConfigName(){
    return name;
  }

}

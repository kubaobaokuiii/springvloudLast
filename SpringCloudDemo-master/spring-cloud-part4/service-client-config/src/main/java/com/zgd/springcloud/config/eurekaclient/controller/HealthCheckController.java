package com.zgd.springcloud.config.eurekaclient.controller;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;


/**
 * @Author: zgd
 * @Date: 18/11/17 17:43
 * @Description:
 */
@Component
@Slf4j
public class HealthCheckController implements  HealthIndicator {

  @Override
  public Health health() {
    log.info("--健康检查--");
    //模拟数据库链接状态
    if (RandomUtils.nextInt() % 2 == 0) {
      return Health.status(Status.UP).build();
    } else {
      return Health.status(Status.DOWN).build();
    }
  }

}

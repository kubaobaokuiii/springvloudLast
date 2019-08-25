package com.zgd.springcloud.eurekaClient.controller;
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
    //模拟数据库链接状态
//    if (RandomUtils.nextInt() % 2 == 0) {
    if (true) {
      log.info("--健康检查-- 状态正常");
      return Health.status(Status.UP).build();
    } else {
      log.info("--健康检查-- 状态异常");
      return Health.status(Status.DOWN).build();
    }
  }

}

package com.zgd.springcloud.gateway.config;

import com.zgd.springcloud.gateway.filter.RateLimitByIpGatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;


/**
 * @Author: zgd
 * @Date: 2019/1/8 19:09
 * @Description:
 */
@Configuration
public class GateWayConfig {

  /**
   * 每时间单位补充令牌数
   */
  private int refillTokens = 1;
  /**
   * 桶的最大容量,即每个时间单位中令牌的最大数量
   */
  private int capacity = 4;
  /**
   * 时间单位,秒
   */
  private int refillDuration = 1;


//  @Bean
//  public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//    return builder.routes()
//            .route(r -> r.path("/fluent/**").and().query("name")
//                    .uri("http://httpbin.org:80/get"))
//            .route(r -> r.path("/ratelimit_client/**")
//                    .filters(
//                            f -> f.stripPrefix(1).filter(
//                                    new RateLimitByIpGatewayFilter(
//                                            capacity, refillTokens, Duration.ofSeconds(refillDuration)))
//                    )
//                    .uri("lb://service-client").order(0).id("ratelimit_route"))
//            .build();
//  }

}

package com.zgd.springcloud.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @Author: zgd
 * @Date: 2019/1/9 16:55
 * @Description:
 */
@Configuration
public class KeyResolverConfig {


  @Bean
  KeyResolver userKeyResolver() {
    return exchange -> {
      String s = exchange.getRequest().getPath().toString();
      Mono<String> path = Mono.just(s);
      System.out.println("获取uri:" + s);
      return path;
    };
  }


//  @Bean
//  public KeyResolver myKeyResolver() {
//    return exchange -> {
//      Mono<String> just = Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
//      System.out.println("收到请求,just:"+ just.toString());
//      return just;
//    };
//  }
}


package com.zgd.springcloud.gateway.filter;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author: zgd
 * @Date: 2019/1/10 16:39
 * @Description:
 */
public class RemoteAddrKeyResolver implements KeyResolver {

  @Override
  public Mono<String> resolve(ServerWebExchange exchange) {
    String hostAddress = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
    Mono<String> just = Mono.just(hostAddress);
    System.out.println("hostAddress:" + hostAddress);
    return just;
  }

//  @Bean
//  public RemoteAddrKeyResolver remoteAddrKeyResolver() {
//    return new RemoteAddrKeyResolver();
//  }
}

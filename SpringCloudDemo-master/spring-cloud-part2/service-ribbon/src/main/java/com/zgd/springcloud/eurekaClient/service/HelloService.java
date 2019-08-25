package com.zgd.springcloud.eurekaClient.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {


    /**
     * 用来访问其他mvc路由,获得远程方法执行后的值
     */
    @Autowired
    RestTemplate restTemplate;


    /**
     * 通过restTemplate采用rest直接访问eureka-client-01的路由调用方法
     *
     * @param name
     * @return
     */
    //指定熔断时调用的方法
   @HystrixCommand(fallbackMethod = "hiError"
            , commandProperties = {
            //隔离策略,默认推荐是THREAD,还有就是SEMAPHORE(信号)
            @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
            //熔断的最大并发请求,只有在隔离策略是SEMAPHORE时才生效
            @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "1000")
            }
    )
    public String hiService(String name) {
        //eureka-client-01工程的applicationName
        String client01Name = "client01";
        //eureka-client-01工程的ProducerController的路由
        String prefix1 = "client1";
        //eureka-client-01工程的ProducerController的hello方法的路由
        String prefix2 = "hello";

        //访问eureka-client-01的路由,远程调用eureka-client-01的方法
        return restTemplate.getForObject("http://" + client01Name + "/" + prefix1 + "/" + prefix2 + "?name=" + name, String.class);
    }


    /**
     * 熔断执行的方法
     *
     * @param name
     * @return
     */
    public String hiError(String name) {
        return name + ",client1出现问题,进行了熔断";
    }
}

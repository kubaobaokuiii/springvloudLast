package guo.cloud.core;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类-核心
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudCoreApplication.class, args);
    }
}

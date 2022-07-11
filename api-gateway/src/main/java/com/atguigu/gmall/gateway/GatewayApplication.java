package com.atguigu.gmall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @SpringBootApplication
 * @EnableDiscoveryClient  //开启服务发现功能
 * @EnableCircuitBreaker    //开启熔断功能
 */
@SpringCloudApplication  //相当于以上三个的合体
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}

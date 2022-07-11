package com.atguigu.gmall.product;

import com.atguigu.gmall.common.config.MybatisPlusConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Import;


@Import({MybatisPlusConfig.class}) //手动指定我们需要给容器中导入生效的类
@SpringCloudApplication
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
}

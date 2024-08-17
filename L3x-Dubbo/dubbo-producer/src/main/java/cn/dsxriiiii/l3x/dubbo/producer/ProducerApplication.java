package cn.dsxriiiii.l3x.dubbo.producer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ProjectName: L3x-Dubbo
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/22 17:59
 * @Email: lihh53453@hundsun.com
 */
@SpringBootApplication
@EnableDubbo
public class ProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class,args);
    }
}

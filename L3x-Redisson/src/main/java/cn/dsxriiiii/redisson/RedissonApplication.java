package cn.dsxriiiii.redisson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

/**
 * @PackageName: cn.dsxriiiii.redisson
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/06 16:38
 * @Description: redisson 启动
 **/
@Configuration
@ConfigurationPropertiesScan
@SpringBootApplication
public class RedissonApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedissonApplication.class,args);
    }
}

package cn.dsxriiiii.l3x;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @PackageName: cn.dsxriiiii.l3x.springboot
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/25 17:35
 * @Description: app
 **/
@Slf4j
@SpringBootApplication
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class,args);
        log.info("l3x kafka start success");
    }
}

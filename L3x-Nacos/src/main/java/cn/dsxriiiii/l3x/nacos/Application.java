package cn.dsxriiiii.l3x.nacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@NacosPropertySource(dataId = "nacos-dome", autoRefreshed = true)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}

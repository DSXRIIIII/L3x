package cn.dsxriiiii.L3x.dynamicSwitch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

/**
 * @PackageName: cn.dsxriiiii.L3x.dynamicswitch
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/29 17:29
 * @Description: app
 **/
@SpringBootApplication
@ConfigurationPropertiesScan
@Configuration
public class DynamicSwitchApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicSwitchApplication.class,args);
    }
}

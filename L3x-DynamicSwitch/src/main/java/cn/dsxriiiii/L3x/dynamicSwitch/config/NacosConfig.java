package cn.dsxriiiii.L3x.dynamicSwitch.config;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @PackageName: cn.dsxriiiii.L3x.dynamicswitch.config
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/29 18:29
 * @Description: nacos
 **/
@Configuration
public class NacosConfig {
    @Bean
    public ConfigService configService() throws NacosException {
        Properties properties = new Properties();
        properties.setProperty("serverAddr", "47.113.228.37:8848");
        return NacosFactory.createConfigService(properties);
    }
}

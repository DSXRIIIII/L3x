package cn.dsxriiiii.L3x.dynamicSwitch.config;


import cn.dsxriiiii.L3x.dynamicSwitch.annotation.Switch;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @PackageName: cn.dsxriiiii.L3x.dynamicSwitch
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/29 18:29
 * @Description: nacos
 **/

@Configuration
@Slf4j
public class BeanFactory implements BeanPostProcessor {

    private final String PATH = "l3x-nacos-dynamic-switch";
    private final Map<String, Object> dccObjGroup = new HashMap<>();

    private final ConfigService configService;

    // 存储上一次的配置信息
    private static String lastConfigInfo = "";

    public BeanFactory(ConfigService configService) throws NacosException {
        this.configService = configService;
        // 监听配置变化
        configService.addListener(PATH, "DEFAULT_GROUP", new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }
            @Override
            public void receiveConfigInfo(String configInfo) {
                // 当配置发生变化时进行处理
                if (!configInfo.equals(lastConfigInfo)) {
                    log.info("nacos config is changed -> change_value:{}",configInfo);
                    for (Map.Entry<String, Object> entry : dccObjGroup.entrySet()) {
                        Object objBean = entry.getValue();
                        try {
                            Class<?> objBeanClass = objBean.getClass();
                            Field[] fields = objBeanClass.getDeclaredFields();
                            for (Field field : fields) {
                                if (!field.isAnnotationPresent(Switch.class)) {
                                    continue;
                                }
                                Switch switchField = field.getAnnotation(Switch.class);
                                String key = switchField.value().split(":")[0];
                                if (entry.getKey().endsWith(key)) {
                                    field.setAccessible(true);
                                    String switchKey = configInfo.split(":")[1];
                                    field.set(objBean, switchKey);
                                    field.setAccessible(false);
                                }
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    lastConfigInfo = configInfo;
                }
            }
        });
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, @NonNull String beanName) throws BeansException {
        Class<?> targetBeanClass = bean.getClass();
        Field[] fields = targetBeanClass.getDeclaredFields();
        for (Field field : fields) {
            //找到被Switch注解的Bean
            if (!field.isAnnotationPresent(Switch.class)) {
                continue;
            }
            Switch dccValue = field.getAnnotation(Switch.class);

            String value = dccValue.value();//获取注解中的value值
            if (value == null || value.isEmpty()) {
                throw new RuntimeException(field.getName() + " @Switch is not config value config case 「isSwitch/isSwitch:1」");
            }

            //将配置文件中的字段值分离出来 switch:false
            String[] splits = value.split(":");
            String key = splits[0];
            String defaultValue = splits.length == 2? splits[1] : null;

            try {
                String configValue = configService.getConfig(PATH, "DEFAULT_GROUP", 5000);
                // 根据反射修改field的属性值
                if (configValue!= null &&!configValue.isEmpty()) {
                    //从nacos中读取配置信息
                    field.setAccessible(true);
                    String switchConfigKey = configValue.split(":")[1];
                    field.set(bean, switchConfigKey);
                    field.setAccessible(false);
                    log.info("Nacos 配置监听 设置配置 {} {} {}", key, field.getName(), configValue);
                } else if (defaultValue!= null) {
                    //获取注解的默认值(switch:false)
                    field.setAccessible(true);
                    String switchConfigKey = defaultValue.split(":")[1];
                    field.set(bean, switchConfigKey);
                    field.setAccessible(false);
                    configService.publishConfig(PATH, "DEFAULT_GROUP",value);
                    //上传到nacos 并被监听
                    log.info("l3x-switch-Nacos is null -> set new config {} {} {}",key, field.getName(),value);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            //初始化到dccObjGroup 以便后序监听这个Bean
            dccObjGroup.put(key, bean);
        }
        return bean;
    }
}
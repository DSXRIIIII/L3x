package cn.dsxriiiii.l3x.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ProjectName: L3x-AopLog
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/29 17:34
 * @Email: lihh53453@hundsun.com
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

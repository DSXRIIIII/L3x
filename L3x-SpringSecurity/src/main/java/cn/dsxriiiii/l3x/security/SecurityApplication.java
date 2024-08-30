package cn.dsxriiiii.l3x.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author DSXRIIIII
 * @Project l3x
 * @Package cn.dsxriiiii.security
 * @Date 2024/8/20 17:44
 * @Description: app
 */
@MapperScan("cn.dsxriiiii.l3x.security.user.mapper")
@SpringBootApplication
public class SecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}

package cn.dsxriiiii.l3x.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @PackageName: cn.dsxriiiii.l3x.security.config
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/29 10:58
 * @Description: 配置类
 **/
@Configuration
@EnableWebSecurity//Spring项目总需要添加此注解，SpringBoot项目中不需要
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser( //此行设置断点可以查看创建的user对象
                User
                        .withDefaultPasswordEncoder()
                        .username("huan") //自定义用户名
                        .password("password") //自定义密码
                        .roles("USER") //自定义角色
                        .build()
        );
        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //authorizeRequests()：开启授权保护
        //anyRequest()：对所有请求开启授权保护
        //authenticated()：已认证请求会自动被授权
        http
                .authorizeRequests(authorize -> authorize.anyRequest().authenticated())
                .formLogin(withDefaults())//表单授权方式
                .httpBasic(withDefaults());//基本授权方式

        return http.build();
    }
}
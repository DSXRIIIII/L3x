package cn.dsxriiiii.l3x.security.test;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @PackageName: cn.dsxriiiii.l3x.security.test
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/30 16:08
 * @Description: 密码加密算法
 **/
@Slf4j
@SpringBootTest
public class PassWordTest {
    @Test
    public void testPassword() {
        // 工作因子，默认值是10，最小值是4，最大值是31，值越大运算速度越慢
        PasswordEncoder encoder = new BCryptPasswordEncoder(4);
        //明文："password"
        //密文：result，即使明文密码相同，每次生成的密文也不一致
        String result = encoder.encode("password");
        System.out.println(result);
        //密码校验
        Assert.isTrue(encoder.matches("password", result), "密码不一致");
    }
}

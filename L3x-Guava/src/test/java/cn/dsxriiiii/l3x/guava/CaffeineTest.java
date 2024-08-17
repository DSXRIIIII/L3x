package cn.dsxriiiii.l3x.guava;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: L3x-Guava
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/24 9:11
 * @Email: lihh53453@hundsun.com
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class CaffeineTest {
    @Test
    public void test_cache(){
        Cache<String,String> cache = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.HOURS) //写入后一个小时删除
                .maximumSize(100)

                //.maximumWeight(10000) 设置最大权重值
                //.weigher((key, value) -> value.length()) 设置权重
                .build();

        // 往缓存里放一些数据
        cache.put("关键词1", "值1");
        cache.put("关键词2", "值2");

        // 从缓存中取数据
        String value1 = cache.getIfPresent("关键词1");
        System.out.println("获取到的值：" + value1);
    }

    @Test
    public void test_listener(){
        RemovalListener<String, String> listener = (key, value, cause) ->
                System.out.println("被移除的键：" + key + ", 原因：" + cause);

        Cache<String, String> cache = Caffeine.newBuilder()
                .removalListener(listener)
                .build();

        cache.put("键1", "值1");
        cache.invalidate("键1"); // 手动移除，触发监听器
        cache.put("键2","值2");
        cache.invalidate("键2"); // 手动移除，触发监听器
    }
}

package cn.dsxriiiii.l3x.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: L3x-Guava
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/23 17:24
 * @Email: lihh53453@hundsun.com
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class GuavaTest {
    /**
     * 本地缓存 小项目适用
     */
    @Test
    public void test_cache(){
        Cache<String, String> cache = CacheBuilder.newBuilder()
                // 最大存储条数，缓存将尝试逐出最近或不经常使用的条目
                .maximumSize(10000)
                // 可以设定删除时候的权重判断
                //.weigher((Weigher<String, String>) (x, y) -> x.length() - y.length())
                // 有效时间
                .expireAfterWrite(3, TimeUnit.SECONDS)
                // 记录次数
                .recordStats()
                .build();
        cache.put("lihh", "liuhx");
        log.info("测试结果：{}", cache.getIfPresent("lihh"));
        cache.invalidate("lihh"); // cache.invalidateAll(); 也可以全部删除
        log.info("测试结果：{}", cache.getIfPresent("lihh"));
        log.info("测试结果：{}", cache.stats());
    }

    /**
     * 监听获取消息 类似mq
     */
    @Test
    public void test_eventbus() {
        EventBus eventBus = new EventBus();
        eventBus.register(new Listener());
        // 可以由其他服务推送消息，之后就可以在监听中收到了
        eventBus.post("消息总线，订单号：100001");
    }
    static class Listener {
        @Subscribe
        public void handleEvent(String orderId) {
            log.info("测试监听获取消息：{}", orderId);
        }
    }

    // 使用JUnit的@Test注解来标记这是一个测试方法
    @Test
    public void test_ListenableFuture() throws InterruptedException {
        // 创建一个CountDownLatch，初始计数为1，用于阻塞当前线程，直到countDownLatch的计数达到零
        CountDownLatch countDownLatch = new CountDownLatch(1);

        // 使用Guava的MoreExecutors.listeningDecorator方法装饰一个ExecutorService，使其返回的Future是ListenableFuture
        // 这里使用了Executors.newFixedThreadPool(10)创建了一个拥有10个线程的线程池
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

        // 提交一个异步任务到executorService，这个任务简单地返回一个字符串"finished"
        // 返回值是一个ListenableFuture<String>，表示这个Future可以在完成时通知回调
        ListenableFuture<String> explosion = executorService.submit(() -> "finished");

        // 创建一个新的ExecutorService，用于处理回调，这里只分配了一个线程
        ExecutorService callBackService = Executors.newFixedThreadPool(1);

        // 使用Futures.addCallback方法为ListenableFuture注册一个回调
        // 这个回调有两个方法：onSuccess和onFailure，分别在任务成功完成时和失败时被调用
        // 这里我们传入了自定义的FutureCallback实现，以及指定了使用callBackService来执行回调
        Futures.addCallback(explosion, new FutureCallback<String>() {
            // 当任务成功完成时调用
            public void onSuccess(String result) {
                // 打印成功信息
                System.out.println("onSuccess");
                // 减少CountDownLatch的计数，以便等待的线程可以继续执行
                countDownLatch.countDown();
            }

            // 当任务失败时调用
            public void onFailure(Throwable thrown) {
                // 打印失败信息
                System.out.println("onFailure");
                // 同样减少CountDownLatch的计数，以便无论任务成功还是失败，等待的线程都能继续执行
                countDownLatch.countDown();
            }
        }, callBackService);

        // 等待CountDownLatch的计数达到零，即等待异步任务完成（无论成功还是失败）
        countDownLatch.await();
    }



}

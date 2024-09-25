package cn.dsxriiiii.redisson;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDate;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @PackageName: cn.dsxriiiii.redisson.test
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/06 16:40
 * @Description: redis测试类
 **/
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedissonTest {
    @Resource
    private RedissonClient redissonClient;

    /**
     * redis 设置key value
     */
    @Test
    public void test_set_value(){
        String key = "l3x-redisson-setValue_test_key";
        RBucket<Object> bucket = redissonClient.getBucket(key);
        bucket.set("l3x-redisson-setValue_test_value", Duration.ofSeconds(60L));
        log.info("setValue_test_key success");
    }

    /**
     * redis 获取value值
     */
    @Test
    public void test_get_value(){
        String key = "l3x-redisson-setValue_test_key";
        String s = (String) redissonClient.getBucket(key).get();
        log.info("get value from redis:{}",s);
    }

    /**
     * redis 设置阻塞队列
     */
    @Test
    public void test_get_queue(){
        String key = "l3x_redisson_getQueue_test_key";
        RBlockingQueue<String> blockingQueue = redissonClient.getBlockingQueue(key);
        blockingQueue.add("element1");
        blockingQueue.add("element2");
        try {
            String element = blockingQueue.take();
            log.info("Taken element: " + element);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    /**
     * redis 设置阻塞队列
     */
    @Test
    public void test_get_block_queue(){
        String key = "l3x_redisson_getBlockQueue_test_key";
        RBlockingQueue<String> blockingQueue = redissonClient.getBlockingQueue(key);
        blockingQueue.add("element1");
        blockingQueue.add("element2");
        try {
            String element = blockingQueue.take();
            log.info("Taken element: " + element);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    /**
     * redis 设置延时队列
     */
    @Test
    public void test_get_delay_queue(){
        String key = "l3x_redisson_get_delay_queue_test_key";
        RBlockingQueue<String> blockingQueue = redissonClient.getBlockingQueue(key);
        RDelayedQueue<String> delayedQueue = redissonClient.getDelayedQueue(blockingQueue);
        delayedQueue.offer("delay_queue_message_1",1, TimeUnit.SECONDS);
        delayedQueue.offer("delay_queue_message_2",1, TimeUnit.SECONDS);
        String element = delayedQueue.poll();
        log.info("Taken element: " + element);
    }

    /**
     * redis map结构
     */
    @Test
    public void test_get_map(){
        String key = "l3x_redisson_get_map_test_key";
        RMap<String, Integer> map = redissonClient.getMap(key);
        map.put("key1", 10);
        map.put("key2", 20);
        Integer value = map.get("key1");
        log.info("get value from map: " + value);
    }

    /**
     * redis 获取list集合
     */
    @Test
    public void test_list(){
        String key = "l3x_redisson_get_list_test_key";
        RList<String> list = redissonClient.getList(key);
        list.add("item1");
        list.add("item2");
        String firstItem = list.get(0);
        System.out.println("First item in list: " + firstItem);
    }

    /**
     * 对键加锁
     */
    @Test
    public void test_setNx(){
        String key = "l3x_redisson_setNx_key";
        RBucket<String> bucket = redissonClient.getBucket(key);
        for (int i = 0; i < 4; i++) {
            // 尝试设置值，如果键不存在则设置成功并返回 true
            boolean isSetSuccessfully = bucket.setIfAbsent("lock");
            if (isSetSuccessfully) {
                log.info("成功设置值到桶中，获得锁。");
            } else {
                log.info("键已存在，无法获得锁。");
            }
        }
    }

    /**
     * 模拟多个线程扣减库存
     * @throws InterruptedException 中断异常
     */
    @Test
    public void test_decr() throws InterruptedException {
        String key = "l3x_redisson_decr_key";
        RAtomicLong atomicLong = redissonClient.getAtomicLong(key);
        atomicLong.set(100);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                try {
                    long remainingInventory = atomicLong.decrementAndGet();
                    log.info("当前库存剩余：{}", remainingInventory);
                } catch (Exception e) {
                    log.error("扣减库存出现错误", e);
                }
            });
        }
        executor.shutdown();
    }

    /**
     * 使用倒计时锁存器
     */
    @Test
    public void test_countDownLatchKey() {
        String key = "l3x_redisson_countDownLatchKey";
        RCountDownLatch countDownLatch = redissonClient.getCountDownLatch(key);
        countDownLatch.trySetCount(3);
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                log.info("线程 1 完成任务");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                log.info("线程 2 完成任务");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                log.info("线程 3 完成任务");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            countDownLatch.await();
            log.info("所有任务完成");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    @Test
    public void test_bloomFilter(){
        // 使用布隆过滤器
        String bloomFilterKey = "l3x_redisson_myBloomFilter";
        RBloomFilter<String> bloomFilter = redissonClient.getBloomFilter(bloomFilterKey);
        // 初始化布隆过滤器，预计插入 1000 个元素，误判率为 0.01
        bloomFilter.tryInit(1000, 0.01);
        bloomFilter.add("element1");
        boolean mightContain = bloomFilter.contains("element1");
        log.info("布隆过滤器是否可能包含 element1:{}",mightContain);
    }

    @Test
    public void test_fairLock(){
        String fairLockKey = "l3x_redisson_fairLock";
        RLock fairLock = redissonClient.getFairLock(fairLockKey);
        try {
            // 获取公平锁
            fairLock.lock();
            log.info("获取到公平锁，执行关键代码段");
            // 模拟关键代码执行
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            // 释放公平锁
            fairLock.unlock();
        }
    }
    @Test
    public void test_readWriteLock(){
        // 使用读写锁
        String readWriteLockKey = "l3x_redisson_readWriteLockKey";
        RReadWriteLock readWriteLock = redissonClient.getReadWriteLock(readWriteLockKey);
        // 获取读锁
        readWriteLock.readLock().lock();
        try {
            System.out.println("获取到读锁，执行读操作。");
            // 模拟读操作
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            // 释放读锁
            readWriteLock.readLock().unlock();
        }
        // 获取写锁
        readWriteLock.writeLock().lock();
        try {
            System.out.println("获取到写锁，执行写操作。");
            // 模拟写操作
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            // 释放写锁
            readWriteLock.writeLock().unlock();
        }
    }

    @Test
    public void test_bitmap(){
        String bitmapKey = "l3x_redisson_bitmap_key_user_";
        RBitSet bitSet = redissonClient.getBitSet(bitmapKey);
        int dayOfMonth = LocalDate.now().getDayOfMonth();
        bitSet.set(dayOfMonth - 1,true);
        boolean isSigned = bitSet.get(19);
        if (isSigned) {
            System.out.println("用户在第 19 天已签到");
        } else {
            System.out.println("用户在第 19 天未签到");
        }
        long signInCount = bitSet.cardinality();
        System.out.println("用户签到总次数为：" + signInCount);
    }
}

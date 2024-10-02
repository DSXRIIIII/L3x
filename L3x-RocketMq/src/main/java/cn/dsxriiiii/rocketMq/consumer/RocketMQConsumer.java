package cn.dsxriiiii.rocketMq.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @PackageName: cn.dsxriiiii.rocketMq.consumer
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/28 16:24
 * @Description: consumer
 **/
@Component
@RocketMQMessageListener(topic = "l3x-topic", consumerGroup = "l3x-consumer")
public class RocketMQConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        // 处理消息
        System.out.println("Received message: " + s);
    }
}

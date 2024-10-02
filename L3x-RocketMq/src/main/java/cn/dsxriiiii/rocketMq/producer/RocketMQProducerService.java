package cn.dsxriiiii.rocketMq.producer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @PackageName: cn.dsxriiiii.rocketMq.producer
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/28 16:23
 * @Description: service
 **/
@Service
public class RocketMQProducerService {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void sendMessage(String topic, String payload) {
        rocketMQTemplate.convertAndSend(topic, payload);
    }
}

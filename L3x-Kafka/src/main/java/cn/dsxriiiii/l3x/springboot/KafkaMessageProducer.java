package cn.dsxriiiii.l3x.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

/**
 * @PackageName: cn.dsxriiiii.l3x.springboot
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/25 17:32
 * @Description: KafkaMessageProducer
 **/
@Slf4j
@Service
public class KafkaMessageProducer {
    private static final String TOPIC = "admin-messages";

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendAdminMessage(String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, message);
        future.addCallback(result -> {
                    assert result != null;
                    log.info("生产者成功发送消息到topic:{} partition:{}的消息", result.getRecordMetadata().topic(), result.getRecordMetadata().partition());
                },
                ex -> log.error("生产者发送消失败，原因：{}", ex.getMessage()));
    }
}

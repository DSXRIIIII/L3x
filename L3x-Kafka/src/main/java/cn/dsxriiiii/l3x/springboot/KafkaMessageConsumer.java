package cn.dsxriiiii.l3x.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @PackageName: cn.dsxriiiii.l3x.springboot
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/25 17:32
 * @Description: KafkaMessageConsumer
 **/
@Slf4j
@Service
public class KafkaMessageConsumer {
    @KafkaListener(topics = "admin-messages",groupId = "l3x-kafka")
    public void receiveAdminMessage(String message) {
        log.info("Received message: " + message);
        // ...
    }
}

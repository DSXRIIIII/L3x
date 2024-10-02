package cn.dsxriiiii.l3x.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @PackageName: cn.dsxriiiii.l3x.springboot
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/25 17:33
 * @Description: AdminController
 **/

@RestController
@RequestMapping("/api/l3x/kafka/message")
public class AdminController {

    @Resource
    private KafkaMessageProducer kafkaMessageProducer;

    @GetMapping("/publish")
    public void publishAdminMessage(@RequestParam("message") String message) {
        kafkaMessageProducer.sendAdminMessage(message);
    }
}


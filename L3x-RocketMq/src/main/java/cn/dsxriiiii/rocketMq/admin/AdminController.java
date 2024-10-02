package cn.dsxriiiii.rocketMq.admin;

import cn.dsxriiiii.rocketMq.producer.RocketMQProducerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @PackageName: cn.dsxriiiii.rocketMq.admin
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/28 16:26
 * @Description: 发送消息controller
 **/
@RestController
@RequestMapping("/l3x/rocketmq/sendMessage")
public class AdminController {

    @Resource
    private RocketMQProducerService producerService;

    @RequestMapping("/test")
    public void send(@RequestParam String message){
        for (int i = 0; i < 100; i++) {
            producerService.sendMessage("l3x-topic",message);
        }
    }
}

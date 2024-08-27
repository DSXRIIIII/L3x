package cn.dsxriiiii.l3x.openfeign.consumer.controller;

import cn.dsxriiiii.l3x.openfeign.consumer.client.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @PackageName: cn.dsxriiiii.l3x.openfeign.consumer.controller
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/27 19:01
 * @Description: 调用openfeign接口
 **/
@RestController
public class ConsumerController {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String consumerHello() {
        return "Hello from ConsumerService! " + discoveryClient.discovery();
    }
}

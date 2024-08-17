package cn.dsxriiiii.l3x.dubbo.consumer.controller;


import cn.dsxriiiii.l3x.dubbo.producer.entity.LoginEntity;
import cn.dsxriiiii.l3x.dubbo.producer.service.IService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: L3x-Dubbo
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/23 9:12
 * @Email: lihh53453@hundsun.com
 */
@RestController
@RequestMapping("/api/l3x/dubbo/rpc/service")
public class CustomerController {

    @DubboReference(interfaceClass = IService.class,version = "1.0")
    private IService service;

    @RequestMapping(value = "consumer1", method = RequestMethod.GET)
    public LoginEntity test_service(){
        LoginEntity loginEntity = new LoginEntity("user1","123");
        service.doLogin(loginEntity);
        return loginEntity;
    }

}

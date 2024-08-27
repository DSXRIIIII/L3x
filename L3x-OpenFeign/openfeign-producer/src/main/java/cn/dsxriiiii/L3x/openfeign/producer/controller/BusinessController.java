package cn.dsxriiiii.L3x.openfeign.producer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @PackageName: cn.dsxriiiii.L3x.openfeign.producer.controller
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/27 17:01
 * @Description: openfeign接口远程提供方
 **/
@RestController
public class BusinessController {

    @RequestMapping(value = "/openfeign/test",method = RequestMethod.GET)
    public String discovery(){
        System.out.println("------- do provider getNameById method" + LocalDateTime.now());
        return "我被调用了￣へ￣";
    }
}

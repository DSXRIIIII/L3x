package cn.dsxriiiii.L3x.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author DSXRIIIII
 * @Project l3x
 * @Package cn.dsxriiiii.L3x.gateway
 * @Date 2024/8/20 16:47
 * @Description: 接口
 */
@RestController
@RequestMapping("/user")
public class Controller {
    @RequestMapping("/name")
    public String getName(){
        return "华硕我求你别蓝屏了";
    }
}


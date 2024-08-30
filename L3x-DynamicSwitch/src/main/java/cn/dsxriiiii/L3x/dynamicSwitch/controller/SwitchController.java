package cn.dsxriiiii.L3x.dynamicSwitch.controller;


import cn.dsxriiiii.L3x.dynamicSwitch.annotation.Switch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName: cn.dsxriiiii.L3x.dynamicswitch
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/29 18:33
 * @Description: controller
 **/
@RestController
@RequestMapping("/l3x/dynamic/switch")
public class SwitchController {

    @Switch("switch:false")
    private String value;

    @RequestMapping(value = "/getValue",method = RequestMethod.GET)
    public String getValue(){
        return value;
    }

}

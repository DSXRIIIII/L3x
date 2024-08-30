package cn.dsxriiiii.l3x.security.user.controller;

import cn.dsxriiiii.l3x.security.user.po.User;
import cn.dsxriiiii.l3x.security.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @PackageName: cn.dsxriiiii.L3x.gateway.user.controller
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/28 17:19
 * @Description: user_controller
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    public UserService userService;

    @GetMapping("/list")
    public List<User> getList(){
        return userService.list();
    }
}
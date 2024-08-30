package cn.dsxriiiii.l3x.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author DSXRIIIII
 * @Project l3x
 * @Package cn.dsxriiiii.security
 * @Date 2024/8/20 17:43
 * @Description: controller
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/main")
    public String index() {
        return "index";
    }
}

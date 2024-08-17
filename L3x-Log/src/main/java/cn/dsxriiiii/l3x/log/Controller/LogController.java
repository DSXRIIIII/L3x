package cn.dsxriiiii.l3x.log.Controller;

import cn.dsxriiiii.l3x.log.annotation.L3xLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @ProjectName: L3x-AopLog
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/29 17:49
 * @Email: lihh53453@hundsun.com
 */
@RestController
@RequestMapping("/user")
public class LogController {
    private final Logger log = LoggerFactory.getLogger(LogController.class);

    @L3xLog
    @GetMapping
    public String getUser() {
        return "user";
    }
}

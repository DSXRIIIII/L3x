package cn.dsxriiiii.l3x.nacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @ProjectName: L3x-Nacos
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/31 9:21
 * @Email: lihh53453@hundsun.com
 */
@Controller
@RequestMapping("/config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @RequestMapping(value = "/getValue", method = GET)
    @ResponseBody
    public boolean get() {
        return useLocalCache;
    }
}
package cn.dsxriiiii.l3x.sentinel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @ProjectName: L3x-Sentinel
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/31 9:34
 * @Email: lihh53453@hundsun.com
 */

@RefreshScope
@RestController
@RequestMapping("/nacos")
public class NacosController {
    private static final Logger log = LoggerFactory.getLogger(NacosController.class);

    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @RequestMapping(value = "/getValue", method = GET)
    @ResponseBody
    public boolean get() {
        return useLocalCache;
    }

    //动态监听变化
    //cloud 内置监听
//    @NacosConfigListener(dataId = "nacos-dome")
//    public void change(String config){
//        log.info("nacos监听变化:{}",config);
//    }

}

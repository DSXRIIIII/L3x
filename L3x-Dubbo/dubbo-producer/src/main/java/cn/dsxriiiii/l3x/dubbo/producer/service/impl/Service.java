package cn.dsxriiiii.l3x.dubbo.producer.service.impl;


import com.alibaba.fastjson.JSONObject;
import cn.dsxriiiii.l3x.dubbo.producer.entity.LoginEntity;
import cn.dsxriiiii.l3x.dubbo.producer.service.IService;
import org.apache.dubbo.config.annotation.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ProjectName: L3x-Dubbo
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/22 17:58
 * @Email: lihh53453@hundsun.com
 */
@DubboService(version = "1.0")
public class Service implements IService {

    private static final Logger log = LoggerFactory.getLogger(Service.class);

    @Override
    public void doLogin(LoginEntity loginEntity) {
        log.info("登录成功，信息为:{}", JSONObject.toJSONString(loginEntity));
    }
}

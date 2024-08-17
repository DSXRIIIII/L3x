package cn.dsxriiiii.l3x.dubbo.producer.service;


import cn.dsxriiiii.l3x.dubbo.producer.entity.LoginEntity;

/**
 * @ProjectName: L3x-Dubbo
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/22 17:58
 * @Email: lihh53453@hundsun.com
 */
public interface IService {
    void doLogin(LoginEntity loginEntity);
}

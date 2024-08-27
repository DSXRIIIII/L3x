package cn.dsxriiiii.l3x.openfeign.consumer.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @PackageName: cn.dsxriiiii.L3x.openfeign.service
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/27 16:56
 * @Description: 服务发现
 **/
@FeignClient("l3x-openfeign-discovery") // 表示调用 nacos 中的 nacos-discovery 服务
public interface DiscoveryClient {
    @RequestMapping(value = "/openfeign/test",method = RequestMethod.GET) // 调用生产者的"/user/test"接口
    String discovery();
}

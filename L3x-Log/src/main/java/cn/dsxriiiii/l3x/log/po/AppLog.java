package cn.dsxriiiii.l3x.log.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: L3x-AopLog
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/29 17:44
 * @Email: lihh53453@hundsun.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppLog {
    // ip
    private String ip;
    //ip属地
    private String location;
    // url
    private String url;
    // http方法 GET POST PUT DELETE PATCH
    private String httpMethod;
    // 请求参数
    private Object requestParams;
    // 返回参数
    private Object result;
    // 接口耗时
    private Long timeCost;

}

package cn.dsxriiiii.l3x.dubbo.producer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ProjectName: L3x-Dubbo
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/22 18:02
 * @Email: lihh53453@hundsun.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginEntity implements Serializable {
    private String username;
    private String password;
}

package cn.dsxriiiii.l3x.guava.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ProjectName: L3x-Guava
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/23 17:28
 * @Email: lihh53453@hundsun.com
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    private String userName;
    private String password;
    private Double amount;
    private Date createTime;

}


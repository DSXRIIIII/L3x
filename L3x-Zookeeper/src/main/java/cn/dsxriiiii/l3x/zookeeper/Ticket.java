package cn.dsxriiiii.l3x.zookeeper;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName: L3x-Zookeeper
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/23 13:15
 * @Email: lihh53453@hundsun.com
 */
@Data
@AllArgsConstructor
public class Ticket implements Serializable {
    private String skuId;
    private String price;
}

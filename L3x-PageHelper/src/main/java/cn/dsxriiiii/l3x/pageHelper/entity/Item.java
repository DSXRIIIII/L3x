package cn.dsxriiiii.l3x.pageHelper.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ProjectName: L3x-PageHelper
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/24 13:36
 * @Email: lihh53453@hundsun.com
 */
@Data
public class Item {
    private Long id;
    private String name;
    private Integer price;
    private Integer stock;
    private String image;
    private String category;
    private String brand;
    private String spec;
    private Integer sold;
    private Integer commentCount;
    private Boolean isAD;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}

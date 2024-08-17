package cn.dsxriiiii.l3x.pageHelper.service;


import cn.dsxriiiii.l3x.pageHelper.entity.Item;
import com.github.pagehelper.PageInfo;

/**
 * @ProjectName: L3x-PageHelper
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/24 13:41
 * @Email: lihh53453@hundsun.com
 */
public interface IItemService {
    PageInfo<Item> findByPage(Integer pageNum, Integer pageSize);
}

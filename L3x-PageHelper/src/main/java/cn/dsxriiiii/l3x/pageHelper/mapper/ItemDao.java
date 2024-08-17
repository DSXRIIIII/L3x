package cn.dsxriiiii.l3x.pageHelper.mapper;


import cn.dsxriiiii.l3x.pageHelper.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ProjectName: L3x-PageHelper
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/24 13:45
 * @Email: lihh53453@hundsun.com
 */
@Mapper
public interface ItemDao {

    List<Item> findByPage();
}

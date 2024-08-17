package cn.dsxriiiii.l3x.pageHelper.service.impl;

import cn.dsxriiiii.l3x.pageHelper.entity.Item;
import cn.dsxriiiii.l3x.pageHelper.mapper.ItemDao;
import cn.dsxriiiii.l3x.pageHelper.service.IItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: L3x-PageHelper
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/24 13:42
 * @Email: lihh53453@hundsun.com
 */
@Service
public class ItemServiceImpl implements IItemService {

    @Resource
    private ItemDao itemDao;


    @Override
    public PageInfo<Item> findByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Item> categoryBrandList = itemDao.findByPage();
        return new PageInfo<>(categoryBrandList);
    }
}

package cn.dsxriiiii.l3x.pageHelper.controller;



import cn.dsxriiiii.l3x.pageHelper.entity.Item;
import cn.dsxriiiii.l3x.pageHelper.service.IItemService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ProjectName: L3x-PageHelper
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/24 13:34
 * @Email: lihh53453@hundsun.com
 */
@RestController
@RequestMapping("/admin/system")
public class ItemController {

    @Resource
    private IItemService service;

    @PostMapping("/findByPage/{pageNum}/{pageSize}")
    public PageInfo<Item> findByPage(@PathVariable(value = "pageNum") Integer pageNum,
                                     @PathVariable(value = "pageSize") Integer pageSize){
        return service.findByPage(pageNum,pageSize);
    }
}

package cn.dsxriiiii.l3x.security.user.service.impl;

import cn.dsxriiiii.l3x.security.user.po.User;
import cn.dsxriiiii.l3x.security.user.mapper.UserMapper;
import cn.dsxriiiii.l3x.security.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @PackageName: cn.dsxriiiii.L3x.gateway.user.service.impl
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/28 17:18
 * @Description: UserServiceImpl
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}

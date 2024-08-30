package cn.dsxriiiii.l3x.security.user.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @PackageName: cn.dsxriiiii.L3x.gateway.user
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/08/28 17:13
 * @Description: 用户信息
 **/
@Data
@TableName("l3x_gateway_user")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private Boolean enabled;

}

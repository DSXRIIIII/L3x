package cn.dsxriiiii.l3x.design.chain.factory;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.chain.factory
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 17:23
 * @Description: 构建责任链
 **/
public interface ChainArmory {
    Handler next();

    Handler appendNext(Handler next);
}

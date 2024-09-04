package cn.dsxriiiii.l3x.design.chain.factory;

import cn.dsxriiiii.l3x.design.chain.factory.ChainArmory;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.chain
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 17:04
 * @Description: Handler
 **/
public interface Handler extends ChainArmory {
    DefaultChainFactory.HandlerModel handleRequest();
}

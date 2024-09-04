package cn.dsxriiiii.l3x.design.chain;

import cn.dsxriiiii.l3x.design.chain.factory.AbstractActionChain;
import cn.dsxriiiii.l3x.design.chain.factory.DefaultChainFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.chain
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 17:04
 * @Description: ConcreteHandler1
 **/
@Slf4j
@Component("ConcreteHandler1")
public class ConcreteHandler1 extends AbstractActionChain {

    @Override
    public DefaultChainFactory.HandlerModel handleRequest() {
        log.info("一号处理器处理");
        return next().handleRequest();
    }
}


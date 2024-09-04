package cn.dsxriiiii.l3x.design.chain;

import cn.dsxriiiii.l3x.design.chain.factory.AbstractActionChain;
import cn.dsxriiiii.l3x.design.chain.factory.DefaultChainFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.chain
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 19:32
 * @Description: 默认处理器
 **/
@Slf4j
@Component("DefaultHandler")
public class DefaultHandler extends AbstractActionChain {
    @Override
    public DefaultChainFactory.HandlerModel handleRequest() {
        log.info("默认处理器处理");
        return DefaultChainFactory.HandlerModel.builder()
                .code("3")
                .description("默认构造规则引擎")
                .build();
    }
}

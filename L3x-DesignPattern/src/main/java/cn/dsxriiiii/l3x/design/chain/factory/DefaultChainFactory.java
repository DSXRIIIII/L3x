package cn.dsxriiiii.l3x.design.chain.factory;

import cn.dsxriiiii.l3x.design.chain.ConcreteHandler1;
import cn.dsxriiiii.l3x.design.chain.ConcreteHandler2;
import cn.dsxriiiii.l3x.design.chain.DefaultHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.chain.factory
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 17:25
 * @Description: 组装责任链
 **/
@Component
public class DefaultChainFactory {

    private final ApplicationContext applicationContext;

    public DefaultChainFactory(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    public Handler buildHandlerChain() {
        Handler handler1 = applicationContext.getBean(ActionModel.ConcreteHandler1.code, ConcreteHandler1.class);
        Handler handler2 = applicationContext.getBean(ActionModel.ConcreteHandler2.code, ConcreteHandler2.class);
        Handler defaultHandler = applicationContext.getBean(ActionModel.DefaultHandler.code, DefaultHandler.class);
        handler1.appendNext(handler2);
        handler2.appendNext(defaultHandler);
        return handler1;
    }

    @Getter
    @AllArgsConstructor
    public enum ActionModel{
        ConcreteHandler1("ConcreteHandler1","一号处理器"),
        ConcreteHandler2("ConcreteHandler2","二号处理器"),
        DefaultHandler("DefaultHandler","默认处理器")
        ;
        private final String code;
        private final String info;
    }

    @Data
    @Builder
    @AllArgsConstructor
    public static class HandlerModel{
        private final String code;
        private final String description;
    }
}

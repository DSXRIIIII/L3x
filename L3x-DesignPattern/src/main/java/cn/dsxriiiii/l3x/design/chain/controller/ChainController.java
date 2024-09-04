package cn.dsxriiiii.l3x.design.chain.controller;

import cn.dsxriiiii.l3x.design.chain.factory.DefaultChainFactory;
import cn.dsxriiiii.l3x.design.chain.factory.Handler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName: cn.dsxriiiii.l3x.design.chain.controller
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/04 19:49
 * @Description: controller
 **/
@RestController
@RequestMapping("/l3x/design/chain")
public class ChainController {

    private final DefaultChainFactory defaultChainFactory;

    public ChainController(DefaultChainFactory defaultChainFactory){
        this.defaultChainFactory = defaultChainFactory;
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void testChain(){
        Handler handler = defaultChainFactory.buildHandlerChain();
        handler.handleRequest();
    }
}

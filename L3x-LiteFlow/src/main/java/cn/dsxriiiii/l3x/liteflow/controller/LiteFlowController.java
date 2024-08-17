package cn.dsxriiiii.l3x.liteflow.controller;

import com.yomahub.liteflow.builder.LiteFlowNodeBuilder;
import com.yomahub.liteflow.builder.el.LiteFlowChainELBuilder;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.enums.NodeTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @ProjectName: L3x-LiteFlow
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/14 10:52
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
@Controller
@Slf4j
@RequestMapping("/liteFlow/test")
public class LiteFlowController {
    @Resource
    private FlowExecutor flowExecutors;

    @RequestMapping(value = "/chain", method = GET)
    @ResponseBody
    public void liteFlow(){
        LiteFlowChainELBuilder.createChain().setChainName("chain").setEL("THEN(one,three,two)").build();
        flowExecutors.execute2Future("chain",null);
    }

    @RequestMapping(value = "/script", method = GET)
    @ResponseBody
    public void script_java_init(){
        LiteFlowNodeBuilder.createScriptNode()
                .setId("script_java")
                .setName("java_liteflow可执行脚本")
                .setType(NodeTypeEnum.SCRIPT)
                .setScript("import com.yomahub.liteflow.script.ScriptExecuteWrap;\n" +
                        "import com.yomahub.liteflow.script.body.JaninoCommonScriptBody;\n" +
                        "\n" +
                        "/**\n" +
                        " * @ProjectName: L3x-LiteFlow\n" +
                        " * @Author: DSXRIIIII\n" +
                        " * @CreateDate: 2024/8/14 13:41\n" +
                        " * @Email: lihh53453@hundsun.com\n" +
                        " * @Description:\n" +
                        " */\n" +
                        "public class ScriptBuilder implements JaninoCommonScriptBody{\n" +
                        "    @Override\n" +
                        "    public Void body(ScriptExecuteWrap scriptExecuteWrap) {\n" +
                        "        System.out.println(\"123\");\n" +
                        "        return null;\n" +
                        "    }\n" +
                        "}\n")
                .setLanguage("java")
                .build();
        LiteFlowChainELBuilder.createChain().setChainName("script_java").setEL("THEN(script_java)").build();
        flowExecutors.execute2Future("script_java",null);
        log.info("脚本执行完毕");
    }

}

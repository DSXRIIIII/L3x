package cn.dsxriiiii.l3x.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
/**
 * @ProjectName: L3x-Sentinel
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/29 14:50
 * @Email: lihh53453@hundsun.com
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @SentinelResource(value = "getUser",fallback = "helloFallback",blockHandler = "getUserFallbackHandler")
    @GetMapping
    public String getUser() {
        return "user";
    }

    public String getUserFallbackHandler(BlockException e) {
        log.error("您已被限流，调用失败了！",e);
        return "限流";
    }

    public String helloFallback(Throwable e) {
        log.error("熔断",e);
        return "熔断";
    }

    @PostConstruct
    public void init() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        //资源名称
        rule.setResource("getUser");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}

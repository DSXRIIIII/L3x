package cn.dsxriiiii.l3x.liteflow.component;

import cn.dsxriiiii.l3x.liteflow.context.BusinessSceneContext;
import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ProjectName: L3x-LiteFlow
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/14 10:18
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
@LiteflowComponent("two")
public class PrintTwo extends NodeComponent {
    private final Logger logger = LoggerFactory.getLogger(PrintTwo.class);
    @Override
    public void process() throws Exception {
        logger.info("当前位于节点two");
        BusinessSceneContext contextBean = this.getContextBean(BusinessSceneContext.class);
        contextBean.setId("22222222222");
        logger.info("设置上下文id为：{}",contextBean.getId());
    }
}

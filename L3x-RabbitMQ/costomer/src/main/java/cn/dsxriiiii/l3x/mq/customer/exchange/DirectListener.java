package cn.dsxriiiii.l3x.mq.customer.exchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: rabbit-demo
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/19 13:16
 * @Email: lihh53453@hundsun.com
 */
@Component
public class DirectListener {

    private static final Logger log = LoggerFactory.getLogger(DirectListener.class);

    /**
     *  topic交换机匹配
     *  根据routingKey 匹配消息队列
     * @param msg 传递的消息
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "${mq.listener.direct.award}"),
            exchange = @Exchange(name = "dome.direct"),
            key = "award"
    ))
    public void direct_award(String msg){
        log.info("DIRECT 广播 mq.direct.award队列接收到消息{}",msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "${mq.listener.direct.rebate}"),
            exchange = @Exchange(name = "dome.direct"),
            key = "rebate"
    ))
    public void direct_rebate(String msg){
        log.info("DIRECT 广播 mq.direct.rebate队列接收到消息{}",msg);
    }
}

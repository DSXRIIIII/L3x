package cn.dsxriiiii.l3x.common;

import com.alibaba.fastjson2.JSON;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.util.Properties;

/**
 * @PackageName: cn.dsxriiiii.l3x
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/25 16:50
 * @Description: NormalProducer
 **/
public class NormalProducer {
    private static final Logger log = LoggerFactory.getLogger(NormalProducer.class);
    public static void main(String[] args) {
        Properties properties = new Properties();
        //	1.配置生产者启动的关键属性参数
        //	1.1	BOOTSTRAP_SERVERS_CONFIG：连接kafka集群的服务列表，如果有多个，使用"逗号"进行分隔
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "116.198.246.11:9092");
        //	1.2	CLIENT_ID_CONFIG：这个属性的目的是标记kafka client的ID
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "quickstart-producer");
        //	1.3 KEY_SERIALIZER_CLASS_CONFIG VALUE_SERIALIZER_CLASS_CONFIG
        //	Q: 对 kafka的 key 和 value 做序列化，为什么需要序列化？
        //	A: 因为KAFKA Broker 在接收消息的时候，必须要以二进制的方式接收，所以必须要对KEY和VALUE进行序列化
        //	字符串序列化类：org.apache.kafka.common.serialization.StringSerializer
        //	KEY: 是kafka用于做消息投递计算具体投递到对应的主题的哪一个partition而需要的
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        //	VALUE: 实际发送消息的内容
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        for(int i = 0; i <10; i ++) {
            //	3.构造消息内容
            Message user = new Message("00" + i, "message"+i+"号消息");
            ProducerRecord<String, String> record =
                    //	arg1：topic , arg2：实际的消息体内容，quick_start 是 topic 名称
                    new ProducerRecord<>("quick_start", JSON.toJSONString(user));
            //	4.发送消息
            producer.send(record);
        }
        System.err.println("发送消息完成");
        producer.close();
    }
}

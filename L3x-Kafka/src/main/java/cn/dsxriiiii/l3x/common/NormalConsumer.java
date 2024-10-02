package cn.dsxriiiii.l3x.common;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

/**
 * @PackageName: cn.dsxriiiii.l3x
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/09/25 17:00
 * @Description: NormalConsumer
 **/
public class NormalConsumer {
    public static void main(String[] args) {
        //	1. 配置属性参数
        Properties properties = new Properties();

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "116.198.246.11:9092");

        //	org.apache.kafka.common.serialization.StringDeserializer
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        //	非常重要的属性配置：与我们消费者订阅组有关系
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "quickstart-group");
        //	常规属性：会话连接超时时间
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 10000);
        //	消费者提交offset: 自动提交 & 手工提交，默认是自动提交
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 5000);

        //	2. 创建消费者对象
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        //	3. 订阅你感兴趣的主题：quick_start
        consumer.subscribe(Collections.singletonList("quick_start"));

        System.err.println("quickstart consumer started...");
        try {
            //	4.采用拉取消息的方式消费数据
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("Offset = %d, Key = %s, Value = %s%n", record.offset(), record.key(), record.value());
                }
            }
        } finally {
            consumer.close();
        }

    }
}

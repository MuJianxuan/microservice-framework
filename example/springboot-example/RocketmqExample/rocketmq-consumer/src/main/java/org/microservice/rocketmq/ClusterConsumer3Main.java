package org.microservice.rocketmq;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 * desc:
 *
 * @author create 2022/4/29 by rao
 */
@Slf4j
public class ClusterConsumer3Main {
    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer defaultMqPushConsumer = new DefaultMQPushConsumer("demo-group2");
        defaultMqPushConsumer.setNamesrvAddr("http://117.50.174.141:9876");

        //这里设置的是一个consumer的消费策略  所以需要防重
        //CONSUME_FROM_LAST_OFFSET 默认策略，从该队列最尾开始消费，即跳过历史消息
        //CONSUME_FROM_FIRST_OFFSET 从队列最开始开始消费，即历史消息（还储存在broker的）全部消费一遍
        //CONSUME_FROM_TIMESTAMP 从某个时间点开始消费，和setConsumeTimestamp()配合使用，默认是半个小时以前
        defaultMqPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        defaultMqPushConsumer.setMessageModel( MessageModel.CLUSTERING);

        // 表示订阅的 Topic 和 tag * 表示All
        defaultMqPushConsumer.subscribe("test-main","tag1 || tag2");
        //
        defaultMqPushConsumer.registerMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {

            log.info("Receive New Messages size：{}",list.size() );
            list.forEach(messageExt -> {
                String msg = new String(messageExt.getBody());
                log.info("msg:" + msg);
                log.info(JSON.toJSONString(msg));
            });

            // 返回消费状态
            // RECONSUME_LATER 返回失败则 需要稍后重新消费
            //在集群消费模式下，返回失败会怎么样？ 会重投，几次呢？ 目前看会有好多次重投。 重新改成 消费成功后重启，还是能正常消费掉数据。
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        try {
            defaultMqPushConsumer.start();
            log.info("MQPushConsumer has started!");

            System.in.read();
        } finally {
            defaultMqPushConsumer.shutdown();
        }

    }
}

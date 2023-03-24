package org.microservice.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author Rao
 * @Date 2023/3/24
 **/
@Slf4j
@Configuration
public class RabbitMqProducerConfig  implements RabbitTemplate.ReturnCallback, RabbitTemplate.ConfirmCallback, InitializingBean {


    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 需要添加初始化 RabbitAdmin#initialize 会注册新写的队列在rabbitmq中创建。
     * @param defaultConnectionFactory
     * @return
     */
    @Bean(initMethod = "initialize")
    public RabbitAdmin rabbitAdmin(ConnectionFactory defaultConnectionFactory){
        return new RabbitAdmin(defaultConnectionFactory);
    }



    /**
     *
     * @param correlationData 当ack为true时，这个值为null
     * @param ack
     * @param cause 当ack为true时，这个值也为null
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        // ack 失败!
        if( !ack){
            // TODO 发送事件
            log.error("[消息确认] 确认失败， 严重，correlationData:{},cause:{}", correlationData, cause );
        }
        else {

            // 消息序列化失败  此时我使用的是 自动ack！ 也会 ack 是成功 ，是否 开启手动ack可以避免这种情况？
            log.info("[消息确认] 确认成功,correlationData:{}",correlationData);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        // 执行了此回调表示消息未路由到 实际队列中
        log.error("[消息路由失败] 严重，message:{},replyCode:{},,replyText:{},exchange:{},routingKey:{}",message,replyCode,replyText,exchange,routingKey);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        // 处理消息序列化  默认的不行
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        rabbitTemplate.setMessageConverter( jackson2JsonMessageConverter );

        // 发送方消息确认
        rabbitTemplate.setConfirmCallback( this);
        //
        rabbitTemplate.setReturnCallback( this);

    }

}

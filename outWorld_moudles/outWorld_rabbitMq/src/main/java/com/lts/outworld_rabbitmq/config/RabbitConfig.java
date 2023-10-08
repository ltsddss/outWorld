package com.lts.outworld_rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.lts.outworld_rabbitmq.constant.RabbitMqConstant.*;

@Configuration
public class RabbitConfig {

//    配置交换机和队列的绑定关系
    @Bean("bootExchange")
    public Exchange bootExchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    @Bean("bootQueue")
    public Queue bootQueue(){
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    /**
     * 演示
     * @param queue 队列
     * @param exchange 交换机
     * @return 绑定关系
     */
    @Bean
    public Binding bingQueueExchange(@Qualifier("bootQueue") Queue queue, @Qualifier("bootExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("boot.insert.#").noargs();
    }

    /**
     * 配置绑定关系
     */

    /**
     * 交换机注册
     * @return 交换机信息
     */
    @Bean("chatExchange")
    public Exchange chatExchange(){
        return ExchangeBuilder.topicExchange(EXCHANGE_CHAT).durable(true).build();
    }

    /**
     * 队列注册
     * @return 队列
     */
    @Bean("chatQueue")
    public Queue chatQueue(){
        return QueueBuilder.durable(QUEUE_CHAT).build();
    }

    @Bean
    public Binding chatQueueExchange(@Qualifier("chatQueue") Queue queue, @Qualifier("chatExchange") Exchange exchange){
        /**
         * 配置topic的队列的路由
         */
        return BindingBuilder.bind(queue).to(exchange).with("chat.insert.#").noargs();
    }

}

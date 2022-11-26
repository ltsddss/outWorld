package com.lts.outworld_rabbitmq.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.lts.outworld_rabbitmq.constant.RabbitMqConstant.EXCHANGE_NAME;
import static com.lts.outworld_rabbitmq.constant.RabbitMqConstant.QUEUE_NAME;

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

//    用于新增新的elasticsearch信息的队列
    @Bean
    public Binding bingQueueExchange(@Qualifier("bootQueue") Queue queue, @Qualifier("bootExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("boot.insert.#").noargs();
    }

}

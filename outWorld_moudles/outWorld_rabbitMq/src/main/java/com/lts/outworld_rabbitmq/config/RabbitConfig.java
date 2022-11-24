package com.lts.outworld_rabbitmq.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private final String ELASTICSEARCH="elasticsearch_exchange";
    private final String ELASTICSEARCHQUEUE="elasticsearch_exchange";

//    配置交换机和队列的绑定关系
    @Bean("bootExchange")
    public Exchange bootExchange(){

        return ExchangeBuilder.topicExchange(ELASTICSEARCH).durable(true).build();
    }

    @Bean("bootQueue")
    public Queue bootQueue(){
        return QueueBuilder.durable(ELASTICSEARCHQUEUE).build();
    }
    @Bean
    public Binding bingQueueExchange(@Qualifier("bootQueue") Queue queue, @Qualifier("bootExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("boot.#").noargs();
    }

}

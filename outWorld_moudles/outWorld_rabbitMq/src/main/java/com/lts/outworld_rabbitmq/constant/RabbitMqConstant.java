package com.lts.outworld_rabbitmq.constant;

public class RabbitMqConstant {

    public static final String EXCHANGE_NAME="elasticsearch_exchange";
    public static final String QUEUE_NAME="elasticsearch_queue";

    /**
     * 弹幕交换机，用户将信息发送到此交换机
     */
    public static final String EXCHANGE_CHAT="chatExchange";

    public static final String QUEUE_CHAT="chatQueue";
}

package com.lts.outworld_liveborast.service.impl;

import com.lts.outworld_liveborast.entity.ChatInfo;
import com.lts.outworld_liveborast.service.chatService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class chatServiceImpl implements chatService {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Override
    public void acceptChatInfo(ChatInfo chatInfo) {
        /**
         * 接收弹幕数据，将弹幕发送到rabbitmq，广播给所有的队列
         * 并分发给所有的客户端
         */
        rabbitTemplate.convertAndSend("chat.insert.info",chatInfo);
    }

    @Override
    public void consumerChatInfo() {

    }

    @Override
    public void insertChatInfo() {

    }
}

package com.lts.outworld_liveborast.listen;

import com.google.inject.spi.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitLiveSpectator {

    /**
     * 对在线人数进行监听，将对应redis的数值加1
     * @param message
     */
    @RabbitListener(queues = "LiveSpectator_queue")
    public void ListenerLiveSpectator(Message message){
//        获取直播间的id
//        向redis中该直播间的在线观众加1
    }

    /**
     * 监听队列，实现信息消费
     * @param message 监听的消息体
     */
    @RabbitListener(queues = "chatQueue")
    public void ListenerChatInfo(Message message){

    }
}

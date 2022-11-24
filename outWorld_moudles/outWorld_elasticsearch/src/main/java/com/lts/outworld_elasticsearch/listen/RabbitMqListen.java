package com.lts.outworld_elasticsearch.listen;

import com.alibaba.fastjson.JSONObject;
import com.lts.outworld_elasticsearch.entity.LiveBorast;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RabbitMqListen {
    /**
     * 监听rabbit的关于elasticsearch的队列
     */

    @RabbitListener(queues = "elasticsearch_queue")
    public void ListenerQueue(Message message){
//        获取消息
//        LiveBorast liveBorast = JSONObject.parseObject(message.getBody(), LiveBorast.class);
//        System.out.println(liveBorast.toString());
//        System.out.println(new String(message.getBody()));
        String result=new String(message.getBody());
        LiveBorast liveBorast= JSONObject.parseObject(result,LiveBorast.class);
        
    }
}

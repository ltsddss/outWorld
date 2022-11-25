package com.lts.outworld_elasticsearch.listen;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RabbitMqListen {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 监听rabbit的关于elasticsearch的队列(实现关于mysql的直播表与elasticsearch的数据同步)
     */

    @RabbitListener(queues = "elasticsearch_queue")
    public void ListenerQueue(Message message) throws IOException {
//        获取消息
        String result = new String(message.getBody());
//        存入elasticsearch
        BulkRequest bulkRequest = new BulkRequest();
//        设置超时时间
        bulkRequest.timeout("10s");
        bulkRequest.add(
                new IndexRequest("live_borast")
                        .source(result, XContentType.JSON));
        restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
    }
}

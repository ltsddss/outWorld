package com.lts.outworld_manage.service.impl;

import com.alibaba.fastjson.JSON;
import com.lts.outworld_manage.dao.LiveBorastDao;
import com.lts.outworld_manage.entity.LiveBorast;
import com.lts.outworld_manage.service.LiveBorastService;
import com.lts.outworld_rabbitmq.config.RabbitConfig;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class LiveBorastServiceImpl implements LiveBorastService {

    @Autowired
    private LiveBorastDao liveBorastDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 同步mysql的数据到elasticSearch
     */
    @Override
    public void SameLiveBorastToMysql() {

        try{
            //        删除索引库
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("live_borast");
            AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
//        重新创建索引
            CreateIndexRequest createIndexRequest = new CreateIndexRequest("live_borast");
            restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
//        批量导入mysql的live——borast表
            List<LiveBorast> liveBorasts = liveBorastDao.liveBorastInfo(new LiveBorast());
            BulkRequest bulkRequest = new BulkRequest();
//        设置超时时间
            bulkRequest.timeout("10s");
            for (LiveBorast liveBorast : liveBorasts) {
                bulkRequest.add(
                        new IndexRequest("live_borast")
                                .source(JSON.toJSONString(liveBorast), XContentType.JSON)
                );
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 查询所有直播间
     * @param liveBorast 直播间
     * @return
     */
    @Override
    public List<LiveBorast> liveBorastInfo(LiveBorast liveBorast) {
        return liveBorastDao.liveBorastInfo(liveBorast);
    }

    /**
     * 新增直播间时向rabbitmq发送消息，让elasticsearch执行新增命令
     *
     * @param liveBorast 直播间信息
     * @return
     */
    @Override
    public int insertLiveBorastInfo(LiveBorast liveBorast) {
        //        通知rabbitmq
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "boot.insert.#", JSON.toJSONString(liveBorast));

        return liveBorastDao.insertLiveBorastInfo(liveBorast);
    }

    /**
     * 删除时(逻辑删除)直播间时向rabbitmq发送消息，让elasticsearch执行新增命令
     *
     * @param liveBorast 直播间信息
     * @return
     */
    @Override
    public int deleteLiveBorastInfo(LiveBorast liveBorast) {
//        TODO: 通知rabbitmq
        return 0;
    }

    /**
     * 修改时直播间时向rabbitmq发送消息，让elasticsearch执行新增命令
     *
     * @param liveBorast 直播间信息
     * @return
     */
    @Override
    public int updateLiveBorastInfo(LiveBorast liveBorast) {
//        TODO：通知rabbitmq
        return 0;
    }
}

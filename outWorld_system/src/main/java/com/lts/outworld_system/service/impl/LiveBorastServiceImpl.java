package com.lts.outworld_system.service.impl;

import com.alibaba.fastjson.JSON;
import com.lts.outworld_rabbitmq.config.RabbitConfig;
import com.lts.outworld_system.dao.LiveBorastDao;
import com.lts.outworld_system.entity.LiveBorast;
import com.lts.outworld_system.service.LiveBorastService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiveBorastServiceImpl implements LiveBorastService {

    @Autowired
    private LiveBorastDao liveBorastDao;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 新增直播间时向rabbitmq发送消息，让elasticsearch执行新增命令
     * @param liveBorast 直播间信息
     * @return
     */
    @Override
    public int insertLiveBorastInfo(LiveBorast liveBorast) {
        //        通知rabbitmq
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME,"boot.insert.#", JSON.toJSONString(liveBorast));

        return liveBorastDao.insertLiveBorastInfo(liveBorast);
    }
    /**
     * 删除时(逻辑删除)直播间时向rabbitmq发送消息，让elasticsearch执行新增命令
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
     * @param liveBorast 直播间信息
     * @return
     */
    @Override
    public int updateLiveBorastInfo(LiveBorast liveBorast) {
//        TODO：通知rabbitmq
        return 0;
    }
}

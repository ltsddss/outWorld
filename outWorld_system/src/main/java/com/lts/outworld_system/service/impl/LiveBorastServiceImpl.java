package com.lts.outworld_system.service.impl;

import com.alibaba.fastjson.JSON;
import com.lts.outworld_rabbitmq.constant.RabbitMqConstant;
import com.lts.outworld_system.dao.LiveBorastDao;
import com.lts.outworld_system.entity.LiveBorast;
import com.lts.outworld_system.service.LiveBorastService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiveBorastServiceImpl implements LiveBorastService {

    @Autowired
    private LiveBorastDao liveBorastDao;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    /**
     * 从数据库中查询直播间的数据
     * @param liveBorast 直播间
     * @return
     */
    @Override
    public List<LiveBorast> liveBorastInfo(LiveBorast liveBorast) {
//        先看看redis中是否存在改直播间的信息
        redisTemplate.opsForValue();
        return liveBorastDao.liveBorastInfo(liveBorast);
    }

    /**
     * 新增直播间时向rabbitmq发送消息，让elasticsearch执行新增命令
     * @param liveBorast 直播间信息
     * @return
     */
    @Override
    public int insertLiveBorastInfo(LiveBorast liveBorast) {
        //        通知rabbitmq
        rabbitTemplate.convertAndSend(RabbitMqConstant.EXCHANGE_NAME,"boot.insert.#", JSON.toJSONString(liveBorast));
        int result = liveBorastDao.insertLiveBorastInfo(liveBorast);
        return result;
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

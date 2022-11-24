package com.lts.outworld_system.service.impl;

import com.lts.outworld_system.dao.LiveBorastDao;
import com.lts.outworld_system.entity.LiveBorast;
import com.lts.outworld_system.service.LiveBorastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LiveBorastServiceImpl implements LiveBorastService {

    @Autowired
    private LiveBorastDao liveBorastDao;

    /**
     * 新增直播间时向rabbitmq发送消息，让elasticsearch执行新增命令
     * @param liveBorast 直播间信息
     * @return
     */
    @Override
    public int insertLiveBorastInfo(LiveBorast liveBorast) {
        return liveBorastDao.insertLiveBorastInfo(liveBorast);
    }
    /**
     * 删除时(逻辑删除)直播间时向rabbitmq发送消息，让elasticsearch执行新增命令
     * @param liveBorast 直播间信息
     * @return
     */
    @Override
    public int deleteLiveBorastInfo(LiveBorast liveBorast) {
        return 0;
    }
    /**
     * 修改时直播间时向rabbitmq发送消息，让elasticsearch执行新增命令
     * @param liveBorast 直播间信息
     * @return
     */
    @Override
    public int updateLiveBorastInfo(LiveBorast liveBorast) {
        return 0;
    }
}

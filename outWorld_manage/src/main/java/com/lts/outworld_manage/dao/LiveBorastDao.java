package com.lts.outworld_manage.dao;

import com.lts.outworld_manage.entity.LiveBorast;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LiveBorastDao {

    /**
     * 查询直播间信息
     * @param liveBorast 直播间
     * @return 直播间信息
     */
    List<LiveBorast> liveBorastInfo(LiveBorast liveBorast);

    /**
     * 新增直播间信息
     * @param liveBorast 直播间信息
     * @return 0/1
     */
    int insertLiveBorastInfo(LiveBorast liveBorast);

    /**
     * 删除直播间信息
     * @param liveBorast
     * @return
     */
    int deleteLiveBorastInfo(LiveBorast liveBorast);

    /**
     * 修改直播间信息
     * @param liveBorast
     * @return
     */
    int updateLiveBorastInfo(LiveBorast liveBorast);
}

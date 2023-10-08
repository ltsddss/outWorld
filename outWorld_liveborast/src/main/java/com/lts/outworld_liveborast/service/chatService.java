package com.lts.outworld_liveborast.service;

import com.lts.outworld_liveborast.entity.ChatInfo;

/**
 * 弹幕系统业务：
 *      1.将各个用户发送的弹幕推送到每一个直播间的聊天界面
 */
public interface chatService {
    /**
     * 接收用户发送的弹幕
     */
    public void acceptChatInfo(ChatInfo chatInfo);

    /**
     * 消费用户弹幕
     */
    public void consumerChatInfo();

    /**
     * 弹幕持久化
     */
    public void insertChatInfo();
}

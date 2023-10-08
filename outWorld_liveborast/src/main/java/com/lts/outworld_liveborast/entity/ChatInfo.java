package com.lts.outworld_liveborast.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatInfo {
    /**
     * id
     */
    public int id;
    /**
     * 头像地址
     */
    public String avatar;
    /**
     * 消息体
     */
    public String msg;
    /**
     * 弹幕播放速度
     */
    public int time;
}

package com.lts.outworld_liveborast.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiveBorast {
    /**
     * 直播间id
     */
    private int borastId;

    /**
     * 直播间封面
     */
    private String borast_img;

    /**
     * 直播间介绍
     */
    private String borast_introduce;

    /**
     * 直播间标题
     */
    private String borast_title;
    /**
     * 直播间名称（一般是用户的username）
     */
    private String borastName;

    /**
     * 直播间分区（0学习区，1游戏区）
     */
    private int borastPartition;
    /**
     * 直播间类型（0公共直播间，1私人直播间）
     */
    private int borastType;
    /**
     * 直播间密钥
     */
    private String borastPassword;
    /**
     * 直播间状态（0开始直播,1直播结束,2直播封禁中）
     */
    private int borastStatus;
    /**
     * 直播间是否禁言(0不禁言，1禁言)
     */
    private int borastChat;

    /**
     * 直播间点赞数
     */
    private int borastSupport;

    /**
     * 直播间观看人数
     */
    private int borastLooked;

    /**
     * 直播间所在服务器
     */
    private String borastAdress;
}


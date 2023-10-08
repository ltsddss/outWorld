package com.lts.outworld_liveborast.controller;

import com.lts.outworld_liveborast.entity.ChatInfo;
import com.lts.outworld_liveborast.service.chatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 弹幕系统
 */
@RestController
@RequestMapping("/chatInfo")
public class ChatController {

    @Autowired
    public chatService chatService;

    /**
     * 接收弹幕信息
     * @param chatInfo 弹幕信息
     */
    @PostMapping("/insertChatInfo")
    public void insertChatInfo(ChatInfo chatInfo){
        chatService.acceptChatInfo(chatInfo);
    }
}

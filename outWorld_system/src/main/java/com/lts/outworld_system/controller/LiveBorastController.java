package com.lts.outworld_system.controller;

import com.alibaba.fastjson.JSON;
import com.lts.outworld_rabbitmq.config.RabbitConfig;
import com.lts.outworld_system.entity.LiveBorast;
import com.lts.outworld_system.service.LiveBorastService;
import com.lts.utils.R;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elasticsearch")
public class LiveBorastController {

    @Autowired
    private LiveBorastService liveBorastService;

    /**
     * 新建直播间
     * @param liveBorast 直播间信息
     * @return 是否成功
     */
    @PostMapping("/insertLiveBorastInfo")
    public R<String> insertLiveBorast(@RequestBody LiveBorast liveBorast){
//        存库
        liveBorastService.insertLiveBorastInfo(liveBorast);

        return R.ok();
    }


}

package com.lts.outworld_liveborast.controller;

import com.lts.outworld_liveborast.entity.LiveBorast;
import com.lts.outworld_liveborast.service.LiveBorastService;
import com.lts.utils.R;
import com.lts.utils.Result;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/elasticsearch")
public class LiveBorastController {

    @Autowired
    private LiveBorastService liveBorastService;

    /**
     * 新建直播间
     *
     * @param liveBorast 直播间信息
     * @return 是否成功
     */
    @PostMapping("/insertLiveBorastInfo")
    public Result<String> insertLiveBorast(@RequestBody LiveBorast liveBorast) {
//        存库
        liveBorastService.insertLiveBorastInfo(liveBorast);

        return null;
    }

    /**
     * 点击对应直播间的时候显示对应的信息(根据直播间的id查询)
     *
     * @return
     */
    @GetMapping("/selectLiveBorast")
    public Result<LiveBorast> selectLiveBorast(@RequestBody LiveBorast liveBorast) {
        return null;
    }

    @GetMapping("/getLiveSpectatorNumber")
    public Result<LiveBorast> getLiveSpectatorNumber(LiveBorast liveBorast){
//        获取直播间的id
//        向redis查询直播间的人数
//        向rabbitmq发送改直播间人数加一的信息
//        返回结果
        return null;
    }
}

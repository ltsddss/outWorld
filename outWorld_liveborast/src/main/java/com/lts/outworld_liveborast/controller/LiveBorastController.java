package com.lts.outworld_liveborast.controller;

import com.lts.outworld_liveborast.entity.LiveBorast;
import com.lts.outworld_liveborast.service.LiveBorastService;
import com.lts.utils.R;
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
    public R<String> insertLiveBorast(@RequestBody LiveBorast liveBorast) {
//        存库
        liveBorastService.insertLiveBorastInfo(liveBorast);

        return R.ok();
    }

    /**
     * 点击对应直播间的时候显示对应的信息(根据直播间的id查询)
     *
     * @return
     */
    @GetMapping("/selectLiveBorast")
    public R<LiveBorast> selectLiveBorast(@RequestBody LiveBorast liveBorast) {
        return R.ok(liveBorastService.liveBorastInfo(liveBorast).get(0));
    }
}

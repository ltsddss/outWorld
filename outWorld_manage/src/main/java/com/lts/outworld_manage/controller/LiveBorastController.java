package com.lts.outworld_manage.controller;

import com.lts.outworld_manage.service.liveborastService.LiveBorastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elasticsearch")
public class LiveBorastController {

    @Autowired
    private LiveBorastService liveBorastService;
    /**
     * 同步mysql到elasticsearch
     */
    @GetMapping("/SameToElasticsearch")
    public void SameToElasticsearch(){
        liveBorastService.SameLiveBorastToMysql();
    }
}

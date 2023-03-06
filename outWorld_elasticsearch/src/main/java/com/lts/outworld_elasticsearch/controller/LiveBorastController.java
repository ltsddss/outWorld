package com.lts.outworld_elasticsearch.controller;

import com.lts.outworld_elasticsearch.entity.LiveBorast;
import com.lts.outworld_elasticsearch.entity.Question;
import com.lts.outworld_elasticsearch.service.ElasticSearchService;
import com.lts.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/elasticsearch")
public class LiveBorastController {

    @Autowired
    private ElasticSearchService elasticSearchService;

    /**
     * 从elasticSearch中查找对应相关性最高的一个问题
     * @param question 问题内容
     * @return 相关性最高的内容
     */
    @PostMapping("/getElasticsearchBorast")
    public R<List<LiveBorast>> getElasticsearchBorast(@RequestBody Question question){
        try {
            return elasticSearchService.getInfoForLiveBorast(question.getPageNumber(),question.getQuestion());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

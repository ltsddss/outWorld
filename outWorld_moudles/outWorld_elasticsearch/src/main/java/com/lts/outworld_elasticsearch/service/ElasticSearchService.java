package com.lts.outworld_elasticsearch.service;

import com.alibaba.fastjson.JSON;
import com.lts.outworld_elasticsearch.entity.LiveBorast;
import com.lts.utils.R;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class ElasticSearchService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 返回10条直播间的一些信息
     * @param question 查询信息
     * @return 直播间信息
     */
    public R<LiveBorast> getInfoForLiveBorast(int pageNumber,String question) throws IOException {
        SearchRequest request=new SearchRequest("live_borast");
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("borastTitle", question);
        searchSourceBuilder.query(termQueryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchSourceBuilder.from(pageNumber);
        searchSourceBuilder.size(10);
        request.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        System.out.println(JSON.toJSONString(search.getHits().getHits()));
        System.out.println("==================");
        return null;
    }


}

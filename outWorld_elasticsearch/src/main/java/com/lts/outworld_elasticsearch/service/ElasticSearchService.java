package com.lts.outworld_elasticsearch.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lts.outworld_elasticsearch.entity.LiveBorast;
import com.lts.utils.R;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    public R<List<LiveBorast>> getInfoForLiveBorast(int pageNumber,String question) throws IOException {
        SearchRequest request=new SearchRequest("live_borast");
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("borastTitle", question);
        searchSourceBuilder.query(termQueryBuilder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchSourceBuilder.from(pageNumber);
        searchSourceBuilder.size(10);
//        设置是否按匹配度排序
        searchSourceBuilder.explain(true);
        request.source(searchSourceBuilder);
        SearchResponse search = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHit[] searchHits = search.getHits().getHits();

        List<LiveBorast> list=new ArrayList<>();
        for (SearchHit searchHit : searchHits) {
            list.add(JSONObject.parseObject(JSONObject.toJSONString(searchHit.getSourceAsMap()),LiveBorast.class));
        }
//        处理返回的map数据，将map转为对象

        return R.ok(list);
    }


}

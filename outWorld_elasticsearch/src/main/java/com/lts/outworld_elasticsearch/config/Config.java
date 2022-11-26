package com.lts.outworld_elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public RestHighLevelClient restHighLevelClient(){

        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1",9200,"HTTP")
                )
        );
    }
}

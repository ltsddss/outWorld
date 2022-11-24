package com.lts.outworld_elasticsearch.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    /**
     * 当前页
     */
    private int pageNumber;

    /**
     * 一次获取多少数据
     */
    private int limitSize;

    /**
     * 查询的数据的拆线呢参数
     */
    private String question;
}

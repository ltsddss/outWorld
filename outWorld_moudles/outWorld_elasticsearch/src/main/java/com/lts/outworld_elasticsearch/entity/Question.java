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
     * 查询的数据的拆线呢参数
     */
    private String question;
}

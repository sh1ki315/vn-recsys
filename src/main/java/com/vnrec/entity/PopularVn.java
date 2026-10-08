package com.vnrec.entity;

import lombok.Data;

/**
 * 热门作品：一部作品 + 它在样本内被评分的次数
 */
@Data
public class PopularVn {

    private String vnId;
    private String title;
    private Integer voteNumbers;
}
package com.vnrec.entity;

import lombok.Data;

/**
 * 相似用户：一个和我口味相似的人 + 我和他共同玩过几部作品
 */
@Data
public class SimilarUser {

    private String userId;
    private Integer similarWorksCount;
}
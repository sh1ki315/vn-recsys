package com.vnrec.service;

import com.vnrec.entity.RecommendedVn;
import com.vnrec.entity.SimilarUser;

import java.util.List;

public interface RecommendService {

    /**
     * 查询和某个用户口味相似的用户
     */
    List<SimilarUser> listSimilarUsers(String userId, Integer topWorks);
    /**
     * 推荐你可能喜欢的作品
     */
    List<RecommendedVn> listOsusume(String userId, Integer topWorks);
}
package com.vnrec.service;

import com.vnrec.entity.PopularVn;
import com.vnrec.entity.SimilarVn;
import com.vnrec.entity.Vn;

import java.util.List;

public interface VnService {

    /**
     * 查询票数最多的 N 部作品（按 VNDB 全站票数）
     */
    List<Vn> listTopVns(Integer topWorks);

    /**
     * 查询样本内被评分最多的作品（按 user_vote 表统计）
     */
    List<PopularVn> listTopVotedVns(Integer topWorks);
    /**
     * 查询用户玩过什么其他作品
     */
    List<SimilarVn> listSimilarVns(String vnId, Integer topWorks);
}
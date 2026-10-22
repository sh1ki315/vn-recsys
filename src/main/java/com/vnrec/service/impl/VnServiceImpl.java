package com.vnrec.service.impl;

import com.vnrec.entity.PopularVn;
import com.vnrec.entity.SimilarVn;
import com.vnrec.entity.Vn;
import com.vnrec.mapper.VnMapper;
import com.vnrec.service.VnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VnServiceImpl implements VnService {

    private static final int DEFAULT_TOP_WORKS = 10;

    @Autowired
    private VnMapper vnMapper;

    /**
     * 查询票数最多的 N 部作品（按 VNDB 全站票数）
     */
    @Override
    public List<Vn> listTopVns(Integer topWorks) {
        if (topWorks == null) {
            topWorks = DEFAULT_TOP_WORKS;
        }
        return vnMapper.listTopVns(topWorks);
    }

    /**
     * 查询样本内被评分最多的作品（按 user_vote 表统计）
     */
    @Override
    public List<PopularVn> listTopVotedVns(Integer topWorks) {
        if (topWorks == null) {
            topWorks = DEFAULT_TOP_WORKS;
        }
        return vnMapper.listTopVotedVns(topWorks);
    }

    /**
     * 查询和某部作品相似的其他作品
     */
    @Override
    public List<SimilarVn> listSimilarVns(String vnId, Integer topWorks) {
        if (topWorks == null) {
            topWorks = DEFAULT_TOP_WORKS;
        }
        return vnMapper.listSimilarVns(vnId, topWorks);
    }
}
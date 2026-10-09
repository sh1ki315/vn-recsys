package com.vnrec.controller;

import com.vnrec.entity.PopularVn;
import com.vnrec.entity.SimilarVn;
import com.vnrec.entity.Vn;
import com.vnrec.result.Result;
import com.vnrec.service.VnService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vn")
public class VnController {

    private final VnService vnService;

    public VnController(VnService vnService) {
        this.vnService = vnService;
    }

    /**
     * 查询票数最多的 N 部作品（按 VNDB 全站票数）
     */
    @GetMapping("/top")
    public Result<List<Vn>> listTopVns(Integer topWorksCount) {
        List<Vn> vnList = vnService.listTopVns(topWorksCount);
        return Result.success(vnList);
    }

    /**
     * 查询样本内被评分最多的作品（按 user_vote 表统计）
     */
    @GetMapping("/top-voted")
    public Result<List<PopularVn>> listTopVotedVns(Integer topWorks) {
        List<PopularVn> popularVnList = vnService.listTopVotedVns(topWorks);
        return Result.success(popularVnList);
    }
    /**
     * 查询用户玩过什么其他作品
     */
    @GetMapping("/similar")
    public Result<List<SimilarVn>> listSimilarVns(String vnId, Integer topWorks) {
        List<SimilarVn> similarVnList = vnService.listSimilarVns(vnId, topWorks);
        return Result.success(similarVnList);
    }

}
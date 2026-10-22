package com.vnrec.controller;

import com.vnrec.entity.RecommendedVn;
import com.vnrec.entity.SimilarUser;
import com.vnrec.result.Result;
import com.vnrec.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    /**
     * 查询和某个用户口味相似的用户
     */
    @GetMapping("/similar-users")
    public Result<List<SimilarUser>> listSimilarUsers(String userId, Integer topWorks) {
        List<SimilarUser> similarUsers = recommendService.listSimilarUsers(userId, topWorks);
        return Result.success(similarUsers);
    }
    /**
     * 推荐你可能喜欢的作品
     */
    @GetMapping("/osusume")
    public Result<List<RecommendedVn>> listOsusume(String userId, Integer topWorks) {
        List<RecommendedVn> recommendedVnList = recommendService.listOsusume(userId, topWorks);
        return Result.success(recommendedVnList);
    }
}
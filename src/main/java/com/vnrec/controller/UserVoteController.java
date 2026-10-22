package com.vnrec.controller;

import com.vnrec.entity.UserVoteDetail;
import com.vnrec.result.Result;
import com.vnrec.service.UserVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-vote")
public class UserVoteController {

    @Autowired
    private UserVoteService userVoteService;

    /**
     * 查询用户评分总条数
     */
    @GetMapping("/count")
    public Result<Integer> countUserVotes() {
        Integer voteNumbers = userVoteService.countUserVotes();
        return Result.success(voteNumbers);
    }

    /**
     * 查询某个用户评分过的所有作品
     */
    @GetMapping("/list")
    public Result<List<UserVoteDetail>> listUserVotes(String userId) {
        List<UserVoteDetail> userVoteDetails = userVoteService.listUserVotesByUserId(userId);
        return Result.success(userVoteDetails);
    }
}
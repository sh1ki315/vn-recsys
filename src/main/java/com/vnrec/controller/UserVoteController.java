package com.vnrec.controller;

import com.vnrec.entity.UserVoteDetail;
import com.vnrec.entity.Vn;
import com.vnrec.result.Result;
import com.vnrec.service.UserVoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user-vote")
public class UserVoteController {

    private final UserVoteService userVoteService;

    public UserVoteController(UserVoteService userVoteService) {
        this.userVoteService = userVoteService;
    }

    /**
     * 查询用户评分总条数
     */
    @GetMapping("/count")
    public Result<Integer> countUserVotes() {
        Integer voteNumbers = userVoteService.countUserVotes();
        return Result.success(voteNumbers);
    }
    /**
     * 查询用户评分
     */
    @GetMapping("/list")
    public Result<List<UserVoteDetail>> listUserVotes(String userId) {
        List<UserVoteDetail> listUserVotesByUserId = userVoteService.listUserVotesByUserId(userId);
        return Result.success(listUserVotesByUserId);
    }
}
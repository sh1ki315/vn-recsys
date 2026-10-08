package com.vnrec.controller;

import com.vnrec.result.Result;
import com.vnrec.service.UserVoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
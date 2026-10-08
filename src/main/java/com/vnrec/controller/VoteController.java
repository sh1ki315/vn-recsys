package com.vnrec.controller;

import com.vnrec.entity.Vn;
import com.vnrec.result.Result;
import com.vnrec.service.VoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vote")
public class VoteController {
    private VoteService voteService;
    public  VoteController(VoteService voteService){
        this.voteService=voteService;
    }
  @GetMapping("/numbers")
    public Result<Integer> getVoteNumbers(){
        return Result.success(voteService.voteNumbers());
    }

}

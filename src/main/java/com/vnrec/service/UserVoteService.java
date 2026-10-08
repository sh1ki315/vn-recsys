package com.vnrec.service;

import com.vnrec.entity.UserVoteDetail;

import java.util.List;

public interface UserVoteService {

    /**
     * 查询用户评分总条数
     */
    int countUserVotes();
    List<UserVoteDetail> listUserVotesByUserId(String userId);
}
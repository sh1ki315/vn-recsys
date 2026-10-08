package com.vnrec.service.impl;

import com.vnrec.entity.UserVoteDetail;
import com.vnrec.mapper.UserVoteMapper;
import com.vnrec.service.UserVoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVoteServiceImpl implements UserVoteService {

    private final UserVoteMapper userVoteMapper;

    public UserVoteServiceImpl(UserVoteMapper userVoteMapper) {
        this.userVoteMapper = userVoteMapper;
    }

    /**
     * 查询用户评分总条数
     */
    @Override
    public int countUserVotes() {
        return userVoteMapper.countUserVotes();
    }

    @Override
    public List<UserVoteDetail> listUserVotesByUserId(String userId) {
        return userVoteMapper.listUserVotesByUserId(userId);
    }
}
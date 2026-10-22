package com.vnrec.service.impl;

import com.vnrec.entity.UserVoteDetail;
import com.vnrec.mapper.UserVoteMapper;
import com.vnrec.service.UserVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVoteServiceImpl implements UserVoteService {

    @Autowired
    private UserVoteMapper userVoteMapper;

    /**
     * 查询用户评分总条数
     */
    @Override
    public int countUserVotes() {
        return userVoteMapper.countUserVotes();
    }

    /**
     * 查询某个用户评分过的所有作品
     */
    @Override
    public List<UserVoteDetail> listUserVotesByUserId(String userId) {
        return userVoteMapper.listUserVotesByUserId(userId);
    }
}
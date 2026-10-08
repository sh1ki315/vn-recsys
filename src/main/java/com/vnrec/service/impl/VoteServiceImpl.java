package com.vnrec.service.impl;

import com.vnrec.mapper.VoteMapper;
import com.vnrec.service.VoteService;
import org.springframework.stereotype.Service;

//@Service
//public class VoteServiceImpl implements VoteService {
//    @Override
//    public int voteNumbers() {
//        return voteMapper.voteNumbers();
//    }
//}

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteMapper voteMapper;

    public VoteServiceImpl(VoteMapper voteMapper) {
        this.voteMapper = voteMapper;
    }

    @Override
    public int voteNumbers() {
        return voteMapper.voteNumbers();
    }
}
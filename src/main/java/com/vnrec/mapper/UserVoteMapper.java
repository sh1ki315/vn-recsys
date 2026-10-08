package com.vnrec.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserVoteMapper {

    /**
     * 查询用户评分总条数
     */
    @Select("select count(*) from user_vote")
    int countUserVotes();
}
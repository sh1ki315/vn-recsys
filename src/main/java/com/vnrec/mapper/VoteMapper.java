package com.vnrec.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VoteMapper {
    @Select("SELECT COUNT(*)FROM votes")
    int voteNumbers();
}

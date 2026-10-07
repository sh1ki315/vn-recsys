package com.vnrec.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper

public interface VotesMapper {
    @Select("select COUNT(*) from votes")
    int countVotes();

   @Select("select COUNT(*) from vn")
    int countVn();
}

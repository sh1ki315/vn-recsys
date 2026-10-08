package com.vnrec.mapper;

import com.vnrec.entity.UserVoteDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserVoteMapper {

    /**
     * 查询用户评分总条数
     */
    @Select("select count(*) from user_vote")
    int countUserVotes();
    /**
     * 根据用户ID查询用户评分
     */
    @Select("SELECT t.user_id, t.vn_id, v.title, t.vote FROM user_vote t join vn v on t.vn_id=v.vn_id where t.user_id=#{userId}")
    List<UserVoteDetail> listUserVotesByUserId(@Param("userId")String userId);
}
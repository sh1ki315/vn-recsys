package com.vnrec.mapper;

import com.vnrec.entity.SimilarUser;
import com.vnrec.entity.UserVote;
import com.vnrec.entity.Vn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecommendMapper {

    /**
     * 查询和某个用户共同玩过 2 部以上作品的用户
     */
    @Select("select t2.user_id, count(*) as similar_works_count "
            + "from user_vote t1 "
            + "join user_vote t2 on t1.vn_id = t2.vn_id "
            + "where t1.user_id = #{userId} and t2.user_id <> #{userId} "
            + "group by t2.user_id "
            + "having count(*) >= 2 "
            + "order by similar_works_count desc "
            + "limit #{topWorks}")
    List<SimilarUser> listSimilarUsers(@Param("userId") String userId, @Param("topWorks") int topWorks);

   /**
   查询评分总数
    */
   @Select("select user_id,vn_id,vote from user_vote")
    List<UserVote> listAllUserVotes();
   /**
    * 查询全部作品（为了标题）
    */
   @Select("select vn_id,title,vote_count from vn")
    List<Vn> listAllVns();
}
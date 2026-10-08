package com.vnrec.mapper;

import com.vnrec.entity.PopularVn;
import com.vnrec.entity.Vn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VnMapper {

    /**
     * 查询票数最多的 N 部作品（按 VNDB 全站票数）
     */
    @Select("select vn_id, title, vote_count from vn order by vote_count desc limit #{topWorks}")
    List<Vn> listTopVns(@Param("topWorks") int topWorks);

    /**
     * 查询样本内被评分最多的作品（按 user_vote 表统计）
     */
    @Select("select v.vn_id, v.title, count(*) as vote_numbers "
            + "from user_vote t "
            + "join vn v on v.vn_id = t.vn_id "
            + "group by v.vn_id, v.title "
            + "order by vote_numbers desc "
            + "limit #{topWorks}")
    List<PopularVn> listTopVotedVns(@Param("topWorks") int topWorks);
}
package com.vnrec.mapper;

import com.vnrec.entity.Vn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VnMapper {

    @Select("select vn_id, title, vote_count from vn order by vote_count desc limit #{topWorks}")
    List<Vn> listTopVns(@Param("topWorks") int topWorks);
}
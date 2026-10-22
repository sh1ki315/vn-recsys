package com.vnrec.service.impl;

import com.vnrec.entity.RecommendedVn;
import com.vnrec.entity.SimilarUser;
import com.vnrec.entity.UserVote;
import com.vnrec.entity.Vn;
import com.vnrec.mapper.RecommendMapper;
import com.vnrec.service.RecommendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.MarshalledObject;
import java.util.*;
@Slf4j
@Service
public class RecommendServiceImpl implements RecommendService {

    private static final int DEFAULT_TOP_WORKS = 10;

    @Autowired
    private RecommendMapper recommendMapper;

    /**
     * 查询和某个用户口味相似的用户
     */
    @Override
    public List<SimilarUser> listSimilarUsers(String userId, Integer topWorks) {
        if (topWorks == null) {
            topWorks = DEFAULT_TOP_WORKS;
        }
        return recommendMapper.listSimilarUsers(userId, topWorks);
    }
    @Override
    //  第 1 步：读出全部评分和全部作品
    public List<RecommendedVn> listOsusume(String userId, Integer topWorks) {
        if (topWorks == null) {
            topWorks = DEFAULT_TOP_WORKS;
        }
        List<UserVote> userVotes = recommendMapper.listAllUserVotes();
        List<Vn> vns = recommendMapper.listAllVns();
        // 第 2 步：用户玩过哪些作品
        Map<String, Set<String>> userWorks = new HashMap<>();
        for (UserVote uv : userVotes) {
            userWorks.computeIfAbsent(uv.getUserId(), k -> new HashSet<>()).add(uv.getVnId());
        }
        Set<String> myWorks = userWorks.get(userId);
        if (myWorks == null) {
            log.warn("用户不存在:{}", userId);
            return new ArrayList<>();
        }
        // 第 3 步：找相似用户
        Map<String, Integer> similarUser = new HashMap<>();
        for (Map.Entry<String, Set<String>> userEntry : userWorks.entrySet()) {
            if (userEntry.getKey().equals(userId)) {
                continue;
            }
            int common = 0;
            for (String vnId : userEntry.getValue()) {
                if (myWorks.contains(vnId)) {
                    common++;
                }
            }
            if (common >= 5) {
                similarUser.put(userEntry.getKey(), common);
            }
        }
        // 第 4 步：收集候选作品并打分
        Map<String, Integer> scores = new HashMap<>();
        for (Map.Entry<String, Integer> su : similarUser.entrySet()) {
            String otherUserId = su.getKey();
            int hisSimilarity = su.getValue();
            Set<String> hisWorks = userWorks.get(otherUserId);

            for (String vnId : hisWorks) {
                //如果已经玩过则不重复推荐
                if (myWorks.contains(vnId)) {
                    continue;
                }
                scores.merge(vnId, hisSimilarity, Integer::sum);

            }
        }
        // 第 5 步：按分数排序，取前 N 部，补上标题
        scores.entrySet().stream().sorted((a,b)->b.getValue()-a.getValue()).limit(10).forEach(e-> System.out.println(" "+e.getKey()+"->"+e.getValue()));
       Map<String,String>vnTitle=new HashMap<>();
       for (Vn v:vns){
           vnTitle.put(v.getVnId(),v.getTitle());
       }
       //按照分数从大到小排序
        List<Map.Entry<String,Integer>>sorted=new ArrayList<>(scores.entrySet());
       sorted.sort((a,b)->b.getValue()-a.getValue());
       //获取topWorks条，补上标题
        List<RecommendedVn> result=new ArrayList<>();
        for (int i=0;i<Math.min(topWorks,sorted.size());i++){
            Map.Entry<String,Integer>e=sorted.get(i);
            result.add(new RecommendedVn(e.getKey(), vnTitle.get(e.getKey()), e.getValue()));
        }
        return result;
    }
}
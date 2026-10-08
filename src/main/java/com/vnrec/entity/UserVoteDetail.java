package com.vnrec.entity;

import lombok.Data;

@Data
public class UserVoteDetail {
    private String userId;
    private String vnId;
    private String title;
    private Integer vote;

}

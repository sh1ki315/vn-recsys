package com.vnrec.entity;

import lombok.Data;

@Data
public class UserVote {
    private String userId;
    private String vnId;
    private int vote;
}

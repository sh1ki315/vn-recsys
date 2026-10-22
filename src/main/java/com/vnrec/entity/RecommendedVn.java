package com.vnrec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecommendedVn {
    private String vnId;
    private String title;
    private Integer recommendScore;
}

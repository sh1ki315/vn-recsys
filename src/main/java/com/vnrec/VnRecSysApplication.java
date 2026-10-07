package com.vnrec;

import com.vnrec.mapper.VotesMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VnRecSysApplication implements CommandLineRunner {

    private final VotesMapper votesMapper;

    public VnRecSysApplication(VotesMapper votesMapper) {
        this.votesMapper = votesMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(VnRecSysApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("votes 表: " + votesMapper.countVotes() + " 行");
        System.out.println("vn 表: " + votesMapper.countVn() + " 行");

    }

}
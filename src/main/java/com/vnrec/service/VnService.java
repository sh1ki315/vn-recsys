package com.vnrec.service;

import com.vnrec.entity.Vn;

import java.util.List;

public interface VnService {

    List<Vn> listTopVns(Integer topWorks);
}
package com.vnrec.service.impl;

import com.vnrec.entity.Vn;
import com.vnrec.mapper.VnMapper;
import com.vnrec.service.VnService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VnServiceImpl implements VnService {

    private static final int DEFAULT_TOP_WORKS = 10;

    private final VnMapper vnMapper;

    public VnServiceImpl(VnMapper vnMapper) {
        this.vnMapper = vnMapper;
    }

    @Override
    public List<Vn> listTopVns(Integer topWorks) {
        if (topWorks == null) {
            topWorks = DEFAULT_TOP_WORKS;
        }
        return vnMapper.listTopVns(topWorks);
    }
}
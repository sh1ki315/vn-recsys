package com.vnrec.controller;

import com.vnrec.entity.Vn;
import com.vnrec.result.Result;
import com.vnrec.service.VnService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vn")
public class VnController {

    private final VnService vnService;

    public VnController(VnService vnService) {
        this.vnService = vnService;
    }

    /**
     * 查询票数最多的 N 部作品
     */
    @GetMapping("/top")
    public Result<List<Vn>> listTopVns(Integer topWorks) {
        List<Vn> vnList = vnService.listTopVns(topWorks);
        return Result.success(vnList);
    }
}
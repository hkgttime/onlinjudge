package org.oj.controller;

import org.oj.api.UserControllerApi;
import org.oj.entity.Restful;
import org.oj.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankList implements UserControllerApi {

    @Autowired
    private RankService rankService;

    @GetMapping("/ranklist")
    public Restful rankList(int page){

        return null;
    }
}

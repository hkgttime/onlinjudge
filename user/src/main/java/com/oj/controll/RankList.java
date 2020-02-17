package com.oj.controll;

import com.oj.api.UserControllerApi;
import com.oj.entity.Restful;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RankList implements UserControllerApi {



    @GetMapping("/ranklist")
    public Restful rankList(int page){

        return null;
    }
}

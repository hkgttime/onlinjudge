package org.oj.controll;

import org.oj.api.UserControllerApi;
import org.oj.entity.Restful;
import org.oj.entity.UserBean;
import org.oj.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RankList implements UserControllerApi {

    @Autowired
    private RankService rankService;

    @GetMapping("/ranklist")
    public Restful rankList(int page){
        if (page <= 20){
            ArrayList<UserBean> list = rankService.getTwentyPages(page);
            return list;
        }
        return null;
    }
}

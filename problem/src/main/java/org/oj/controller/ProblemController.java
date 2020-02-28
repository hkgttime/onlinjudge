package org.oj.controller;

import org.oj.api.ProblemControllerApi;
import org.oj.entity.Restful;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/problem/")
public class ProblemController implements ProblemControllerApi {


    @Override
    @GetMapping("")
    public Restful getProblem(String pid) {

        return null;
    }

    @Override
    @GetMapping("getlist/{page}")
    public Restful getProblemList(int page) {
        return null;
    }
}

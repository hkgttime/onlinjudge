package org.oj.controller;

import org.oj.api.ProblemControllerApi;
import org.oj.entity.Restful;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProblemController implements ProblemControllerApi {


    @Override
    @GetMapping("/problem/{pid}")
    public Restful getProblem(@PathVariable String pid) {

        return null;
    }

    @Override
    @GetMapping("/problemlist/{page}")
    public Restful getProblemList(int page) {
        return null;
    }
}

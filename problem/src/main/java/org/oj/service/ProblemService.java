package org.oj.service;

import org.oj.api.ProblemServiceApi;
import org.oj.entity.Problem;
import org.oj.entity.ProblemList;
import org.oj.mapper.ProblemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;

public class ProblemService implements ProblemServiceApi {

    @Autowired
    private ProblemMapper mapper;

    @Cacheable(cacheNames = "problem", keyGenerator = "problemKey")
    public Problem getProblemServe(String pid){
       Problem problem = mapper.getProblemById(pid);
       return problem;
    }

    public ArrayList<ProblemList> getProblemListServe(int page){
       ArrayList<ProblemList> list =  mapper.getProblemList(page);
       return list;
    }
}

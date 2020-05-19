package org.oj.api;

import org.oj.entity.Problem;
import org.oj.entity.ProblemList;

import java.util.ArrayList;

public interface ProblemServiceApi {
    Problem getProblemServe(String pid);

    ArrayList<ProblemList> getProblemListServe(int page);
}

package org.oj.api;

import org.oj.entity.Restful;

public interface ProblemControllerApi {
    Restful getProblem(String pid);
    Restful getProblemList();
}

package org.oj.controller;

import org.oj.api.ProblemManageApi;
import org.oj.entity.CaseFile;
import org.oj.entity.Problem;
import org.oj.entity.Restful;

public class ProblemManageController implements ProblemManageApi {
    @Override
    public Restful createProblem(Problem problem, CaseFile file) {
        return null;
    }

    @Override
    public Restful upLoadCaseFile(CaseFile file) {
        return null;
    }

    @Override
    public Restful delCaseFile(String cid) {
        return null;
    }

    @Override
    public Restful delProblem(String pid) {
        return null;
    }

    @Override
    public Restful updateProblem(Problem problem) {
        return null;
    }
}

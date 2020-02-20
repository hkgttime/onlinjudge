package org.oj.api;

import org.oj.entity.CaseFile;
import org.oj.entity.Problem;
import org.oj.entity.Restful;

public interface ProblemManageApi {
    Restful createProblem(Problem problem, CaseFile file);
    Restful upLoadCaseFile(CaseFile file);
    Restful delCaseFile(CaseFile file);
    Restful delProblem(Problem problem);
    Restful updateProblem();
}

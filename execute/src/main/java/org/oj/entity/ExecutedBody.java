package org.oj.entity;

public class ExecutedBody {

   private String eid;
   private RunCode runCode;

    public ExecutedBody() {
    }

    public ExecutedBody(String eid, RunCode runCode) {
        this.eid = eid;
        this.runCode = runCode;
    }

    public String getEid() {
        return eid;
    }

    public RunCode getRunCode() {
        return runCode;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public void setRunCode(RunCode runCode) {
        this.runCode = runCode;
    }
}

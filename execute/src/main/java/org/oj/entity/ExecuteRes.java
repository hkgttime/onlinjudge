package org.oj.entity;

public class ExecuteRes {
    private String execId;
    private StatusCode code;
    private String commitCode;
    private String msg;

    public String getExecId() {
        return execId;
    }

    public StatusCode getCode() {
        return code;
    }

    public String getCommitCode() {
        return commitCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setExecId(String execId) {
        this.execId = execId;
    }

    public void setCode(StatusCode code) {
        this.code = code;
    }

    public void setCommitCode(String commitCode) {
        this.commitCode = commitCode;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

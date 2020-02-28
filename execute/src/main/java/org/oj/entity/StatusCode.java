package org.oj.entity;

public enum StatusCode {

    Accepted(1),
    WrongAnswer(2),
    RuntimeError(3),
    TimeLimitExceeded(4),
    MemoryLimitExceeded(5),
    CompileError(6);

    int code;

     StatusCode(int code){
        this.code = code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

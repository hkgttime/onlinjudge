package org.oj.entity;

public class Restful {
    public ResultCode resultCode;
    public Object data;

    public Restful() {
    }

    public Restful(ResultCode resultCode, Object data) {
        this.resultCode = resultCode;
        this.data = data;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

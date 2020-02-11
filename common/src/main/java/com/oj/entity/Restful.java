package com.oj.entity;

public class Restful {
    public int responseCode;
    public String msg;
    public Object data;

    public Restful(int responseCode, String msg, Object data) {
        this.responseCode = responseCode;
        this.msg = msg;
        this.data = data;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

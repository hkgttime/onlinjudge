package org.oj.entity;

public class Restful {
    public ReslutCode reslutCode;
    public Object data;

    public Restful() {
    }

    public Restful(ReslutCode reslutCode, Object data) {
        this.reslutCode = reslutCode;
        this.data = data;
    }

    public ReslutCode getReslutCode() {
        return reslutCode;
    }

    public Object getData() {
        return data;
    }

    public void setReslutCode(ReslutCode reslutCode) {
        this.reslutCode = reslutCode;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

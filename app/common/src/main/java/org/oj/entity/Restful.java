package org.oj.entity;

import lombok.Data;

@Data
public class Restful {
    public String resultCode;
    public String resultMsg;
    public Object data;

    public Restful() {
    }

    public Restful(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public Restful(String resultCode, String resultMsg, Object data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }


}

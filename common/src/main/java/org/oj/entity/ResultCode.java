package org.oj.entity;

public enum ResultCode {

    OK("00000","Request successful"),
    Failed("11111","Request failed"),

    user_not_exists("20101", "User does not exists"),
    token_expired("20103", "Token expired"),
    token_revoked("20104", "Token revoked"),
    need_auth("20105", "Manage notice error, need auth"),
    email_used("20106", "The email has been used"),
    username_used("20107", "The username has been used"),

    messaging_exception("10101", "Email send exception"),
    runtime_exception("10032", "Runtime Exception");


    String code;
    String msg;

    ResultCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "code:'" + code + '\'' +
                ", msg:'" + msg + '\'' +
                '}';
    }
}

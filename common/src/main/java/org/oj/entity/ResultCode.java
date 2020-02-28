package org.oj.entity;

public enum ResultCode {

    OK("Request successful"),
    Failed("Request failed"),

    C_20101("User does not exists"),
    C_20102("Your ip's behave in a comic boisterous or unruly manner"),
    C_20103("Token expired"),
    C_20104("Token revoked"),
    C_20105("Manage notice error, need auth"),
    C_20106("The email has been used"),
    C_20107("The username has been used"),


    C_20201("List does not exists"),


    C_20301("send notice over the restrictions"),

    S_10032("Commit success, while server slow now, please wait 1-2 minutes");


    String msg;

    ResultCode (String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

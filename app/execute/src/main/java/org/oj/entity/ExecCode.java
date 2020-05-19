package org.oj.entity;

public enum ExecCode {

    OJ_WT0(0),
    OJ_WT1(1),
    OJ_CI(2),
    OJ_RI(3),
    OJ_AC(4),
    OJ_PE(5),
    OJ_WA(6),
    OJ_TL(7),
    OJ_ML(8),
    OJ_OL(9),
    OJ_RE(10),
    OJ_CE(11),
    OJ_CO(12);

    int code;

    ExecCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }


}

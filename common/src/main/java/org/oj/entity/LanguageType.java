package org.oj.entity;

public enum LanguageType {

    JAVA("1990"),
    C("1972");

    String code;

    LanguageType(String code){};

    public String getCode() {
        return code;
    }
}

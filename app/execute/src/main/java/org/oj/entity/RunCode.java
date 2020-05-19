package org.oj.entity;

import lombok.Data;

@Data
public class RunCode {
    private String eid;
    private String uid;
    private LanguageType language;
    private String data;
    private ExecCode status;
}

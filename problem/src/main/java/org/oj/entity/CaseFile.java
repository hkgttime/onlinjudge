package org.oj.entity;

import java.util.Date;

public class CaseFile {
    private String cid;
    private String problemId;
    private String userId;
    private String temName;
    private String temPath;
    private Date creatDate;

    public CaseFile() {
    }

    public CaseFile(String cid, String problemId, String userId, String temName, String temPath, Date creatDate) {
        this.cid = cid;
        this.problemId = problemId;
        this.userId = userId;
        this.temName = temName;
        this.temPath = temPath;
        this.creatDate = creatDate;
    }

    public String getCid() {
        return cid;
    }

    public String getProblemId() {
        return problemId;
    }

    public String getUserId() {
        return userId;
    }

    public String getTemName() {
        return temName;
    }

    public String getTemPath() {
        return temPath;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTemName(String temName) {
        this.temName = temName;
    }

    public void setTemPath(String temPath) {
        this.temPath = temPath;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }
}

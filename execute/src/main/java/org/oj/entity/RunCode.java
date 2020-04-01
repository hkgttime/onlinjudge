package org.oj.entity;

public class RunCode {

    private String eid;
    private String pid;
    private String uid;
    private String language;
    private String data;
    private int status;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPid() {
        return pid;
    }

    public String getUid() {
        return uid;
    }

    public String getLanguage() {
        return language;
    }

    public String getData() {
        return data;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setData(String data) {
        this.data = data;
    }
}

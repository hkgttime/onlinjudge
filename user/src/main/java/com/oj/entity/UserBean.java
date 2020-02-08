package com.oj.entity;

import java.util.Date;

public class UserBean {
    private long uid;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String motto;
    private int commitTotal;
    private int acceptedTotal;
    private int status;
    private Date creatDate;

    public UserBean(){}

    public UserBean(long uid, String name, String password, String email, String phone, String motto, int commitTotal, int acceptedTotal, int status, Date creatDate) {
        this.uid = uid;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.motto = motto;
        this.commitTotal = commitTotal;
        this.acceptedTotal = acceptedTotal;
        this.status = status;
        this.creatDate = creatDate;
    }

    public long getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMotto() {
        return motto;
    }

    public int getCommitTotal() {
        return commitTotal;
    }

    public int getAcceptedTotal() {
        return acceptedTotal;
    }

    public int getStatus() {
        return status;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public void setCommitTotal(int commitTotal) {
        this.commitTotal = commitTotal;
    }

    public void setAcceptedTotal(int acceptedTotal) {
        this.acceptedTotal = acceptedTotal;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }
}

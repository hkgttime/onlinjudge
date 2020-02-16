package com.oj.entity;

import java.util.Date;

public class UserBean{

    private String uuid;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String motto;
    private int commitTotal;
    private int acceptedTotal;
    private int status;
    private Date creatDate;

    public String getUuid() {
        return uuid;
    }

    public UserBean(){}


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

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

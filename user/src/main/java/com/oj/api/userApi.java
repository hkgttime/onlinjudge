package com.oj.api;


import com.oj.entity.userBean;

public interface userApi {
    int creatUser(userBean userBean);
    int delUser(long uid, String name);
    userBean login(String name, String password);
    int logout(userBean userBean);
    userBean update(userBean userBean);
}

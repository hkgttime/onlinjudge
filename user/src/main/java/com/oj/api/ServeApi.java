package com.oj.api;

import com.oj.entity.UserBean;

public interface ServeApi {
    int createUserServe(UserBean user);
    int delUserServe(long uid, String name);
    UserBean loginServe(String name, String password);
    int logoutServe(UserBean userBean);
    UserBean updateServe(UserBean userBean);
}

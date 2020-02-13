package com.oj.api;

import com.oj.entity.UserBean;

public interface UserServeApi {
    int createUserServe(String email, String verificationCode);
    int delUserServe(long uid, String name);
    UserBean loginServe(String name, String password);
    int logoutServe(UserBean userBean);
    UserBean updateServe(UserBean userBean);
    void sendActivationUserMail(UserBean user);
}

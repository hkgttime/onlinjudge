package com.oj.api;

import com.oj.entity.UserBean;

public interface UserApi {
    int creatUser(UserBean userBean);
    int delUser(long uid, String name);
    UserBean login(String name, String password);
    int logout(UserBean userBean);
    UserBean update(UserBean userBean);
}

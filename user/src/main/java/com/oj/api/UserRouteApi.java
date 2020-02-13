package com.oj.api;

import com.oj.entity.Restful;
import com.oj.entity.UserBean;

public interface UserRouteApi {
    Restful createUser(String email, String verificationCode);
    Restful delUser(long uid, String name);
    Restful login(String name, String password);
    Restful logout(UserBean userBean);
    Restful update(UserBean userBean);
    Restful getMail(String name, String password, String email);
}

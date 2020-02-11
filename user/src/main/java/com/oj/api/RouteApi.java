package com.oj.api;

import com.oj.entity.Restful;
import com.oj.entity.UserBean;

public interface RouteApi {
    Restful createUser(UserBean userBean);
    Restful delUser(long uid, String name);
    Restful login(String name, String password);
    Restful logout(UserBean userBean);
    Restful update(UserBean userBean);
}

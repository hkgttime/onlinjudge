package com.oj.api;

import com.oj.entity.Restful;
import com.oj.entity.UserBean;

import javax.servlet.http.HttpServletRequest;

public interface UserRouteApi {
    Restful activateAccount(HttpServletRequest request);
    Restful delUser(String uid, String name);
    Restful login(String name, String password);
    Restful logout(String token);
    Restful update(String newpassword);
    Restful createAccount(UserBean user);
    Restful getProfile(String name);
}

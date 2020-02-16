package com.oj.api;

import com.oj.entity.UserBean;
import io.jsonwebtoken.Claims;

import java.util.Map;

public interface UserServeApi {
    int createUserServe(Claims claims);
    int delUserServe();
    Map<String, Object> loginServe(String email, String password);
    int logoutServe();
    UserBean updateServe(String newpassword);
    int sendActivateEmail(UserBean user);
}

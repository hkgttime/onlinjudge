package com.oj.api;

import com.oj.entity.UserBean;
import io.jsonwebtoken.Claims;

import java.util.ArrayList;
import java.util.Map;

public interface UserServiceApi {
    default int createUserServe(Claims claims) {
        return 0;
    }

    default int delUserServe(Claims claims) {
        return 0;
    }

    default Map<String, Object> loginServe(String email, String password) {
        return null;
    }

    default int logoutServe() {
        return 0;
    }

    default UserBean updateServe(String newpassword) {
        return null;
    }

    default int sendActivateEmail(UserBean user) {
        return 0;
    }

    default ArrayList<UserBean> getList(int page) {
        return null;
    }
}
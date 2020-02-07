package com.oj.controll;

import com.oj.api.userApi;
import com.oj.entity.userBean;

public class userController implements userApi {
    @Override
    public int creatUser(userBean userBean) {
        return 0;
    }

    @Override
    public int delUser(long uid, String name) {
        return 0;
    }

    @Override
    public userBean login(String name, String password) {
        return null;
    }

    @Override
    public int logout(userBean userBean) {
        return 0;
    }

    @Override
    public userBean update(userBean userBean) {
        return null;
    }
}

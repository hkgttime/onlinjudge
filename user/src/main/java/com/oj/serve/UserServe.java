package com.oj.serve;

import com.oj.api.ServeApi;
import com.oj.mapper.UserDataMapper;
import com.oj.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServe implements ServeApi {

    @Autowired
    private UserDataMapper userDataMapper;

    @Override
    public int createUserServe(UserBean user) {

        return 0;
    }

    @Override
    public int delUserServe(long uid, String name) {
        return 0;
    }

    @Override
    public UserBean loginServe(String name, String password) {
        return null;
    }

    @Override
    public int logoutServe(UserBean userBean) {
        return 0;
    }

    @Override
    public UserBean updateServe(UserBean userBean) {
        return null;
    }
}

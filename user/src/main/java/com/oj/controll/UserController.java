package com.oj.controll;

import com.oj.api.UserApi;
import com.oj.entity.UserBean;
import org.springframework.stereotype.Controller;

@Controller("userController")
public class UserController implements UserApi {
    @Override
    public int creatUser(UserBean userBean) {
        return 0;
    }

    @Override
    public int delUser(long uid, String name) {
        return 0;
    }

    @Override
    public UserBean login(String email, String password) {

        return null;
    }

    @Override
    public int logout(UserBean userBean) {
        return 0;
    }

    @Override
    public UserBean update(UserBean userBean) {
        return null;
    }
}

package com.oj.controll;

import com.oj.api.RouteApi;
import com.oj.entity.Restful;
import com.oj.entity.UserBean;
import com.oj.serve.UserServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/*")
public class UserController implements RouteApi {

    @Autowired
    private UserServe userServe;

    @Override
    @RequestMapping("create")
    public Restful createUser(UserBean userBean) {
        userServe.createUserServe(userBean);
        return null;
    }

    @Override
    public Restful delUser(long uid, String name) {
        return null;
    }

    @Override
    public Restful login(String email, String password) {

        return null;
    }

    @Override
    public Restful logout(UserBean userBean) {
        return null;
    }

    @Override
    public Restful update(UserBean userBean) {
        return null;
    }
}

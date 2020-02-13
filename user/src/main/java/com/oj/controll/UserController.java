package com.oj.controll;

import com.oj.api.UserRouteApi;
import com.oj.entity.Restful;
import com.oj.entity.RestfulCode;
import com.oj.entity.UserBean;
import com.oj.serve.UserServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user/")
public class UserController implements UserRouteApi {

    @Autowired
    private UserServe userServe;

    @Override
    @PostMapping("create")
    public Restful createUser(String email, String verificationCode) {
        Restful restfulUser = new Restful();
        int res = userServe.createUserServe(email, verificationCode);
        restfulUser.setResponseCode(RestfulCode.OJ_OK);
        restfulUser.setMsg("request successfully");
        restfulUser.setData(res);
        return restfulUser;
    }

    @Override
    @GetMapping("delete")
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

    @Override
    @PostMapping("mail")
    public Restful getMail(String name, String password, String email) {
        UserBean userBean = new UserBean();
        Restful restfulUser = new Restful();
        userBean.setEmail(email);
        userBean.setName(name);
        userBean.setPassword(password);
        userServe.sendActivationUserMail(userBean);
        restfulUser.setResponseCode(RestfulCode.OJ_OK);
        restfulUser.setMsg("request successfully");
        return restfulUser;
    }
}

package com.oj.controll;

import com.oj.api.UserRouteApi;
import com.oj.entity.Restful;
import com.oj.entity.RestfulCode;
import com.oj.entity.UserBean;
import com.oj.serve.UserServe;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/user/")
public class UserController implements UserRouteApi {

    @Autowired
    private UserServe userServe;

    @Override
    @PostMapping("activate")
    public Restful activateAccount(HttpServletRequest request) {
        Restful restfulUser = new Restful();
        Claims claims = (Claims) request.getAttribute("claims");
        int res = userServe.createUserServe(claims);
        restfulUser.setResponseCode(RestfulCode.OJ_OK);
        restfulUser.setMsg("request successfully");
        restfulUser.setData(res);
        return restfulUser;
    }

    @Override
    @GetMapping("delete")
    public Restful delUser(String uid, String name) {

        return null;
    }

    @Override
    @RequestMapping("login")
    public Restful login(String email, String password) {

        return null;
    }

    @Override
    public Restful logout(@RequestHeader("Authorization") String token) {
        return null;
    }

    @Override
    public Restful update(String newpassword) {
        return null;
    }

    @Override
    @PostMapping("create")
    public Restful createAccount(UserBean user) {
        Restful restfulUser = new Restful();
        System.out.println(user.getName());
        int ret = userServe.sendActivateEmail(user);
        if (ret == 0){
            restfulUser.setResponseCode(RestfulCode.OJ_FAIL);
            restfulUser.setMsg("serve error");
        }
        restfulUser.setResponseCode(RestfulCode.OJ_OK);
        restfulUser.setMsg("request successfully");
        return restfulUser;
    }

    @Override
    @RequestMapping("profile/{name}")
    public Restful getProfile(@PathVariable("name") String name) {

        return null;
    }
}

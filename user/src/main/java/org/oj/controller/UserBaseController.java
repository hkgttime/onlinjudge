package org.oj.controller;

import org.oj.api.UserControllerApi;
import org.oj.entity.ReslutCode;
import org.oj.entity.Restful;
import org.oj.entity.UserBean;
import org.oj.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user/")
public class UserBaseController implements UserControllerApi {

    @Autowired
    private UserService userServe;
    Restful result = new Restful();

    @Override
    @PostMapping("activate")
    public Restful activateAccount(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("claims");
        int res = userServe.createUserServe(claims);
        if (res == 0){
            result.setReslutCode(ReslutCode.E_1000);
            return result;
        }
        result.setReslutCode(ReslutCode.OK_0000);
        return result;
    }

    @Override
    @GetMapping("delete")
    public Restful delUser(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("claims");
        int res = userServe.delUserServe(claims);
        if (res == 0){
            result.setReslutCode(ReslutCode.E_1000);
            return result;
        }
        result.setReslutCode(ReslutCode.OK_0000);
        return result;
    }

    @Override
    @RequestMapping("login")
    public Restful login(String email, String password) {
        Map map = userServe.loginServe(email, password);
        if (map == null){
            return new Restful(ReslutCode.E_1000, null);
        }
        return new Restful(ReslutCode.OK_0000, map);
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
    public Restful createAccount(UserBean user) throws MessagingException {
        int ret = userServe.sendActivateEmail(user);
        result.setReslutCode(ReslutCode.OK_0000);
        return result;
    }

    @Override
    @RequestMapping("profile/{uuid}")
    public Restful getProfile(@PathVariable("uuid") String uuid, @RequestHeader("Authorization") String authorization) {
        UserBean user = userServe.getUser(uuid);
        Restful restful = new Restful();
        if (authorization == null){
            restful.setReslutCode(ReslutCode.OK_0000);
            restful.setData(user);
            return restful;
        }
        Map map = new HashMap();
        map.put("flag", 1);
        map.put("data", user);
        restful.setData(map);
        restful.setReslutCode(ReslutCode.OK_0000);
        return restful;
    }
}

package org.oj.controller;

import io.jsonwebtoken.Claims;
import org.oj.api.UserControllerApi;
import org.oj.entity.Restful;
import org.oj.entity.ResultCode;
import org.oj.entity.UserBase;
import org.oj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
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
            result.setResultCode(ResultCode.Failed);
            return result;
        }
        result.setResultCode(ResultCode.OK);
        return result;
    }

    @Override
    @GetMapping("delete")
    public Restful delUser(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("claims");
        int res = userServe.delUserServe(claims);
        if (res == 0){
            result.setResultCode(ResultCode.Failed);
            return result;
        }
        result.setResultCode(ResultCode.OK);
        return result;
    }

    @Override
    @PostMapping("login")
    public Restful login(String email, String password) {
        Map<String, Object> profile = userServe.loginServe(email, password);
        if (profile == null){
            return new Restful(ResultCode.C_20101, null);
        }
        return new Restful(ResultCode.OK, profile);
    }


    @Override
    @PostMapping("update")
    public Restful update(UserBase user) {
        return null;
    }

    @Override
    @PostMapping("verificationcodes")
    public Restful sendVC(String email) throws MessagingException {
        int ret = userServe.sendVCtoEmail(email);
        result.setReslutCode(ReslutCode.OK_0000);
        return result;
    }

    @Override
    @RequestMapping("profile/{uuid}")
    public Restful getProfile(@PathVariable("uuid") String uuid) {
        UserBase user = userServe.getUser(uuid);
        Restful restful = new Restful();
        restful.setData(user);
        restful.setReslutCode(ReslutCode.OK_0000);
        return restful;
    }
}

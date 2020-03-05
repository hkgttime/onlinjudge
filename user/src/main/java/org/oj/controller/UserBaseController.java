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
            result.setResultCode(ResultCode.Failed.getCode());
            result.setResultMsg(ResultCode.Failed.getMsg());
            return result;
        }
        result.setResultCode(ResultCode.OK.getCode());
        result.setResultMsg(ResultCode.OK.getMsg());
        return result;
    }

    @Override
    @GetMapping("delete")
    public Restful delUser(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("claims");
        int res = userServe.delUserServe(claims);
        if (res == 0){
            result.setResultCode(ResultCode.Failed.getCode());
            result.setResultMsg(ResultCode.Failed.getMsg());
            return result;
        }
        result.setResultCode(ResultCode.OK.getMsg());
        result.setResultMsg(ResultCode.OK.getMsg());
        return result;
    }

    @Override
    @PostMapping("login")
    public Restful login(String email, String password) {
        Map<String, Object> profile = userServe.loginServe(email, password);
        if (profile == null){
            return new Restful(ResultCode.user_not_exists.getCode(), ResultCode.user_not_exists.getMsg(), null);
        }
            return new Restful(ResultCode.OK.getCode(),ResultCode.OK.getMsg(), profile);
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
        if (ret == 0){
             result.setResultCode(ResultCode.username_used.getCode());
             result.setResultMsg(ResultCode.user_not_exists.getMsg());
             return result;
        }
        result.setResultCode(ResultCode.OK.getCode());
        result.setResultMsg(ResultCode.OK.getMsg());
        return result;
    }

    @Override
    @RequestMapping("profile/{uuid}")
    public Restful getProfile(@PathVariable("uuid") String uuid) {
        UserBase user = userServe.getUser(uuid);
        Restful restful = new Restful();
        restful.setData(user);
        restful.setResultCode(ResultCode.OK.getCode());
        restful.setResultMsg(ResultCode.OK.getMsg());
        return restful;
    }
}

package com.oj.route;

import com.oj.controll.userController;
import com.oj.entity.userBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
class userRouter {

    @Value("userController")
    userController userController;

    @RequestMapping("login")
    public userBean login(String email, String password){


        return null;
    }

}

package com.oj.route;

import com.oj.controll.UserController;
import com.oj.entity.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/*")
class UserRouter {

    @Autowired
    @Qualifier("userController")
    private UserController userController;

    @RequestMapping("login")
    public UserBean login(String email, String password){


        return null;
    }

}

package com.oj.conf;


import com.oj.entity.UserBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConf {

    public UserBean userBean(){
        return new UserBean();
    }
}

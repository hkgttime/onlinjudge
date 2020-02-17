package com.oj.conf;

import com.oj.Interceptor.JwtVerifyInt;
import com.oj.Interceptor.UserDataFormatCheckInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserWebMvcConf implements WebMvcConfigurer {

    @Autowired
    private UserDataFormatCheckInt userDataVerification;
    @Autowired
    private JwtVerifyInt jwtVerifyInt;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List excludePath = new ArrayList();
        excludePath.add("login");
        excludePath.add("create");
        excludePath.add("profile/*");
       registry.addInterceptor(jwtVerifyInt).addPathPatterns("/user/*")
               .excludePathPatterns(excludePath);
       registry.addInterceptor(userDataVerification).addPathPatterns("/user/login")
               .addPathPatterns("/user/create");

    }
}

package com.oj.conf;

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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      //  registry.addInterceptor(interceptor).addPathPatterns("/user/*");
        List<String> list = new ArrayList<String>();
        list.add("user/login");
        list.add("user/mail");
        //registry.addInterceptor(userDataVerification).addPathPatterns(list);
    }
}

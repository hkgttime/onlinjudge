package org.oj.conf;

import org.oj.Interceptor.JwtVerifyInt;
import org.oj.Interceptor.RankListInt;
import org.oj.Interceptor.UserDataFormatCheckInt;
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
    @Autowired
    private RankListInt rankListInt;

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
       registry.addInterceptor(rankListInt).addPathPatterns("/ranlist");

    }
}

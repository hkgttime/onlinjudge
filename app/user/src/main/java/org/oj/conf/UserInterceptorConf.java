package org.oj.conf;

import org.oj.Interceptor.JwtVerifyInt;
import org.oj.Interceptor.UserDataFormatCheckInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserInterceptorConf implements WebMvcConfigurer {

    @Autowired
    private UserDataFormatCheckInt userDataVerification;
    @Autowired
    private JwtVerifyInt jwtVerifyInt;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
/*        List<String> excludePath = new ArrayList();
        excludePath.add("login");
        excludePath.add("create/");
        excludePath.add("profile/*");*/
        registry.addInterceptor(jwtVerifyInt).addPathPatterns("/user/update");
        //    .excludePathPatterns(excludePath);
        //registry.addInterceptor(userDataVerification).addPathPatterns("/user/login")
        //    .addPathPatterns("/user/create");
    }
}

package org.oj.Interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.oj.entity.Restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserDataFormatCheckInt implements HandlerInterceptor {

    Restful res;
    @Autowired
    private ObjectMapper objectMapper;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean tag = true;
        if (email == null || !email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            tag = false;
        }
        if (password == null || !(password.length() > 6 && password.length() < 16)) {
            tag = false;
        }
        return tag;
    }

}

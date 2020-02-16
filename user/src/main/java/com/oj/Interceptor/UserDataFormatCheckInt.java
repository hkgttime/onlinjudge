package com.oj.Interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oj.entity.Restful;
import com.oj.entity.RestfulCode;
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
        if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            res.setResponseCode(RestfulCode.OJ_NF);
            res.setMsg("Illegal email address");
            String str = objectMapper.writeValueAsString(res);
            response.getWriter().write(str);
            response.getWriter().close();
            tag = false;
        }
        if (!(password.length() > 6 && password.length() < 16)){
            res.setResponseCode(RestfulCode.OJ_NF);
            res.setMsg("Illegal password");
            String str = objectMapper.writeValueAsString(res);
            response.getWriter().write(str);
            response.getWriter().close();
            tag = false;
        }
        return tag;
    }

}

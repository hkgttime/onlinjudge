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
public class UserInterceptor implements HandlerInterceptor {

    @Autowired
    private ObjectMapper objectMapper;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String user = (String)request.getSession().getAttribute("name");
        if (user == null){
            Restful res = new Restful();
            res.setResponseCode(RestfulCode.OJ_NF);
            res.setMsg("user is not logged in");
            String jsonStr = objectMapper.writeValueAsString(res);
            response.getWriter().write(jsonStr);
            response.getWriter().close();
            return false;
        }
        return true;
    }
}

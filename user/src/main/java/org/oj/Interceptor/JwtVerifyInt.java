package org.oj.Interceptor;

import org.oj.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtVerifyInt implements HandlerInterceptor {

    @Autowired
    private JwtUtils jwt;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String authorization = request.getHeader("Authorization");
        if (!authorization.isEmpty() && authorization.startsWith("Bearer") ){
            String token = authorization.replace("Bearer", "");
            Claims claims = jwt.parseJWT(token);
            request.setAttribute("claims", claims);
            return true;
        }
        return false;
    }
}

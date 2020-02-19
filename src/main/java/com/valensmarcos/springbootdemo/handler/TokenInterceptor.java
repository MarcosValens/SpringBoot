package com.valensmarcos.springbootdemo.handler;


import com.valensmarcos.springbootdemo.manager.TokenManager;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    TokenManager tokenManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String auth = request.getHeader("Authorization");
            if (auth != null && !auth.isEmpty()) {
                String token = auth.replace("Bearer", "");
                boolean valid = tokenManager.validateToken(token);
                if (!valid) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return false;
                } else {
                    response.setStatus(HttpServletResponse.SC_OK);
                    //response.setHeader("token");
                }
            }
            return true;
        } catch (JwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
        return false;
    }
}

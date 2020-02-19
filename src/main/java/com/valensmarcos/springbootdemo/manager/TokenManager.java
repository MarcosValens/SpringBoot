package com.valensmarcos.springbootdemo.manager;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenManager {
    private static final String SECRET_KEY = "passwordsecreteo";
    public String createToken(String user) {
        return Jwts.builder()
                .claim("username", user)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(SECRET_KEY))
                .compact();
    }
    public boolean validateToken(String token){
        try{
            Claims claims = Jwts
                    .parser()
                    .setSigningKey(SECRET_KEY.getBytes())
                    .parseClaimsJws(token)
                    .getBody();
            return claims != null;
        } catch (Exception e){
            return false;
        }
    }
}

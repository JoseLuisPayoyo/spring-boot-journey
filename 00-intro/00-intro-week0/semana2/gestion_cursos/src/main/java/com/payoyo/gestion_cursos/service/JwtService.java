package com.payoyo.gestion_cursos.service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET_KEY = "mi_clave_super_secreta_para_firmar_tokens_backend_seguro!";

    //1. 
    private Key getSigninKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    //2. 
    public String extractUserName(String token){
        return extractClaim(token, Claims::getSubject);
    }

    //3.
    public <T> T extractClaim(String token, Function<Claims, T> resolver){
        final Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    //4. 
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigninKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //5. 
    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSigninKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //6. 
    public boolean isTokenValid(String token, String userEmail) {
    final String username = extractUserName(token);
        return (username.equals(userEmail) && !isTokenExpired(token));
    }


    //7. 
    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    
}

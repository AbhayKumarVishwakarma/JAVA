package com.abd.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.*;

public class JwtTokenGeneratorFilter extends OncePerRequestFilter {

    /**
     * Generate the JSON Web Token and add it to response Header
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication);
//        System.out.println("Generating token ...");
        if(authentication != null){
            SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes());
            String jwt = Jwts.builder()
                    .setIssuer("Abhay")
                    .setSubject("JWT Token")
                    .claim("username", authentication.getName())
                    .claim("authorities", popularAuthorities(authentication.getAuthorities()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime() + 86400000))
                    .signWith(key).compact();
//            System.out.println("Generated: -->  " + jwt);
            response.setHeader(SecurityConstants.JWT_HEADER, jwt);
        }
        filterChain.doFilter(request, response);
    }

    private String popularAuthorities(Collection<? extends GrantedAuthority> collection){
        Set<String> set = new HashSet<>();
        for(GrantedAuthority authority: collection){
            set.add(authority.getAuthority());
        }
        return String.join(",", set);
    }

    /**
     * Make sure that this filter will execute only once when client call the signIn api at first time
     * @param request
     * @return
     * @throws ServletException
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{
        return !request.getServletPath().equals("/employee/signIn");
    }
}

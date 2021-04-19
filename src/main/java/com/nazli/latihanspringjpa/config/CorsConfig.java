package com.nazli.latihanspringjpa.config;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CorsConfig extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.setHeader("Access-Controll-Allow-Origin", "*");
        response.setHeader("Access-Controll-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Controll-Allow-Headers", "Authorization, Content-Type, Cache-Control");
        response.setHeader("Access-Controll-Expose-Headers", "xsrf-token");

        if("OPTIONS".equals(request)){
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else{
            filterChain.doFilter(request, response);
        }
    }
}

package com.xams.skeleton.server.configuration.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class Custom2OncePerRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {
        System.out.println("============ Custom 2 OncePerRequestFilter before ================");
        filterChain.doFilter(request, response);
        System.out.println("============ Custom 2 OncePerRequestFilter after ================");
    }


}

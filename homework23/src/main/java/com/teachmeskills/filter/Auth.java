package com.teachmeskills.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
@WebFilter("/black/*")
public class Auth implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = servletRequest.getParameter("username");
        if(name == null || name.length()<5){
            servletRequest.getRequestDispatcher("/white/date").forward(servletRequest, servletResponse);
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}

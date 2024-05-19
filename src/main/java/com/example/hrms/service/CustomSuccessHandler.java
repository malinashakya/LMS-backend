package com.example.hrms.service;

import com.example.hrms.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;


import java.io.IOException;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        var authorities = authentication.getAuthorities();
        var role = authorities.stream().map(r -> r.getAuthority()).findFirst().orElse("");

        if ("ADMIN".equals(role)) {
            response.sendRedirect("/admin-page");
        } else if ("USER".equals(role)) {
            response.sendRedirect("/user-page");
        } else {
            response.sendRedirect("/error");
        }

    }
}

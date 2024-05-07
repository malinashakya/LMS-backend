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

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        var authorities = authentication.getAuthorities();
        var roles = authorities.stream().map(r -> r.getAuthority()).findFirst();

        if (roles.orElse("").equals("ADMIN")) {
            response.sendRedirect("/admin-page");
        } else if (roles.orElse("").equals("USER")) {
            response.sendRedirect("/user-page");
        } else {
            response.sendRedirect("/error");
        }

        // Retrieve user details
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(authentication.getName());
        if (userDetails instanceof User) {
            User user = (User) userDetails;
            Long userId = user.getId();
            String username = user.getFullname();

            // Store user details in session
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            session.setAttribute("username", username);
        }
    }
}

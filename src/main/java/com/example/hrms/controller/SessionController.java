package com.example.hrms.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SessionController {

    @GetMapping("/api/session")
    public SessionInfo getSessionInfo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        String username = (String) session.getAttribute("username");
        return new SessionInfo(userId, username);
    }

    // Inner class representing session info
    static class SessionInfo {
        private Long userId;
        private String username;

        public SessionInfo(Long userId, String username) {
            this.userId = userId;
            this.username = username;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}

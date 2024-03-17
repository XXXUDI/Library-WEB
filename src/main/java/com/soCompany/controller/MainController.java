package com.soCompany.controller;

import com.soCompany.mapper.UserManagementMapper;
import com.soCompany.mapper.UserReadMapper;
import com.soCompany.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final UserService userService;
    private final UserManagementMapper userManagementMapper;
    private final UserReadMapper userReadMapper;

    @GetMapping("/assets/user/overview")
    public String userOverviewPage(@AuthenticationPrincipal UserDetails userDetails,
                       Model model,
                       HttpServletRequest request) {
        return userService.findByUsername(userDetails.getUsername()).map(user -> {
            model.addAttribute("User", user);
            return "assets/home-page";
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/")
    public String mainPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails != null) {
            userService.findByUsername(userDetails.getUsername()).ifPresent(user -> {
                model.addAttribute("User", user);
            });
        }
        return "main/main-page";
    }

}

package com.soCompany.controller;

import com.soCompany.dto.UserReadDto;
import com.soCompany.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class LoginController {
    private final UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(Model model,
                        @ModelAttribute UserReadDto userReadDto) {
        return "user/main";
    }
}

package com.soCompany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class RegistrationController {
    @GetMapping("/registration")
    public String registrationPage(@RequestParam(required = false) String ref) {
        return "#";
    }


}

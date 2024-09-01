package com.zhm.springboot.springmvcsecurity.mvcSecutity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginForm")
    public String showLoginForm(){
        return "fancy-login";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "denied";
    }
}

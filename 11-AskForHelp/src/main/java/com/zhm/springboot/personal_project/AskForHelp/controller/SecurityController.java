package com.zhm.springboot.personal_project.AskForHelp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    @RequestMapping("/login")
    public String showLogin(){
        return "login";
    }

    @RequestMapping("/accessDenied")
    public String showAccessDenied(){
        return "accessDenied";
    }
}

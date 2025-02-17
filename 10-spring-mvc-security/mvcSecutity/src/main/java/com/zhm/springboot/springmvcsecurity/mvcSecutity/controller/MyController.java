package com.zhm.springboot.springmvcsecurity.mvcSecutity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeaders(){
        return "leaders";
    }

    @GetMapping("/systems")
    public String showSystems(){
        return "systems";
    }
}

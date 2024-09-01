package com.zhm.springboot.springmvc.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class anotherController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "showForm";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "processForm";
    }

    @RequestMapping("/processForm2.0")
    public String processForm2_0(HttpServletRequest request, Model theModel){
        String theName = request.getParameter("studentName");
        String result = theName.toUpperCase();
        result = "Yo! " + result;
        theModel.addAttribute("message", result);
        return "processForm2_0";
    }

    @RequestMapping("/processForm3.0")
    public String processForm2_0(@RequestParam("studentName") String theName, Model theModel){
        String result = theName.toUpperCase();
        result = "Should we go for a coffee " + result + "?";
        theModel.addAttribute("message", result);
        return "processForm3_0";
    }

}

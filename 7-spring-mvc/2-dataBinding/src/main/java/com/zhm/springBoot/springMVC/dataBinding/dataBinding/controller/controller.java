package com.zhm.springBoot.springMVC.dataBinding.dataBinding.controller;

import com.zhm.springBoot.springMVC.dataBinding.dataBinding.elements.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class controller {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> OS;

    @RequestMapping("/studentForm")
    public String showStudentForm(Model theModel){

        // create a student object;
        Student theStudent = new Student();

        // add student object to the model
        theModel.addAttribute("theStudent", theStudent);

        // add the list of countries to the model
        theModel.addAttribute("countries", countries);

        // add the list of favourite languages to the model
        theModel.addAttribute("languages", languages);

        // add the list of OS to the model
        theModel.addAttribute("OS", OS);

        return "student_form";
    }

    @RequestMapping("/result")
    public String showResult(@ModelAttribute("theStudent") Student aStudent){
        return "result";
    }
}

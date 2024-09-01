package com.zhm.springboot.personalProject.personalProject.contoller;

import com.zhm.springboot.personalProject.personalProject.DAO.StudentDAO;
import com.zhm.springboot.personalProject.personalProject.entity.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class viewController {

    @Value("${nationalities}")
    public List<String> nationalities;

    @Value("${subjects}")
    public List<String> subjects;

    @Value("${semesters}")
    public List<Integer> semesters;

    public StudentDAO studentDAO;

    @Autowired
    public viewController(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    // add @InitBinder to remove all the leading and trailing whitespaces from all the web request happening
    @InitBinder
    public void trimmer(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/")
    public String homePage(){
        return "home";
    }

    @RequestMapping("/registration")
    public String registrationPage(Model theModel){
        theModel.addAttribute("theStudent", new Student());
        theModel.addAttribute("nationalities", nationalities);
        theModel.addAttribute("subjects", subjects);
        theModel.addAttribute("semesters", semesters);
        return "registration";
    }

    @RequestMapping("/confirmation")
    public String confirmationPage(@Valid @ModelAttribute("theStudent") Student theStudent, BindingResult theBindingResult){
        if(theBindingResult.hasErrors()){
            return "registration";
        }
        else{
            // System.out.println(theStudent.toString());
            studentDAO.save(theStudent);
            return "confirmation";
        }
    }

}

package com.zhm.springboot.springmvc.validation.controller;

import com.zhm.springboot.springmvc.validation.elements.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    // add @InitBinder to remove all the leading and trailing whitespaces from all the web request happening
    @InitBinder
    public void trimmer(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model theModel){
        theModel.addAttribute("customer", new Customer());
        return "customer_form";
    }

    @RequestMapping("/confirmation")
    public String confirmationForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult){
        // System.out.println("Last name : |" + theCustomer.getLastName() + "|");
        // System.out.println("Postal Code : |" + theCustomer.getPostalCode() + "|");
        if(theBindingResult.hasErrors())
            return "customer_form";
        else
            return "confirmation_form";
    }

}

package com.zhm.springboot.personal_project.AskForHelp.controller;

import com.zhm.springboot.personal_project.AskForHelp.entity.Query;
import com.zhm.springboot.personal_project.AskForHelp.services.QueryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {

    private QueryService theQueryService;

    @Autowired
    public MyController(QueryService theQueryService){
        this.theQueryService = theQueryService;
    }

    @RequestMapping("/")
    public String showHome(Model theModel){
        List<Query> queries = theQueryService.findAll();
        theModel.addAttribute("queries", queries);
        return "home";
    }

    @RequestMapping("/add")
    public String showAdd(Model theModel){
        Query theQuery = new Query();
        theModel.addAttribute("theQuery", theQuery);
        return "add";
    }

    @RequestMapping("/added")
    public String showAdded(@Valid @ModelAttribute("theQuery") Query theQuery, BindingResult res){
        if(res.hasErrors()){
            return "add";
        }
        else{
            theQuery.setStatus("Active");
            theQueryService.save(theQuery);
            return "added";
        }
    }

    @RequestMapping("/edit")
    public String showEdit(@RequestParam("id") int id, Model theModel){
        Query theQuery = theQueryService.findById(id);
        theModel.addAttribute("theQuery", theQuery);
        return "add";
    }

    @RequestMapping("/delete")
    public String showDelete(@RequestParam("id") int id){
        theQueryService.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/request")
    public String showRequest(@RequestParam("id") int id){
        Query theQuery = theQueryService.findById(id);
        theQuery.setStatus("Requested");
        theQueryService.save(theQuery);
        return "redirect:/";
    }

    @RequestMapping("/completed")
    public String showCompleted(@RequestParam("id") int id){
        Query theQuery = theQueryService.findById(id);
        theQuery.setStatus("Done");
        theQueryService.save(theQuery);
        return "redirect:/";
    }
}

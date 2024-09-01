package com.zhm.springboot.springmvc.thymeleaf.controller;

import com.zhm.springboot.springmvc.thymeleaf.entity.Employee;
import com.zhm.springboot.springmvc.thymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class employeeController {

    private EmployeeService employeeService;

    @Autowired
    public employeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        // get the employees from database
        List<Employee> theEmployees = employeeService.findAll();

        // add the data to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

    @GetMapping("/addEmployeeForm")
    public String addEmployeeForm(Model theModel){

        // create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("theEmployee", theEmployee);

        return "employees/add-employee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("theEmployee") Employee theEmployee){
        employeeService.save(theEmployee);
        return "redirect:/employees/list";
    }

    @GetMapping("/updateEmployeeForm")
    public String updateEmployeeForm(@RequestParam("employeeId") int id, Model theModel){
        Employee theEmployee = employeeService.findById(id);
        theModel.addAttribute("theEmployee", theEmployee);
        return "employees/add-employee";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}

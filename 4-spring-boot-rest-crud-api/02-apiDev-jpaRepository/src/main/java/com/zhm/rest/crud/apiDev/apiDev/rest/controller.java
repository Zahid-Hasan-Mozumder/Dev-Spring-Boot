package com.zhm.rest.crud.apiDev.apiDev.rest;

import com.zhm.rest.crud.apiDev.apiDev.entity.employee;
import com.zhm.rest.crud.apiDev.apiDev.service.employeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class controller {

    // define employee service field
    private employeeService employeeService;

    // inject employee DAO through constructor injection
    public controller(employeeService employeeService){
        this.employeeService = employeeService;
    }

    // Read............................

    @GetMapping("/employees")
    public List<employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public employee getEmployee(@PathVariable int id){
        employee theEmployee = employeeService.findById(id);
        if(theEmployee == null){
            throw new RuntimeException("Employee not found of id - " + id);
        }
        return theEmployee;
    }

    // Create.................................

    @PostMapping("/employees")
    public employee addEmployee(@RequestBody employee theEmployee){
        theEmployee.setId(0);
        employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // Update.................................

    @PutMapping("/employees")
    public employee  updateEmployee(@RequestBody employee theEmployee){
        employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // Delete..................................

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteById(id);
        return "Id " + id + " removed successfully.....";
    }

}

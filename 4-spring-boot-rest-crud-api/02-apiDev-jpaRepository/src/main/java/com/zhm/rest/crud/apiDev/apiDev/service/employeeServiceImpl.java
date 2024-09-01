package com.zhm.rest.crud.apiDev.apiDev.service;


import com.zhm.rest.crud.apiDev.apiDev.entity.employee;
import com.zhm.rest.crud.apiDev.apiDev.springRepository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class employeeServiceImpl implements employeeService{

    // define employee DAO field
    private employeeRepository employeeRepo;

    // inject employee DAO using constructor injection
    @Autowired
    public employeeServiceImpl(employeeRepository employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    // implement all abstruct methods
    @Override
    public List<employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public employee findById(int theId) {
        Optional<employee> result = employeeRepo.findById(theId);
        employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }
        return theEmployee;
    }

    @Override
    public employee save(employee theEmployee) {
        return employeeRepo.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepo.deleteById(theId);
    }
}

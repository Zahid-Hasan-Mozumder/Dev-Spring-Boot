package com.zhm.rest.crud.apiDev.apiDev.service;

import com.zhm.rest.crud.apiDev.apiDev.DAO.employeeDAO;
import com.zhm.rest.crud.apiDev.apiDev.entity.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class employeeServiceImpl implements employeeService{

    // define employee DAO field
    private employeeDAO employeeDAO;

    // inject employee DAO using constructor injection
    @Autowired
    public employeeServiceImpl(employeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    // implement all abstruct methods
    @Override
    public List<employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public employee save(employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}

package com.zhm.rest.crud.apiDev.apiDev.DAO;

import com.zhm.rest.crud.apiDev.apiDev.entity.employee;

import java.util.List;

public interface employeeDAO {

    List<employee> findAll();

    employee findById(int theId);

    employee save(employee theEmployee);

    void deleteById(int theId);
}

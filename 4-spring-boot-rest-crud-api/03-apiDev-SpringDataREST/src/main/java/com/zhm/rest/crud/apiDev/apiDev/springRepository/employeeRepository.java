package com.zhm.rest.crud.apiDev.apiDev.springRepository;

import com.zhm.rest.crud.apiDev.apiDev.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "employees")
public interface employeeRepository extends JpaRepository<employee, Integer> {

}

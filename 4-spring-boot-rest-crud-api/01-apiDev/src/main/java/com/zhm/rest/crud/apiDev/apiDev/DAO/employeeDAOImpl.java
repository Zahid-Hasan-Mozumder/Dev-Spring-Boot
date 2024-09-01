package com.zhm.rest.crud.apiDev.apiDev.DAO;

import com.zhm.rest.crud.apiDev.apiDev.entity.employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class employeeDAOImpl implements employeeDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // constructor injection for entity manager
    @Autowired
    public employeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // implement all abstruct methods
    @Override
    public List<employee> findAll(){
        TypedQuery<employee> theQuery = entityManager.createQuery("FROM employee", employee.class);
        return theQuery.getResultList();
    }

    @Override
    public employee findById(int theId) {
        return entityManager.find(employee.class, theId);
    }

    @Override
    public employee save(employee theEmployee) {
        employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        employee theEmployee = entityManager.find(employee.class, theId);
        entityManager.remove(theEmployee);
    }


}

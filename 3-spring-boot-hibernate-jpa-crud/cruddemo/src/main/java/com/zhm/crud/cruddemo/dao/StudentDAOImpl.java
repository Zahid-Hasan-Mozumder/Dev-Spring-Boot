package com.zhm.crud.cruddemo.dao;

import com.zhm.crud.cruddemo.entity.student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // Inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // Implement the save method
    @Override
    @Transactional
    public void save(student theStudent) {
        entityManager.persist(theStudent);
    }
}
